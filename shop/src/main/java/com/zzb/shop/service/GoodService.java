package com.zzb.shop.service;

import com.zzb.shop.domain.Good;

public interface GoodService {
	int deleteByPrimaryKey(Long id);

    int insert(Good record);

    int insertSelective(Good record);

    Good selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Good record);

    int updateByPrimaryKey(Good record);
}
