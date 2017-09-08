package com.zzb.shop.domain;

public class Follow {
    private Long userId;

    private Long goodDetailId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getGoodDetailId() {
        return goodDetailId;
    }

    public void setGoodDetailId(Long goodDetailId) {
        this.goodDetailId = goodDetailId;
    }
}