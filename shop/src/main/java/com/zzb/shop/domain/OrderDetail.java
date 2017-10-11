package com.zzb.shop.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class OrderDetail implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -1889070825589535611L;

	private Long id;

    private Long orderId;

    private Long goodId;

    private Integer goodNum;

    private BigDecimal totalPrice;

    private Long goodDetailId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getGoodId() {
        return goodId;
    }

    public void setGoodId(Long goodId) {
        this.goodId = goodId;
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

	public Long getGoodDetailId() {
		return goodDetailId;
	}

	public void setGoodDetailId(Long goodDetailId) {
		this.goodDetailId = goodDetailId;
	}

	
}