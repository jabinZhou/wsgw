package com.zzb.shop.service;

import com.zzb.shop.domain.GoodCategory;

public interface GoodCategoryService {
	 int deleteByPrimaryKey(Long id);

	    int insert(GoodCategory record);

	    int insertSelective(GoodCategory record);

	    GoodCategory selectByPrimaryKey(Long id);

	    int updateByPrimaryKeySelective(GoodCategory record);

	    int updateByPrimaryKey(GoodCategory record);
}
