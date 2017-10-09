package com.zzb.shop.service.impl;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zzb.shop.dao.DictMapper;
import com.zzb.shop.domain.City;
import com.zzb.shop.domain.Dict;
import com.zzb.shop.domain.Page;
import com.zzb.shop.service.DictService;
import com.zzb.shop.util.PageData;

@Service
@Transactional(readOnly = true)
public class DictServiceImpl implements DictService{
	
	 private static final Logger LOGGER = LoggerFactory.getLogger(DictServiceImpl.class);
	 
	 @Autowired
	 private RedisTemplate redisTemplate;

	@Autowired
	private DictMapper dictMapper;

	@Override
	@Transactional(readOnly = false)
	public int deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		int ret=dictMapper.deleteByPrimaryKey(id);
		delKey(id);
        return ret;
	}

	@Override
	@Transactional(readOnly = false)
	public int insert(Dict record) {
		// TODO Auto-generated method stub
		 int ret=dictMapper.insert(record);
		 insertKey(record.getKeyType());
		 return ret;
	}

	@Override
	@Transactional(readOnly = false)
	public int insertSelective(Dict record) {
		// TODO Auto-generated method stub
		int ret=dictMapper.insertSelective(record);
		insertKey(record.getKeyType());
		return ret;
	}

	@Override
	public Dict selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		
		 // 从缓存中获取字典信息
        String key = "dict_" + id;
        ValueOperations<String, Dict> operations = redisTemplate.opsForValue();

        // 缓存存在
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
        	Dict dict = operations.get(key);

            LOGGER.info("从缓存中获取了字典信息 >> " + dict.toString());
            return dict;
        }
        Dict dict=dictMapper.selectByPrimaryKey(id);
        if(dict!=null){
            // 插入缓存
             operations.set(key, dict, 10, TimeUnit.MINUTES);
             LOGGER.info("字典插入缓存 >> " + dict.toString());
        }   
		return  dict;
	}

	@Override
	public int updateByPrimaryKeySelective(Dict record) {
		// TODO Auto-generated method stub
		int ret=dictMapper.updateByPrimaryKeySelective(record);
		delKey(record.getId());
		return ret;
	}

	@Override
	@Transactional(readOnly = false)
	public int updateByPrimaryKey(Dict record) {
		// TODO Auto-generated method stub
		int ret=dictMapper.updateByPrimaryKey(record);
		delKey(record.getId());
		return ret;
	}

	@Override
	public List<PageData> list(Page page) {
		// TODO Auto-generated method stub
		
		PageData pd=page.getPd();
		if(pd!=null){
			String key = pd.getString("key"); // 检索条件 关键词
			if (null != key && !"".equals(key)) {
				// 从缓存中获取字典信息
		        String typeKey = "dict_"+key;
		        ValueOperations<String, List<PageData>> operations = redisTemplate.opsForValue();

		        // 缓存存在
		        boolean hasKey = redisTemplate.hasKey(typeKey);
		        if (hasKey) {
		        	List<PageData> list= operations.get(typeKey);
		            LOGGER.info("从缓存中获取了字典列表 >> " + list.toString());
		            return list;
		        }
		        List<PageData> list=dictMapper.list(page);
		        if(list!=null){
		            // 插入缓存
		             operations.set(typeKey, list, 10, TimeUnit.MINUTES);
		             LOGGER.info("字典列表插入缓存 >> " + list.toString());
		        }   
				return list;
			}
		}
		
		 // 从缓存中获取字典信息
        String key = "dict_all";
        ValueOperations<String, List<PageData>> operations = redisTemplate.opsForValue();

        // 缓存存在
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
        	List<PageData> list= operations.get(key);

            LOGGER.info("从缓存中获取了字典列表 >> " + list.toString());
            return list;
        }
        List<PageData> list=dictMapper.list(page);
        if(list!=null){
            // 插入缓存
             operations.set(key, list, 10, TimeUnit.MINUTES);
             LOGGER.info("字典列表插入缓存 >> " + list.toString());
        }   
		return list;
	}

	@Override
	public int listCount(Page page) {
		// TODO Auto-generated method stub
		return dictMapper.listCount(page);
	}
	/**
	 * 更新或者删除  删除缓存
	 * @param id
	 */
	public void delKey(Long id){
		// 缓存存在，删除缓存
        String key = "dict_" + id;
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            redisTemplate.delete(key);

            LOGGER.info(": 从缓存中删除字典 ID >> " + id);
        }
        String allKey="dict_all";
        boolean hasAllKey = redisTemplate.hasKey(allKey);
        if (hasAllKey) {
            redisTemplate.delete(allKey);

            LOGGER.info(": 从缓存中删除字典All >> " + id);
        }
        Dict dict=dictMapper.selectByPrimaryKey(id);
        String typeKey="dict_"+dict.getKeyType();
        boolean hasTypeKey = redisTemplate.hasKey(typeKey);
        if (hasTypeKey) {
            redisTemplate.delete(typeKey);
            LOGGER.info(": 从缓存中删除字典type >> " + typeKey);
        }
	}
	
	/**
	 * 插入   删除缓存
	 * @param id
	 */
	public void insertKey(String keyType){
        String allKey="dict_all";
        boolean hasAllKey = redisTemplate.hasKey(allKey);
        if (hasAllKey) {
            redisTemplate.delete(allKey);
            LOGGER.info(": 从缓存中删除字典All >> " );
        }
        String typeKey="dict_"+keyType;
        boolean hasTypeKey = redisTemplate.hasKey(typeKey);
        if (hasTypeKey) {
            redisTemplate.delete(typeKey);
            LOGGER.info(": 从缓存中删除字典type >> " + typeKey);
        }
	}
}
