package com.zzb.shop.service;

import java.util.List;

import com.zzb.shop.domain.GoodCategory;
import com.zzb.shop.domain.Page;
import com.zzb.shop.util.PageData;

public interface GoodCategoryService {
	 int deleteByPrimaryKey(Long id);

	    int insert(GoodCategory record);

	    int insertSelective(GoodCategory record);

	    GoodCategory selectByPrimaryKey(Long id);

	    int updateByPrimaryKeySelective(GoodCategory record);

	    int updateByPrimaryKey(GoodCategory record);
	    
	    List<PageData> listGoodCategorys(Page page);
	    
	    int listGoodCategorysCount();
}
