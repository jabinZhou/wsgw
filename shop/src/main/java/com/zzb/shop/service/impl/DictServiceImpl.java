package com.zzb.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzb.shop.dao.DictMapper;
import com.zzb.shop.domain.Dict;
import com.zzb.shop.service.DictService;

@Service
public class DictServiceImpl implements DictService{

	@Autowired
	private DictMapper dictMapper;

	@Override
	public int deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return dictMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Dict record) {
		// TODO Auto-generated method stub
		return dictMapper.insert(record);
	}

	@Override
	public int insertSelective(Dict record) {
		// TODO Auto-generated method stub
		return dictMapper.insertSelective(record);
	}

	@Override
	public Dict selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return dictMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Dict record) {
		// TODO Auto-generated method stub
		return dictMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Dict record) {
		// TODO Auto-generated method stub
		return dictMapper.updateByPrimaryKey(record);
	}
}