package com.zzb.shop.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class GoodActivity implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 2139137287564877117L;

	private Long id;

    private Long goodActivityCategoryId;

	private Long goodId;

    private String activityTitle;

    private BigDecimal activityPrice;

    private Date activityBeginDate;

    private Date activityEndDate;

    private String activityStatus;

    private String activityFlag;

    private String categoryIdName;

    public String getCategoryIdName() {
		return categoryIdName;
	}

	public void setCategoryIdName(String categoryIdName) {
		this.categoryIdName = categoryIdName;
	}
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGoodActivityCategoryId() {
		return goodActivityCategoryId;
	}

	public void setGoodActivityCategoryId(Long goodActivityCategoryId) {
		this.goodActivityCategoryId = goodActivityCategoryId;
	}
    
    public Long getGoodId() {
        return goodId;
    }

    public void setGoodId(Long goodId) {
        this.goodId = goodId;
    }

    public String getActivityTitle() {
        return activityTitle;
    }

    public void setActivityTitle(String activityTitle) {
        this.activityTitle = activityTitle == null ? null : activityTitle.trim();
    }

    public BigDecimal getActivityPrice() {
        return activityPrice;
    }

    public void setActivityPrice(BigDecimal activityPrice) {
        this.activityPrice = activityPrice;
    }

    public Date getActivityBeginDate() {
        return activityBeginDate;
    }

    public void setActivityBeginDate(Date activityBeginDate) {
        this.activityBeginDate = activityBeginDate;
    }

    public Date getActivityEndDate() {
        return activityEndDate;
    }

    public void setActivityEndDate(Date activityEndDate) {
        this.activityEndDate = activityEndDate;
    }

    public String getActivityStatus() {
        return activityStatus;
    }

    public void setActivityStatus(String activityStatus) {
        this.activityStatus = activityStatus == null ? null : activityStatus.trim();
    }

    public String getActivityFlag() {
        return activityFlag;
    }

    public void setActivityFlag(String activityFlag) {
        this.activityFlag = activityFlag == null ? null : activityFlag.trim();
    }
}