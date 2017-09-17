package com.zzb.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zzb.shop.domain.Page;
import com.zzb.shop.domain.SysUser;
import com.zzb.shop.util.PageData;

public interface SysUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
    
    SysUser selectUser(SysUser record);
    
    List<PageData> listUsers(@Param("page")Page page);
    
    int listUsersCount();
}