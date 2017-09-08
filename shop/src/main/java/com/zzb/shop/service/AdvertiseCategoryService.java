package com.zzb.shop.service;

import com.zzb.shop.domain.AdvertiseCategory;

public interface AdvertiseCategoryService {
	int deleteByPrimaryKey(Long id);

    int insert(AdvertiseCategory record);

    int insertSelective(AdvertiseCategory record);

    AdvertiseCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AdvertiseCategory record);

    int updateByPrimaryKey(AdvertiseCategory record);
}
