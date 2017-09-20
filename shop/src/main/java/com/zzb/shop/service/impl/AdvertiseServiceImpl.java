package com.zzb.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzb.shop.dao.AdvertiseMapper;
import com.zzb.shop.domain.Advertise;
import com.zzb.shop.domain.Page;
import com.zzb.shop.service.AdvertiseService;
import com.zzb.shop.util.PageData;

@Service
public class AdvertiseServiceImpl implements AdvertiseService{

	@Autowired
	private AdvertiseMapper advertiseMapper;

	@Override
	public int deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return advertiseMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Advertise record) {
		// TODO Auto-generated method stub
		return advertiseMapper.insert(record);
	}

	@Override
	public int insertSelective(Advertise record) {
		// TODO Auto-generated method stub
		return advertiseMapper.insertSelective(record);
	}

	@Override
	public Advertise selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return advertiseMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Advertise record) {
		// TODO Auto-generated method stub
		return advertiseMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Advertise record) {
		// TODO Auto-generated method stub
		return advertiseMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<PageData> list(Page page) {
		// TODO Auto-generated method stub
		return advertiseMapper.list(page);
	}

	@Override
	public int listCount(Page page) {
		// TODO Auto-generated method stub
		return advertiseMapper.listCount(page);
	}
}
