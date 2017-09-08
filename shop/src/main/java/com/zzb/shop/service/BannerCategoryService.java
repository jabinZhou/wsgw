package com.zzb.shop.service;

import com.zzb.shop.domain.BannerCategory;

public interface BannerCategoryService {
	 int deleteByPrimaryKey(Long id);

	    int insert(BannerCategory record);

	    int insertSelective(BannerCategory record);

	    BannerCategory selectByPrimaryKey(Long id);

	    int updateByPrimaryKeySelective(BannerCategory record);

	    int updateByPrimaryKey(BannerCategory record);
}
