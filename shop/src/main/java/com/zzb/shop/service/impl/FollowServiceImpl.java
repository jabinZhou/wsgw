package com.zzb.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzb.shop.dao.FollowMapper;
import com.zzb.shop.domain.Follow;
import com.zzb.shop.domain.Page;
import com.zzb.shop.service.FollowService;
import com.zzb.shop.util.PageData;

@Service
public class FollowServiceImpl implements FollowService{

	@Autowired
	private FollowMapper followMapper;

	@Override
	public int insert(Follow record) {
		// TODO Auto-generated method stub
		return followMapper.insert(record);
	}

	@Override
	public int insertSelective(Follow record) {
		// TODO Auto-generated method stub
		return followMapper.insertSelective(record);
	}

	@Override
	public List<PageData> list(Page page) {
		// TODO Auto-generated method stub
		return followMapper.list(page);
	}

	@Override
	public int listCount(Page page) {
		// TODO Auto-generated method stub
		return followMapper.listCount(page);
	}
}
