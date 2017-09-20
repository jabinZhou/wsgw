package com.zzb.shop.service;

import java.util.List;

import com.zzb.shop.domain.AdvertiseCategory;
import com.zzb.shop.domain.Page;
import com.zzb.shop.util.PageData;

public interface AdvertiseCategoryService {
	int deleteByPrimaryKey(Long id);

    int insert(AdvertiseCategory record);

    int insertSelective(AdvertiseCategory record);

    AdvertiseCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AdvertiseCategory record);

    int updateByPrimaryKey(AdvertiseCategory record);
    
List<PageData> list(Page page);
    
    int listCount(Page page);
}
