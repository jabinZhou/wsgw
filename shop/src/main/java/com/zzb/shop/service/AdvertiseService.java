package com.zzb.shop.service;

import com.zzb.shop.domain.Advertise;

public interface AdvertiseService {
	int deleteByPrimaryKey(Long id);

    int insert(Advertise record);

    int insertSelective(Advertise record);

    Advertise selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Advertise record);

    int updateByPrimaryKey(Advertise record);
}
