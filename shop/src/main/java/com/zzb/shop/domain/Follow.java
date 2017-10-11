package com.zzb.shop.domain;

import java.io.Serializable;

public class Follow implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 3913160444925438519L;

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