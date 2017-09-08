package com.zzb.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzb.shop.dao.BannerMapper;
import com.zzb.shop.domain.Banner;
import com.zzb.shop.service.BannerService;

@Service
public class BannerServiceImpl implements BannerService{

	@Autowired
	private BannerMapper bannerMapper;

	@Override
	public int deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return bannerMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Banner record) {
		// TODO Auto-generated method stub
		return bannerMapper.insert(record);
	}

	@Override
	public int insertSelective(Banner record) {
		// TODO Auto-generated method stub
		return bannerMapper.insertSelective(record);
	}

	@Override
	public Banner selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return bannerMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Banner record) {
		// TODO Auto-generated method stub
		return bannerMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Banner record) {
		// TODO Auto-generated method stub
		return bannerMapper.updateByPrimaryKey(record);
	}
}
