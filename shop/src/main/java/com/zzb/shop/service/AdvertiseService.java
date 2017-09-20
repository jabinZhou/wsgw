package com.zzb.shop.service;

import java.util.List;

import com.zzb.shop.domain.Advertise;
import com.zzb.shop.domain.Page;
import com.zzb.shop.util.PageData;

public interface AdvertiseService {
	int deleteByPrimaryKey(Long id);

    int insert(Advertise record);

    int insertSelective(Advertise record);

    Advertise selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Advertise record);

    int updateByPrimaryKey(Advertise record);
    
    List<PageData> list(Page page);
    
    int listCount(Page page);
}
