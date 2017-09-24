package com.zzb.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zzb.shop.domain.GoodCategory;
import com.zzb.shop.domain.Page;
import com.zzb.shop.util.PageData;

public interface GoodCategoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GoodCategory record);

    int insertSelective(GoodCategory record);

    GoodCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GoodCategory record);

    int updateByPrimaryKey(GoodCategory record);
    
    List<PageData> list(@Param("page")Page page);
    
    int listCount(@Param("page")Page page);
}