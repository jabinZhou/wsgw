package com.zzb.shop.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Good {
    private Long id;
    
    private Long userId;

    private String title;

    private String name;

    private Long goodCategoryType;

    private String goodImage;

    private String status; //商品状态 0待审核 1 审核通过 2审核不通过

    private Date createDate;

    private Date updateDate;

    private String delFlag;
    
    private String categoryName;
    
    private String activityName;
    
    private Long detailId;
    
    private Long goodActivityId;
    
    private String goodImages;
    
	private String goodDetail;

    private BigDecimal goodTagPrice;

    private BigDecimal goodMarketPrice;

    public static final String WAIT_STATUS="0";
    public static final String PASS_STATUS="1";
    public static final String REFUSE_STATUS="2";
    
    
    public String getGoodImages() {
		return goodImages;
	}

	public void setGoodImages(String goodImages) {
		this.goodImages = goodImages;
	}

	public String getGoodDetail() {
		return goodDetail;
	}

	public void setGoodDetail(String goodDetail) {
		this.goodDetail = goodDetail;
	}

	public BigDecimal getGoodTagPrice() {
		return goodTagPrice;
	}

	public void setGoodTagPrice(BigDecimal goodTagPrice) {
		this.goodTagPrice = goodTagPrice;
	}

	public BigDecimal getGoodMarketPrice() {
		return goodMarketPrice;
	}

	public void setGoodMarketPrice(BigDecimal goodMarketPrice) {
		this.goodMarketPrice = goodMarketPrice;
	}
   
    public Long getDetailId() {
		return detailId;
	}

	public void setDetailId(Long detailId) {
		this.detailId = detailId;
	}

	public Long getGoodActivityId() {
		return goodActivityId;
	}

	public void setGoodActivityId(Long goodActivityId) {
		this.goodActivityId = goodActivityId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
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

	public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getGoodCategoryType() {
        return goodCategoryType;
    }

    public void setGoodCategoryType(Long goodCategoryType) {
        this.goodCategoryType = goodCategoryType;
    }

    public String getGoodImage() {
        return goodImage;
    }

    public void setGoodImage(String goodImage) {
        this.goodImage = goodImage == null ? null : goodImage.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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