package com.zzb.shop.service;

import java.util.List;

import com.zzb.shop.domain.GoodActivityCategory;
import com.zzb.shop.domain.Page;
import com.zzb.shop.util.PageData;

public interface GoodActivityCategoryService {
	 int deleteByPrimaryKey(Long id);

	    int insert(GoodActivityCategory record);

	    int insertSelective(GoodActivityCategory record);

	    GoodActivityCategory selectByPrimaryKey(Long id);

	    int updateByPrimaryKeySelective(GoodActivityCategory record);

	    int updateByPrimaryKey(GoodActivityCategory record);
	    
	    List<PageData> list(Page page);
	    
	    int listCount(Page page);
}
