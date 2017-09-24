package com.zzb.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zzb.shop.dao.AdvertiseCategoryMapper;
import com.zzb.shop.domain.AdvertiseCategory;
import com.zzb.shop.domain.Page;
import com.zzb.shop.service.AdvertiseCategoryService;
import com.zzb.shop.util.PageData;
import com.zzb.shop.util.StringUtil;

@Service
@Transactional(readOnly = true)
public class AdvertiseCategoryServiceImpl implements AdvertiseCategoryService{

	@Autowired
	private AdvertiseCategoryMapper advertiseCategory;

	@Override
	public int deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return advertiseCategory.deleteByPrimaryKey(id);
	}

	@Override
	@Transactional(readOnly = false)
	public int insert(AdvertiseCategory record) {
	    boolean noPid=false;
		if(StringUtil.isNullOrEmpty(record.getParentId())||0==record.getParentId()){
			record.setParentId(0L);
			noPid=true;
		}
		int flag=advertiseCategory.insert(record);
		if(flag>0){
			if(noPid){
				record.setParentIds(record.getParentId()+","+record.getId());
				updateByPrimaryKeySelective(record);
			}else{
				AdvertiseCategory pAC=selectByPrimaryKey(record.getParentId());
				record.setParentIds(pAC.getParentIds()+","+record.getId());
				updateByPrimaryKeySelective(record);
			}
		}
		return flag;
	}

	@Override
	public int insertSelective(AdvertiseCategory record) {
		// TODO Auto-generated method stub
		return advertiseCategory.insertSelective(record);
	}

	@Override
	public AdvertiseCategory selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return advertiseCategory.selectByPrimaryKey(id);
	}

	@Override
	@Transactional(readOnly = false)
	public int updateByPrimaryKeySelective(AdvertiseCategory record) {
		boolean noPid=false;
		if(StringUtil.isNullOrEmpty(record.getParentId())||0==record.getParentId()){
			record.setParentId(0L);
			noPid=true;
		}
		if (noPid) {
			record.setParentIds(record.getParentId() + "," + record.getId());
		} else {
			AdvertiseCategory pAC = selectByPrimaryKey(record.getParentId());
			record.setParentIds(pAC.getParentIds() + "," + record.getId());
		}
		return advertiseCategory.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(AdvertiseCategory record) {
		// TODO Auto-generated method stub
		return advertiseCategory.updateByPrimaryKey(record);
	}

	@Override
	public List<PageData> list(Page page) {
		// TODO Auto-generated method stub
		return advertiseCategory.list(page);
	}

	@Override
	public int listCount(Page page) {
		// TODO Auto-generated method stub
		return advertiseCategory.listCount(page);
	}
}
