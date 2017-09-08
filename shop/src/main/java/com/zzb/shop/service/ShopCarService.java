package com.zzb.shop.service;

import com.zzb.shop.domain.ShopCar;

public interface ShopCarService {
	 int deleteByPrimaryKey(Long id);

	    int insert(ShopCar record);

	    int insertSelective(ShopCar record);

	    ShopCar selectByPrimaryKey(Long id);

	    int updateByPrimaryKeySelective(ShopCar record);

	    int updateByPrimaryKey(ShopCar record);
}
