package com.zzb.shop.service;

import java.util.List;

import com.zzb.shop.domain.Page;
import com.zzb.shop.domain.SysUser;
import com.zzb.shop.util.PageData;

public interface SysUserService {

	int deleteByPrimaryKey(Long id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
    
    SysUser selectUser(SysUser record);
    
    List<PageData> listUsers(Page page);
    
    int listUsersCount();
}
