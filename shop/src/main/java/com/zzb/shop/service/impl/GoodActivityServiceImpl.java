package com.zzb.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzb.shop.dao.GoodActivityMapper;
import com.zzb.shop.domain.GoodActivity;
import com.zzb.shop.service.GoodActivityService;

@Service
public class GoodActivityServiceImpl implements GoodActivityService{

	@Autowired
	private GoodActivityMapper goodActivityMapper;

	@Override
	public int deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return goodActivityMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(GoodActivity record) {
		// TODO Auto-generated method stub
		return goodActivityMapper.insert(record);
	}

	@Override
	public int insertSelective(GoodActivity record) {
		// TODO Auto-generated method stub
		return goodActivityMapper.insertSelective(record);
	}

	@Override
	public GoodActivity selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return goodActivityMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(GoodActivity record) {
		// TODO Auto-generated method stub
		return goodActivityMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(GoodActivity record) {
		// TODO Auto-generated method stub
		return goodActivityMapper.updateByPrimaryKey(record);
	}
}
