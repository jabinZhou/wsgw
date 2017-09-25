package com.zzb.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zzb.shop.domain.Banner;
import com.zzb.shop.domain.Page;
import com.zzb.shop.util.PageData;

public interface BannerMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Banner record);

    int insertSelective(Banner record);

    Banner selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Banner record);

    int updateByPrimaryKey(Banner record);
    
    List<PageData> list(@Param("page")Page page);
    
    int listCount(@Param("page")Page page);
}