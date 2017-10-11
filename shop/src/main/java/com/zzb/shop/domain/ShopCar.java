package com.zzb.shop.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class ShopCar implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -5909754175853621064L;

	private Long id;

    private Long userId;

    private Long goodId;

    private Long goodDetailId;

    private Integer goodNum;

    private BigDecimal totalPrice;

    private User buyUser;
    private User sellUser;
    private Good good;
    private GoodDetail goodDetail;
    public User getBuyUser() {
		return buyUser;
	}

	public void setBuyUser(User buyUser) {
		this.buyUser = buyUser;
	}

	public User getSellUser() {
		return sellUser;
	}

	public void setSellUser(User sellUser) {
		this.sellUser = sellUser;
	}

	public Good getGood() {
		return good;
	}

	public void setGood(Good good) {
		this.good = good;
	}

	public GoodDetail getGoodDetail() {
		return goodDetail;
	}

	public void setGoodDetail(GoodDetail goodDetail) {
		this.goodDetail = goodDetail;
	}

	
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getGoodId() {
        return goodId;
    }

    public void setGoodId(Long goodId) {
        this.goodId = goodId;
    }

    public Long getGoodDetailId() {
        return goodDetailId;
    }

    public void setGoodDetailId(Long goodDetailId) {
        this.goodDetailId = goodDetailId;
    }

    public Integer getGoodNum() {
        return goodNum;
    }

    public void setGoodNum(Integer goodNum) {
        this.goodNum = goodNum;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}