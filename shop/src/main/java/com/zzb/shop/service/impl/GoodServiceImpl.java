package com.zzb.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zzb.shop.dao.GoodDetailMapper;
import com.zzb.shop.dao.GoodMapper;
import com.zzb.shop.domain.Good;
import com.zzb.shop.domain.GoodDetail;
import com.zzb.shop.domain.Page;
import com.zzb.shop.service.GoodService;
import com.zzb.shop.util.PageData;

@Service
@Transactional(readOnly = true)
public class GoodServiceImpl implements GoodService{

	@Autowired
	private GoodMapper goodMapper;
	
	@Autowired
	private GoodDetailMapper goodDetailMapper;

	@Override
	@Transactional(readOnly = false)
	public int deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return goodMapper.deleteByPrimaryKey(id);
	}

	@Override
	@Transactional(readOnly = false)
	public int insert(Good record) {
		// TODO Auto-generated method stub
		int flag=goodMapper.insert(record);
		if(flag>0){
			
		}
		return flag;
	}

	@Override
	@Transactional(readOnly = false)
	public int insertSelective(Good record) {
		// TODO Auto-generated method stub
		return goodMapper.insertSelective(record);
	}

	@Override
	public Good selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return goodMapper.selectByPrimaryKey(id);
	}

	@Override
	@Transactional(readOnly = false)
	public int updateByPrimaryKeySelective(Good record) {
		int flag=goodMapper.updateByPrimaryKeySelective(record);
	    if(flag>0){
	    	GoodDetail detail=new GoodDetail();
	    	detail.setId(record.getDetailId());
	    	detail.setGoodImages(record.getGoodImages());
	    	detail.setGoodActivityId(record.getGoodActivityId());
	    	detail.setGoodDetail(record.getGoodDetail());
	    	detail.setGoodTagPrice(record.getGoodTagPrice());
	    	detail.setGoodMarketPrice(record.getGoodMarketPrice());
			goodDetailMapper.updateByPrimaryKeySelective(detail);
	    }
		return flag;
	}

	@Override
	@Transactional(readOnly = false)
	public int updateByPrimaryKey(Good record) {
		// TODO Auto-generated method stub
		return goodMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<PageData> list(Page page) {
		// TODO Auto-generated method stub
		return goodMapper.list(page);
	}

	@Override
	public int listCount(Page page) {
		// TODO Auto-generated method stub
		return goodMapper.listCount(page);
	}
}
