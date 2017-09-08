package com.zzb.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzb.shop.dao.ShopCarMapper;
import com.zzb.shop.domain.ShopCar;
import com.zzb.shop.service.ShopCarService;

@Service
public class ShopCarServiceImpl implements ShopCarService{

	@Autowired
	private ShopCarMapper shopCarMapper;

	@Override
	public int deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return shopCarMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(ShopCar record) {
		// TODO Auto-generated method stub
		return shopCarMapper.insert(record);
	}

	@Override
	public int insertSelective(ShopCar record) {
		// TODO Auto-generated method stub
		return shopCarMapper.insertSelective(record);
	}

	@Override
	public ShopCar selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return shopCarMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(ShopCar record) {
		// TODO Auto-generated method stub
		return shopCarMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(ShopCar record) {
		// TODO Auto-generated method stub
		return shopCarMapper.updateByPrimaryKey(record);
	}
}
