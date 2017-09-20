package com.zzb.shop.service;

import java.util.List;

import com.zzb.shop.domain.Good;
import com.zzb.shop.domain.Page;
import com.zzb.shop.util.PageData;

public interface GoodService {
	int deleteByPrimaryKey(Long id);

    int insert(Good record);

    int insertSelective(Good record);

    Good selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Good record);

    int updateByPrimaryKey(Good record);
    
List<PageData> list(Page page);
    
    int listCount(Page page);
}
