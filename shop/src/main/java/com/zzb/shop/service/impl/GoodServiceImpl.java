package com.zzb.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzb.shop.dao.GoodMapper;
import com.zzb.shop.domain.Good;
import com.zzb.shop.service.GoodService;

@Service
public class GoodServiceImpl implements GoodService{

	@Autowired
	private GoodMapper goodMapper;

	@Override
	public int deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return goodMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Good record) {
		// TODO Auto-generated method stub
		return goodMapper.insert(record);
	}

	@Override
	public int insertSelective(Good record) {
		// TODO Auto-generated method stub
		return goodMapper.insertSelective(record);
	}

	@Override
	public Good selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return goodMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Good record) {
		// TODO Auto-generated method stub
		return goodMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Good record) {
		// TODO Auto-generated method stub
		return goodMapper.updateByPrimaryKey(record);
	}
}