package com.zzb.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzb.shop.dao.GoodCategoryMapper;
import com.zzb.shop.domain.GoodCategory;
import com.zzb.shop.domain.Page;
import com.zzb.shop.service.GoodCategoryService;
import com.zzb.shop.util.PageData;

@Service
public class GoodCategoryServiceImpl implements GoodCategoryService{

	@Autowired
	private GoodCategoryMapper goodCategoryMapper;

	@Override
	public int deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return goodCategoryMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(GoodCategory record) {
		// TODO Auto-generated method stub
		return goodCategoryMapper.insert(record);
	}

	@Override
	public int insertSelective(GoodCategory record) {
		// TODO Auto-generated method stub
		return goodCategoryMapper.insertSelective(record);
	}

	@Override
	public GoodCategory selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return goodCategoryMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(GoodCategory record) {
		// TODO Auto-generated method stub
		return goodCategoryMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(GoodCategory record) {
		// TODO Auto-generated method stub
		return goodCategoryMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<PageData> list(Page page) {
		// TODO Auto-generated method stub
		return goodCategoryMapper.list(page);
	}

	@Override
	public int listCount(Page page) {
		// TODO Auto-generated method stub
		return goodCategoryMapper.listCount(page);
	}
}
