package com.zzb.shop.service;

import java.util.List;

import com.zzb.shop.domain.GoodDetail;
import com.zzb.shop.domain.Page;
import com.zzb.shop.util.PageData;

public interface GoodDetailService {
	 int deleteByPrimaryKey(Long id);

	    int insert(GoodDetail record);

	    int insertSelective(GoodDetail record);

	    GoodDetail selectByPrimaryKey(Long id);

	    int updateByPrimaryKeySelective(GoodDetail record);

	    int updateByPrimaryKey(GoodDetail record);
	    
	    List<PageData> list(Page page);
	    
	    int listCount(Page page);
}
