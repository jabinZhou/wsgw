package com.zzb.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zzb.shop.domain.AdvertiseCategory;
import com.zzb.shop.domain.Page;
import com.zzb.shop.util.PageData;

public interface AdvertiseCategoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AdvertiseCategory record);

    int insertSelective(AdvertiseCategory record);

    AdvertiseCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AdvertiseCategory record);

    int updateByPrimaryKey(AdvertiseCategory record);
    
    List<PageData> list(@Param("page")Page page);
    
    int listCount(@Param("page")Page page);
}