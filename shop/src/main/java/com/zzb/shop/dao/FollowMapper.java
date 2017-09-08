package com.zzb.shop.dao;

import com.zzb.shop.domain.Follow;

public interface FollowMapper {
    int insert(Follow record);

    int insertSelective(Follow record);
}