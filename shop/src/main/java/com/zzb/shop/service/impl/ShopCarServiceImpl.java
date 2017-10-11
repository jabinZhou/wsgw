package com.zzb.shop.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zzb.shop.dao.GoodDetailMapper;
import com.zzb.shop.dao.ShopCarMapper;
import com.zzb.shop.domain.GoodDetail;
import com.zzb.shop.domain.Page;
import com.zzb.shop.domain.ShopCar;
import com.zzb.shop.service.ShopCarService;
import com.zzb.shop.util.PageData;

@Service
@Transactional(readOnly = true)
public class ShopCarServiceImpl implements ShopCarService{

	@Autowired
	private ShopCarMapper shopCarMapper;
	@Autowired
	private GoodDetailMapper goodDetailMapper;

	@Override
	@Transactional(readOnly = false)
	public int deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return shopCarMapper.deleteByPrimaryKey(id);
	}

	@Override
	@Transactional(readOnly = false)
	public int insert(ShopCar record) {
		// TODO Auto-generated method stub
		return shopCarMapper.insert(record);
	}

	@Override
	@Transactional(readOnly = false)
	public int insertSelective(ShopCar record) {
		// TODO Auto-generated method stub
		return shopCarMapper.insertSelective(record);
	}

	@Override
	public ShopCar selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return shopCarMapper.selectByPrimaryKey(id);
	}

	@Override
	@Transactional(readOnly = false)
	public int updateByPrimaryKeySelective(ShopCar record) {
		// TODO Auto-generated method stub
		return shopCarMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	@Transactional(readOnly = false)
	public int updateByPrimaryKey(ShopCar record) {
		// TODO Auto-generated method stub
		return shopCarMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<PageData> list(Page page) {
		// TODO Auto-generated method stub
		return shopCarMapper.list(page);
	}

	@Override
	public int listCount(Page page) {
		// TODO Auto-generated method stub
		return shopCarMapper.listCount(page);
	}

	@Override
	@Transactional(readOnly = false)
	public int addShopCar(ShopCar record) {
		//获取商品详情是否参与活动
		//参与活动 总额为活动价*数量 否则 上货价*数量
		GoodDetail detail= goodDetailMapper.selectByPrimaryKey(record.getGoodDetailId());
		BigDecimal totalPrice=new BigDecimal(0);
		if(detail.getGoodActivityId()!=null){
			totalPrice=detail.getGoodActivity().getActivityPrice().multiply(new BigDecimal(record.getGoodNum()));
			record.setTotalPrice(totalPrice);
		}else{
			totalPrice=detail.getGoodMarketPrice().multiply(new BigDecimal(record.getGoodNum()));
			record.setTotalPrice(totalPrice);
		}
		return insert(record);
	}
}
