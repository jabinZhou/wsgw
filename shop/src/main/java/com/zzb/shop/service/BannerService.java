package com.zzb.shop.service;

import java.util.List;

import com.zzb.shop.domain.Banner;
import com.zzb.shop.domain.Page;
import com.zzb.shop.util.PageData;

public interface BannerService {
	 int deleteByPrimaryKey(Long id);

	    int insert(Banner record);

	    int insertSelective(Banner record);

	    Banner selectByPrimaryKey(Long id);

	    int updateByPrimaryKeySelective(Banner record);

	    int updateByPrimaryKey(Banner record);
	    
	    List<PageData> list(Page page);
	    
	    int listCount(Page page);
}
