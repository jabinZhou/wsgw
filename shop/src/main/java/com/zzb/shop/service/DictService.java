package com.zzb.shop.service;

import java.util.List;

import com.zzb.shop.domain.Dict;
import com.zzb.shop.domain.Page;
import com.zzb.shop.util.PageData;

public interface DictService {
	int deleteByPrimaryKey(Long id);

	int insert(Dict record);

	int insertSelective(Dict record);

	Dict selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(Dict record);

	int updateByPrimaryKey(Dict record);

	List<PageData> list(Page page);

	int listCount(Page page);
}
