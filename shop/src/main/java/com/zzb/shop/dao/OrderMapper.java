package com.zzb.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zzb.shop.domain.Order;
import com.zzb.shop.domain.Page;
import com.zzb.shop.util.PageData;

public interface OrderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
    
List<PageData> list(@Param("page")Page page);
    
    int listCount(@Param("page")Page page);
}