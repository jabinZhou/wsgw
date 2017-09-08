package com.zzb.shop.service;

import com.zzb.shop.domain.GoodDetail;

public interface GoodDetailService {
	 int deleteByPrimaryKey(Long id);

	    int insert(GoodDetail record);

	    int insertSelective(GoodDetail record);

	    GoodDetail selectByPrimaryKey(Long id);

	    int updateByPrimaryKeySelective(GoodDetail record);

	    int updateByPrimaryKey(GoodDetail record);
}
