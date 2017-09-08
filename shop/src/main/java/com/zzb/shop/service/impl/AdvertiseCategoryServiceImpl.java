package com.zzb.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzb.shop.dao.AdvertiseCategoryMapper;
import com.zzb.shop.domain.AdvertiseCategory;
import com.zzb.shop.service.AdvertiseCategoryService;
import com.zzb.shop.service.SysUserService;

@Service
public class AdvertiseCategoryServiceImpl implements AdvertiseCategoryService{

	@Autowired
	private AdvertiseCategoryMapper advertiseCategory;

	@Override
	public int deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return advertiseCategory.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(AdvertiseCategory record) {
		// TODO Auto-generated method stub
		return advertiseCategory.insert(record);
	}

	@Override
	public int insertSelective(AdvertiseCategory record) {
		// TODO Auto-generated method stub
		return advertiseCategory.insertSelective(record);
	}

	@Override
	public AdvertiseCategory selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return advertiseCategory.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(AdvertiseCategory record) {
		// TODO Auto-generated method stub
		return advertiseCategory.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(AdvertiseCategory record) {
		// TODO Auto-generated method stub
		return advertiseCategory.updateByPrimaryKey(record);
	}
}
