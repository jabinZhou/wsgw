package com.zzb.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zzb.shop.domain.Dict;
import com.zzb.shop.domain.Page;
import com.zzb.shop.util.PageData;

public interface DictMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Dict record);

    int insertSelective(Dict record);

    Dict selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Dict record);

    int updateByPrimaryKey(Dict record);
    
List<PageData> list(@Param("page")Page page);
    
    int listCount(@Param("page")Page page);
}