package com.zzb.shop.domain;

import java.math.BigDecimal;

public class GoodDetail {
    private Long id;

    private Long goodId;

    private Long userId;

    private String goodImages;

    private Long goodActivityId;

    private String goodDetail;

    private BigDecimal goodTagPrice;

    private BigDecimal goodMarketPrice;

    private String marketStatus;

    private String marketFlag;
    
    private GoodActivity goodActivity;

    
	public GoodActivity getGoodActivity() {
		return goodActivity;
	}

	public void setGoodActivity(GoodActivity goodActivity) {
		this.goodActivity = goodActivity;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGoodId() {
        return goodId;
    }

    public void setGoodId(Long goodId) {
        this.goodId = goodId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getGoodImages() {
        return goodImages;
    }

    public void setGoodImages(String goodImages) {
        this.goodImages = goodImages == null ? null : goodImages.trim();
    }

    public Long getGoodActivityId() {
        return goodActivityId;
    }

    public void setGoodActivityId(Long goodActivityId) {
        this.goodActivityId = goodActivityId;
    }

    public String getGoodDetail() {
        return goodDetail;
    }

    public void setGoodDetail(String goodDetail) {
        this.goodDetail = goodDetail == null ? null : goodDetail.trim();
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

    public String getMarketStatus() {
        return marketStatus;
    }

    public void setMarketStatus(String marketStatus) {
        this.marketStatus = marketStatus == null ? null : marketStatus.trim();
    }

    public String getMarketFlag() {
        return marketFlag;
    }

    public void setMarketFlag(String marketFlag) {
        this.marketFlag = marketFlag == null ? null : marketFlag.trim();
    }
}