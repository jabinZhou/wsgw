package com.zzb.shop.domain;

import java.io.Serializable;
import java.util.Date;

public class Advertise implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 6306826462022299298L;

	private Long id;

    private String title;

    private String name;

    private Long advertiseCategoryId;

    private String url;

    private Date createDate;

    private Date updateDate;

    private String delFlag;
    
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

    public Long getAdvertiseCategoryId() {
        return advertiseCategoryId;
    }

    public void setAdvertiseCategoryId(Long advertiseCategoryId) {
        this.advertiseCategoryId = advertiseCategoryId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
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