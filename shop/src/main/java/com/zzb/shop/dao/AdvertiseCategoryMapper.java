package com.zzb.shop.dao;

import com.zzb.shop.domain.AdvertiseCategory;

public interface AdvertiseCategoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AdvertiseCategory record);

    int insertSelective(AdvertiseCategory record);

    AdvertiseCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AdvertiseCategory record);

    int updateByPrimaryKey(AdvertiseCategory record);
}