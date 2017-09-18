package com.zzb.shop.service;

import java.util.List;

import com.zzb.shop.domain.Page;
import com.zzb.shop.domain.SysUser;
import com.zzb.shop.domain.User;
import com.zzb.shop.util.PageData;

public interface UserService {

	int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    User selectUser(User record);
    
    List<PageData> listUsers(Page page);
    
    int listUsersCount(Page page);
}
