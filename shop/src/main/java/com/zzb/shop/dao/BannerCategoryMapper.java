package com.zzb.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zzb.shop.domain.BannerCategory;
import com.zzb.shop.domain.Page;
import com.zzb.shop.util.PageData;

public interface BannerCategoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BannerCategory record);

    int insertSelective(BannerCategory record);

    BannerCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BannerCategory record);

    int updateByPrimaryKey(BannerCategory record);
    
    List<PageData> list(@Param("page")Page page);
    
    int listCount(@Param("page")Page page);
}