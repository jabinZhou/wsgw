package com.zzb.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zzb.shop.domain.GoodDetail;
import com.zzb.shop.domain.Page;
import com.zzb.shop.util.PageData;

public interface GoodDetailMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GoodDetail record);

    int insertSelective(GoodDetail record);

    GoodDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GoodDetail record);

    int updateByPrimaryKey(GoodDetail record);
    
List<PageData> list(@Param("page")Page page);
    
    int listCount(@Param("page")Page page);
}