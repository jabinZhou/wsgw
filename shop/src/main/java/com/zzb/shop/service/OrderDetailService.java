package com.zzb.shop.service;

import com.zzb.shop.domain.OrderDetail;

public interface OrderDetailService {
	int deleteByPrimaryKey(Long id);

    int insert(OrderDetail record);

    int insertSelective(OrderDetail record);

    OrderDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrderDetail record);
}
