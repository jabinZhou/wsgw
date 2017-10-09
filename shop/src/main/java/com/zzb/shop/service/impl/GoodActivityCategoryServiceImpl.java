package com.zzb.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zzb.shop.dao.GoodActivityCategoryMapper;
import com.zzb.shop.domain.BannerCategory;
import com.zzb.shop.domain.GoodActivityCategory;
import com.zzb.shop.domain.Page;
import com.zzb.shop.service.GoodActivityCategoryService;
import com.zzb.shop.util.PageData;
import com.zzb.shop.util.StringUtil;

@Service
@Transactional(readOnly = true)
public class GoodActivityCategoryServiceImpl implements GoodActivityCategoryService{

	@Autowired
	private GoodActivityCategoryMapper goodActivityCategoryMapper;

	@Override
	public int deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return goodActivityCategoryMapper.deleteByPrimaryKey(id);
	}

	@Override
	@Transactional(readOnly = false)
	public int insert(GoodActivityCategory record) {
		// TODO Auto-generated method stub
		//return goodActivityCategoryMapper.insert(record);
		
		boolean noPid=false;
		if(StringUtil.isNullOrEmpty(record.getParentId())||0==record.getParentId()){
			record.setParentId(0L);
			noPid=true;
		}
		int flag=goodActivityCategoryMapper.insert(record);
		if(flag>0){
			if(noPid){
				record.setParentIds(record.getParentId()+","+record.getId());
				updateByPrimaryKeySelective(record);
			}else{
				GoodActivityCategory pAC=selectByPrimaryKey(record.getParentId());
				record.setParentIds(pAC.getParentIds()+","+record.getId());
				updateByPrimaryKeySelective(record);
			}
		}
		return flag;
	}

	@Override
	@Transactional(readOnly = false)
	public int insertSelective(GoodActivityCategory record) {
		// TODO Auto-generated method stub
		return goodActivityCategoryMapper.insertSelective(record);
	}

	@Override
	public GoodActivityCategory selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return goodActivityCategoryMapper.selectByPrimaryKey(id);
	}

	@Override
	@Transactional(readOnly = false)
	public int updateByPrimaryKeySelective(GoodActivityCategory record) {
		
		boolean noPid=false;
		if(StringUtil.isNullOrEmpty(record.getParentId())||0==record.getParentId()){
			record.setParentId(0L);
			noPid=true;
		}
		if (noPid) {
			record.setParentIds(record.getParentId() + "," + record.getId());
		} else {
			GoodActivityCategory pAC = selectByPrimaryKey(record.getParentId());
			record.setParentIds(pAC.getParentIds() + "," + record.getId());
		}
		return goodActivityCategoryMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	@Transactional(readOnly = false)
	public int updateByPrimaryKey(GoodActivityCategory record) {
		// TODO Auto-generated method stub
		return goodActivityCategoryMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<PageData> list(Page page) {
		// TODO Auto-generated method stub
		return goodActivityCategoryMapper.list(page);
	}

	@Override
	public int listCount(Page page) {
		// TODO Auto-generated method stub
		return goodActivityCategoryMapper.listCount(page);
	}
}
