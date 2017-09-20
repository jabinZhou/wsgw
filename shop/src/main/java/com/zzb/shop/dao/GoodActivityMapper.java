package com.zzb.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zzb.shop.domain.GoodActivity;
import com.zzb.shop.domain.Page;
import com.zzb.shop.util.PageData;

public interface GoodActivityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GoodActivity record);

    int insertSelective(GoodActivity record);

    GoodActivity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GoodActivity record);

    int updateByPrimaryKey(GoodActivity record);
    
List<PageData> list(@Param("page")Page page);
    
    int listCount(@Param("page")Page page);
}