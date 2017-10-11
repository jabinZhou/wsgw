package com.zzb.shop.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zzb.shop.dao.OrderDetailMapper;
import com.zzb.shop.dao.OrderMapper;
import com.zzb.shop.domain.Order;
import com.zzb.shop.domain.Page;
import com.zzb.shop.domain.ShopCar;
import com.zzb.shop.service.OrderService;
import com.zzb.shop.util.PageData;
import com.zzb.shop.util.SnUtils;

@Service
@Transactional(readOnly = true)
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderMapper orderMapper;
	
	@Autowired
	private OrderDetailMapper orderDetailMapper;

	@Override
	@Transactional(readOnly = false)
	public int deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return orderMapper.deleteByPrimaryKey(id);
	}

	@Override
	@Transactional(readOnly = false)
	public int insert(Order record) {
		// TODO Auto-generated method stub
		return orderMapper.insert(record);
	}

	@Override
	@Transactional(readOnly = false)
	public int insertSelective(Order record) {
		// TODO Auto-generated method stub
		return orderMapper.insertSelective(record);
	}

	@Override
	public Order selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return orderMapper.selectByPrimaryKey(id);
	}

	@Override
	@Transactional(readOnly = false)
	public int updateByPrimaryKeySelective(Order record) {
		// TODO Auto-generated method stub
		return orderMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	@Transactional(readOnly = false)
	public int updateByPrimaryKey(Order record) {
		// TODO Auto-generated method stub
		return orderMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<PageData> list(Page page) {
		// TODO Auto-generated method stub
		return orderMapper.list(page);
	}

	@Override
	public int listCount(Page page) {
		// TODO Auto-generated method stub
		return orderMapper.listCount(page);
	}

	@Override
	@Transactional(readOnly = false)
	public int addOrder(Order record) {
		List<ShopCar>list=record.getList();
		int len=list.size();
		BigDecimal totalPrice=new BigDecimal(0);//订单总价格
		for(int i=0;i<len;i++){
			ShopCar shopCar=list.get(i);
			totalPrice=totalPrice.add(shopCar.getTotalPrice());
		}
		Date date=new Date();
		record.setTotalPrice(totalPrice);
		record.setTruePrice(totalPrice);
		record.setOrderNo(SnUtils.getSn(SnUtils.ORDER_TYPE));
		record.setOrderStatus(Order.WAIT_PAY_STATUS);
		record.setCreateDate(date);
		record.setUpdateDate(date);
		record.setDelFlag("0");
		int ret=orderMapper.insert(record);
		if(ret>0){
			orderMapper.batchInsert(record);//批量插入订单详情
		}
		return ret;
	}
}
