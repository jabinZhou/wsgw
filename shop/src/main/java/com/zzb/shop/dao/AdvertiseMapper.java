package com.zzb.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zzb.shop.domain.Advertise;
import com.zzb.shop.domain.Page;
import com.zzb.shop.util.PageData;

public interface AdvertiseMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Advertise record);

    int insertSelective(Advertise record);

    Advertise selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Advertise record);

    int updateByPrimaryKey(Advertise record);
    
    List<PageData> list(@Param("page")Page page);
    
    int listCount(@Param("page")Page page);
}