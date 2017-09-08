package com.zzb.shop.dao;

import com.zzb.shop.domain.BannerCategory;

public interface BannerCategoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BannerCategory record);

    int insertSelective(BannerCategory record);

    BannerCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BannerCategory record);

    int updateByPrimaryKey(BannerCategory record);
}