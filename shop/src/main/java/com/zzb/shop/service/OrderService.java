package com.zzb.shop.service;

import java.util.List;

import com.zzb.shop.domain.Order;
import com.zzb.shop.domain.Page;
import com.zzb.shop.util.PageData;

public interface OrderService {
	 int deleteByPrimaryKey(Long id);

	    int insert(Order record);

	    int insertSelective(Order record);

	    Order selectByPrimaryKey(Long id);

	    int updateByPrimaryKeySelective(Order record);

	    int updateByPrimaryKey(Order record);
	    
	    List<PageData> list(Page page);
	    
	    int listCount(Page page);
	    
	    int addOrder(Order record);
}
