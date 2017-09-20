package com.zzb.shop.service;

import java.util.List;

import com.zzb.shop.domain.GoodActivity;
import com.zzb.shop.domain.Page;
import com.zzb.shop.util.PageData;

public interface GoodActivityService {
	int deleteByPrimaryKey(Long id);

    int insert(GoodActivity record);

    int insertSelective(GoodActivity record);

    GoodActivity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GoodActivity record);

    int updateByPrimaryKey(GoodActivity record);
    
List<PageData> list(Page page);
    
    int listCount(Page page);
}
