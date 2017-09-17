package com.zzb.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzb.shop.dao.UserMapper;
import com.zzb.shop.domain.Page;
import com.zzb.shop.domain.User;
import com.zzb.shop.service.UserService;
import com.zzb.shop.util.PageData;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(User record) {
		// TODO Auto-generated method stub
		return userMapper.insert(record);
	}

	@Override
	public int insertSelective(User record) {
		// TODO Auto-generated method stub
		return userMapper.insertSelective(record);
	}

	@Override
	public User selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(User record) {
		// TODO Auto-generated method stub
		return userMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(User record) {
		// TODO Auto-generated method stub
		return userMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<PageData> listUsers(Page page) {
		// TODO Auto-generated method stub
		return userMapper.listUsers(page);
	}

	@Override
	public int listUsersCount() {
		// TODO Auto-generated method stub
		return userMapper.listUsersCount();
	}

	@Override
	public User selectUser(User record) {
		// TODO Auto-generated method stub
		return userMapper.selectUser(record);
	}

}
