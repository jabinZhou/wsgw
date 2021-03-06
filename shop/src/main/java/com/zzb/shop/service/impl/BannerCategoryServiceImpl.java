package com.zzb.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zzb.shop.dao.BannerCategoryMapper;
import com.zzb.shop.domain.AdvertiseCategory;
import com.zzb.shop.domain.BannerCategory;
import com.zzb.shop.domain.Page;
import com.zzb.shop.service.BannerCategoryService;
import com.zzb.shop.util.PageData;
import com.zzb.shop.util.StringUtil;

@Service
@Transactional(readOnly = true)
public class BannerCategoryServiceImpl implements BannerCategoryService{

	@Autowired
	private BannerCategoryMapper bannerCategoryMapper;

	@Override
	@Transactional(readOnly = false)
	public int deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return bannerCategoryMapper.deleteByPrimaryKey(id);
	}

	@Override
	@Transactional(readOnly = false)
	public int insert(BannerCategory record) {
		
		boolean noPid=false;//是否有父分类
		if(StringUtil.isNullOrEmpty(record.getParentId())||0==record.getParentId()){
			record.setParentId(0L);//设置分类为一级分类
			noPid=true;
		}
		int flag=bannerCategoryMapper.insert(record);
		if(flag>0){
			/*
			 * 无父分类 设置当前分类的父分类为0 当前分类的父分类字符串数组为0和本分类的主键ID
			 * 有父分类 获取父分类的父分类字符串数组 设置当前分类的父分类字符串数组为父分类字符串数组和本分类的主键ID
			 * 更新当前分类
			 */
			if(noPid){
				record.setParentIds(record.getParentId()+","+record.getId());
				updateByPrimaryKeySelective(record);
			}else{
				BannerCategory pAC=selectByPrimaryKey(record.getParentId());
				record.setParentIds(pAC.getParentIds()+","+record.getId());
				updateByPrimaryKeySelective(record);
			}
		}
		return flag;
	}

	@Override
	public int insertSelective(BannerCategory record) {
		// TODO Auto-generated method stub
		return bannerCategoryMapper.insertSelective(record);
	}

	@Override
	public BannerCategory selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return bannerCategoryMapper.selectByPrimaryKey(id);
	}

	@Override
	@Transactional(readOnly = false)
	public int updateByPrimaryKeySelective(BannerCategory record) {
		boolean noPid = false;
		if (StringUtil.isNullOrEmpty(record.getParentId()) || 0 == record.getParentId()) {
			record.setParentId(0L);
			noPid = true;
		}
		if (noPid) {
			record.setParentIds(record.getParentId() + "," + record.getId());
		} else {
			BannerCategory pAC = selectByPrimaryKey(record.getParentId());
			record.setParentIds(pAC.getParentIds() + "," + record.getId());
		}
		return bannerCategoryMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(BannerCategory record) {
		// TODO Auto-generated method stub
		return bannerCategoryMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<PageData> list(Page page) {
		// TODO Auto-generated method stub
		return bannerCategoryMapper.list(page);
	}

	@Override
	public int listCount(Page page) {
		// TODO Auto-generated method stub
		return bannerCategoryMapper.listCount(page);
	}
}
