package com.zzb.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zzb.shop.domain.Follow;
import com.zzb.shop.domain.Page;
import com.zzb.shop.domain.User;
import com.zzb.shop.util.PageData;

public interface FollowMapper {
    int insert(Follow record);

    int insertSelective(Follow record);
    
    int deleteByPrimaryKey(Follow record);
    
    List<PageData> list(@Param("page")Page page);
    
    int listCount(@Param("page")Page page);
    
    Follow selectFollow(Follow record);
}