package com.zzb.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zzb.shop.domain.Page;
import com.zzb.shop.domain.ShopCar;
import com.zzb.shop.util.PageData;

public interface ShopCarMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ShopCar record);

    int insertSelective(ShopCar record);

    ShopCar selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ShopCar record);

    int updateByPrimaryKey(ShopCar record);
    
List<PageData> list(@Param("page")Page page);
    
    int listCount(@Param("page")Page page);
}