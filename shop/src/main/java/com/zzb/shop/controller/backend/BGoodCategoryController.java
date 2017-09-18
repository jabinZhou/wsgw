package com.zzb.shop.controller.backend;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzb.shop.controller.BaseController;
import com.zzb.shop.domain.Page;
import com.zzb.shop.service.GoodCategoryService;
import com.zzb.shop.util.JSON;
import com.zzb.shop.util.PageData;

/**
 * 
 * @author zhouzb
 *
 */
@Controller
@RequestMapping(value = "/backend/goodCategory")
public class BGoodCategoryController extends BaseController{

	@Autowired
	private GoodCategoryService goodCategoryService;
	
	
	/**
	 * 列表数据页
	 * @param model
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/goodCategoryList")
	@ResponseBody
	public Object sysUserList(Model model,Page page) {
		PageData pd = new PageData();
		HashMap result = new HashMap();
		pd = this.getPageData();
		String key = pd.getString("key"); // 检索条件 关键词
		if (null != key && !"".equals(key)) {
			pd.put("key", key.trim());
		}
		page.setPd(pd);
		List<PageData> goodCategoryList = goodCategoryService.listGoodCategorys(page);// 列出用户列表
		int total = goodCategoryService.listGoodCategorysCount();
		result.put("data", goodCategoryList);
		result.put("total", total);
		String json = JSON.Encode(result);
		return json;
		
	}
}
