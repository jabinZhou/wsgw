package com.zzb.shop.dao;

import com.zzb.shop.domain.Advertise;

public interface AdvertiseMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Advertise record);

    int insertSelective(Advertise record);

    Advertise selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Advertise record);

    int updateByPrimaryKey(Advertise record);
}