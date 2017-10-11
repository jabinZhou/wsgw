package com.zzb.shop.service;

import java.util.List;

import com.zzb.shop.domain.Page;
import com.zzb.shop.domain.ShopCar;
import com.zzb.shop.util.PageData;

public interface ShopCarService {
	 int deleteByPrimaryKey(Long id);

	    int insert(ShopCar record);

	    int insertSelective(ShopCar record);

	    ShopCar selectByPrimaryKey(Long id);

	    int updateByPrimaryKeySelective(ShopCar record);

	    int updateByPrimaryKey(ShopCar record);
	    
	    List<PageData> list(Page page);
	    
	    int listCount(Page page);
	    
	    int addShopCar(ShopCar record);
}
