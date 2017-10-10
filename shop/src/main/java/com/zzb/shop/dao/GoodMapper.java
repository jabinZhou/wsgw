package com.zzb.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zzb.shop.domain.Good;
import com.zzb.shop.domain.Page;
import com.zzb.shop.util.PageData;

public interface GoodMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Good record);

    int insertSelective(Good record);

    Good selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Good record);

    int updateByPrimaryKey(Good record);
    
    List<PageData> list(@Param("page")Page page);
    
    List<PageData> goodIndexList(@Param("page")Page page);
    
    int listCount(@Param("page")Page page);
}