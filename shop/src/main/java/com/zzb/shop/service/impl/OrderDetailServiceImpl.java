package com.zzb.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzb.shop.dao.OrderDetailMapper;
import com.zzb.shop.domain.OrderDetail;
import com.zzb.shop.service.OrderDetailService;

@Service
public class OrderDetailServiceImpl implements OrderDetailService{

	@Autowired
	private OrderDetailMapper orderDetailMapper;

	@Override
	public int deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return orderDetailMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(OrderDetail record) {
		// TODO Auto-generated method stub
		return orderDetailMapper.insert(record);
	}

	@Override
	public int insertSelective(OrderDetail record) {
		// TODO Auto-generated method stub
		return orderDetailMapper.insertSelective(record);
	}

	@Override
	public OrderDetail selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return orderDetailMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(OrderDetail record) {
		// TODO Auto-generated method stub
		return orderDetailMapper.updateByPrimaryKeySelective(record);
	}


}
