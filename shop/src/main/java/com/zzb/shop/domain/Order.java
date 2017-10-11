package com.zzb.shop.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Order implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -6937379766825701591L;

	private Long id;

    private Long userId;

    private String orderNo;

    private BigDecimal totalPrice;

    private BigDecimal truePrice;

    private String expressCode;

    private String orderStatus;

    private String remarks;

    private Date createDate;

    private Date updateDate;

    private String delFlag;

    private List<ShopCar> list;
    
    public static final  String WAIT_PAY_STATUS="0";//状态 0待付款1已付款2待发货3 已发货 4 已收货
    public static final  String PAY_STATUS="1";
    public static final  String WAIT_SHIPPING_STATUS="2";
    public static final  String SHIPPING_STATUS="3";
    public static final  String FINISH_STATUS="4";
    
    public List<ShopCar> getList() {
		return list;
	}

	public void setList(List<ShopCar> list) {
		this.list = list;
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

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getTruePrice() {
        return truePrice;
    }

    public void setTruePrice(BigDecimal truePrice) {
        this.truePrice = truePrice;
    }


    public String getExpressCode() {
        return expressCode;
    }

    public void setExpressCode(String expressCode) {
        this.expressCode = expressCode == null ? null : expressCode.trim();
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus == null ? null : orderStatus.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }
}