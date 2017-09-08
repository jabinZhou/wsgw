package com.zzb.shop.service;

import com.zzb.shop.domain.Follow;

public interface FollowService {
	int insert(Follow record);

    int insertSelective(Follow record);
}
