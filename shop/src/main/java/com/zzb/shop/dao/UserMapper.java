package com.zzb.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zzb.shop.domain.Page;
import com.zzb.shop.domain.User;
import com.zzb.shop.util.PageData;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    List<PageData> listUsers(@Param("page")Page page);
    
    int listUsersCount();
}