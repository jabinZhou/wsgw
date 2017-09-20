package com.zzb.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zzb.shop.domain.GoodActivityCategory;
import com.zzb.shop.domain.Page;
import com.zzb.shop.util.PageData;

public interface GoodActivityCategoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GoodActivityCategory record);

    int insertSelective(GoodActivityCategory record);

    GoodActivityCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GoodActivityCategory record);

    int updateByPrimaryKey(GoodActivityCategory record);
    
List<PageData> list(@Param("page")Page page);
    
    int listCount(@Param("page")Page page);
}