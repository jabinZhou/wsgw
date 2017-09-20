package com.zzb.shop.service;

import java.util.List;

import com.zzb.shop.domain.BannerCategory;
import com.zzb.shop.domain.Page;
import com.zzb.shop.util.PageData;

public interface BannerCategoryService {
	 int deleteByPrimaryKey(Long id);

	    int insert(BannerCategory record);

	    int insertSelective(BannerCategory record);

	    BannerCategory selectByPrimaryKey(Long id);

	    int updateByPrimaryKeySelective(BannerCategory record);

	    int updateByPrimaryKey(BannerCategory record);
	    List<PageData> list(Page page);
	    
	    int listCount(Page page);
}
