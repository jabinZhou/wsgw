package com.zzb.shop.service;

import com.zzb.shop.domain.GoodActivityCategory;

public interface GoodActivityCategoryService {
	 int deleteByPrimaryKey(Long id);

	    int insert(GoodActivityCategory record);

	    int insertSelective(GoodActivityCategory record);

	    GoodActivityCategory selectByPrimaryKey(Long id);

	    int updateByPrimaryKeySelective(GoodActivityCategory record);

	    int updateByPrimaryKey(GoodActivityCategory record);
}
