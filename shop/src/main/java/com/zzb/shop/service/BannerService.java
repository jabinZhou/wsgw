package com.zzb.shop.service;

import com.zzb.shop.domain.Banner;

public interface BannerService {
	 int deleteByPrimaryKey(Long id);

	    int insert(Banner record);

	    int insertSelective(Banner record);

	    Banner selectByPrimaryKey(Long id);

	    int updateByPrimaryKeySelective(Banner record);

	    int updateByPrimaryKey(Banner record);
}
