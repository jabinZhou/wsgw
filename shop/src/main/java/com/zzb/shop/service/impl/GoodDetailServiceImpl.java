package com.zzb.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzb.shop.dao.GoodDetailMapper;
import com.zzb.shop.domain.GoodDetail;
import com.zzb.shop.domain.Page;
import com.zzb.shop.service.GoodDetailService;
import com.zzb.shop.util.PageData;

@Service
public class GoodDetailServiceImpl implements GoodDetailService{

	@Autowired
	private GoodDetailMapper goodDetailMapper;

	@Override
	public int deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return goodDetailMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(GoodDetail record) {
		// TODO Auto-generated method stub
		return goodDetailMapper.insert(record);
	}

	@Override
	public int insertSelective(GoodDetail record) {
		// TODO Auto-generated method stub
		return goodDetailMapper.insertSelective(record);
	}

	@Override
	public GoodDetail selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return goodDetailMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(GoodDetail record) {
		// TODO Auto-generated method stub
		return goodDetailMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(GoodDetail record) {
		// TODO Auto-generated method stub
		return goodDetailMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<PageData> list(Page page) {
		// TODO Auto-generated method stub
		return goodDetailMapper.list(page);
	}

	@Override
	public int listCount(Page page) {
		// TODO Auto-generated method stub
		return goodDetailMapper.listCount(page);
	}
}
