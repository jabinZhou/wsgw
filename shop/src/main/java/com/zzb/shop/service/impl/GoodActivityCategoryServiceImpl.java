package com.zzb.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzb.shop.dao.GoodActivityCategoryMapper;
import com.zzb.shop.domain.GoodActivityCategory;
import com.zzb.shop.service.GoodActivityCategoryService;

@Service
public class GoodActivityCategoryServiceImpl implements GoodActivityCategoryService{

	@Autowired
	private GoodActivityCategoryMapper goodActivityCategoryMapper;

	@Override
	public int deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return goodActivityCategoryMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(GoodActivityCategory record) {
		// TODO Auto-generated method stub
		return goodActivityCategoryMapper.insert(record);
	}

	@Override
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
	public int updateByPrimaryKeySelective(GoodActivityCategory record) {
		// TODO Auto-generated method stub
		return goodActivityCategoryMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(GoodActivityCategory record) {
		// TODO Auto-generated method stub
		return goodActivityCategoryMapper.updateByPrimaryKey(record);
	}
}
