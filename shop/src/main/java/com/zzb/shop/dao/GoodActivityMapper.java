package com.zzb.shop.dao;

import com.zzb.shop.domain.GoodActivity;

public interface GoodActivityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GoodActivity record);

    int insertSelective(GoodActivity record);

    GoodActivity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GoodActivity record);

    int updateByPrimaryKey(GoodActivity record);
}