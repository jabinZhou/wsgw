package com.zzb.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzb.shop.dao.BannerCategoryMapper;
import com.zzb.shop.domain.BannerCategory;
import com.zzb.shop.service.BannerCategoryService;

@Service
public class BannerCategoryServiceImpl implements BannerCategoryService{

	@Autowired
	private BannerCategoryMapper bannerCategoryMapper;

	@Override
	public int deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return bannerCategoryMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(BannerCategory record) {
		// TODO Auto-generated method stub
		return bannerCategoryMapper.insert(record);
	}

	@Override
	public int insertSelective(BannerCategory record) {
		// TODO Auto-generated method stub
		return bannerCategoryMapper.insertSelective(record);
	}

	@Override
	public BannerCategory selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return bannerCategoryMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(BannerCategory record) {
		// TODO Auto-generated method stub
		return bannerCategoryMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(BannerCategory record) {
		// TODO Auto-generated method stub
		return bannerCategoryMapper.updateByPrimaryKey(record);
	}
}