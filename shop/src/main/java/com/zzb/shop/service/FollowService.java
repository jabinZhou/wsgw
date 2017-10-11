package com.zzb.shop.service;

import java.util.List;

import com.zzb.shop.domain.Follow;
import com.zzb.shop.domain.Page;
import com.zzb.shop.util.PageData;

public interface FollowService {
	int insert(Follow record);

    int insertSelective(Follow record);
    
    int delete(Follow record);
    
    List<PageData> list(Page page);
    
    int listCount(Page page);
    
    int follow(Follow record,Integer isFollow);
}
