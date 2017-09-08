package com.zzb.shop.dao;

import com.zzb.shop.domain.GoodDetail;

public interface GoodDetailMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GoodDetail record);

    int insertSelective(GoodDetail record);

    GoodDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GoodDetail record);

    int updateByPrimaryKey(GoodDetail record);
}