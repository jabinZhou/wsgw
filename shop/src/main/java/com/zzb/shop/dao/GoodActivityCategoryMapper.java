package com.zzb.shop.dao;

import com.zzb.shop.domain.GoodActivityCategory;

public interface GoodActivityCategoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GoodActivityCategory record);

    int insertSelective(GoodActivityCategory record);

    GoodActivityCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GoodActivityCategory record);

    int updateByPrimaryKey(GoodActivityCategory record);
}