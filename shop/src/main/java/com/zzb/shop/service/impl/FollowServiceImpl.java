package com.zzb.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zzb.shop.dao.FollowMapper;
import com.zzb.shop.domain.Follow;
import com.zzb.shop.domain.Page;
import com.zzb.shop.service.FollowService;
import com.zzb.shop.util.PageData;

@Service
@Transactional(readOnly = true)
public class FollowServiceImpl implements FollowService{

	@Autowired
	private FollowMapper followMapper;

	@Override
	@Transactional(readOnly = false)
	public int insert(Follow record) {
		// TODO Auto-generated method stub
		return followMapper.insert(record);
	}

	@Override
	@Transactional(readOnly = false)
	public int delete(Follow record) {
		// TODO Auto-generated method stub
		return followMapper.deleteByPrimaryKey(record);
	}
	
	@Override
	@Transactional(readOnly = false)
	public int insertSelective(Follow record) {
		// TODO Auto-generated method stub
		return followMapper.insertSelective(record);
	}

	@Override
	public List<PageData> list(Page page) {
		// TODO Auto-generated method stub
		return followMapper.list(page);
	}

	@Override
	public int listCount(Page page) {
		// TODO Auto-generated method stub
		return followMapper.listCount(page);
	}

	@Override
	@Transactional(readOnly = false)
	public int follow(Follow record, Integer isFollow) {
		/**
		 * 0未关注 是否存在 否添加 是不处理
		 * 1已关注 是否存在 否不处理  是删除
		 */
		Follow follow=followMapper.selectFollow(record);
		if(isFollow==0){
			if(follow==null){
				return insert(record);
			}
			return 1;
		}else{
			if(follow!=null){
				return delete(record);
			}
			return 1;
		}
	}
}
