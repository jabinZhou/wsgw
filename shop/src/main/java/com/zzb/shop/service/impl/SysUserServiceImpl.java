package com.zzb.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzb.shop.dao.SysUserMapper;
import com.zzb.shop.domain.Page;
import com.zzb.shop.domain.SysUser;
import com.zzb.shop.service.SysUserService;
import com.zzb.shop.util.PageData;

@Service
public class SysUserServiceImpl implements SysUserService {

	@Autowired
	private SysUserMapper sysUserMapper;

	@Override
	public int deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return sysUserMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(SysUser record) {
		// TODO Auto-generated method stub
		return sysUserMapper.insert(record);
	}

	@Override
	public int insertSelective(SysUser record) {
		// TODO Auto-generated method stub
		return sysUserMapper.insertSelective(record);
	}

	@Override
	public SysUser selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return sysUserMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(SysUser record) {
		// TODO Auto-generated method stub
		return sysUserMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(SysUser record) {
		// TODO Auto-generated method stub
		return sysUserMapper.updateByPrimaryKey(record);
	}

	@Override
	public SysUser selectUser(SysUser record) {
		// TODO Auto-generated method stub
		return sysUserMapper.selectUser(record);
	}

	@Override
	public List<PageData> listUsers(Page page) {
		// TODO Auto-generated method stub
		return sysUserMapper.listUsers(page);
	}

	@Override
	public int listUsersCount(Page page) {
		// TODO Auto-generated method stub
		return sysUserMapper.listUsersCount(page);
	}
	
	

}
