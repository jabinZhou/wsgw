package com.zzb.shop.controller.frontend;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzb.shop.controller.BaseController;
import com.zzb.shop.domain.Good;
import com.zzb.shop.domain.Page;
import com.zzb.shop.domain.PushMsg;
import com.zzb.shop.domain.SysUser;
import com.zzb.shop.service.GoodService;
import com.zzb.shop.util.JSON;
import com.zzb.shop.util.PageData;
import com.zzb.shop.util.StringUtil;

/**
 * 
 * @author zhouzb
 *
 */
@Controller
@RequestMapping(value = "/goodIndexList")
public class GoodIndexController extends BaseController{

	@Autowired
	private GoodService goodService;
	
	
	@RequestMapping(value = "")
	public String index(Model model,Integer type,Page page) {
		PageData pd = new PageData();
		HashMap result = new HashMap();
		pd = this.getPageData();
		page.setPd(pd);
		//商品列表
		List<PageData> list = goodService.goodIndexList(page);// 列出用户列表
		model.addAttribute("list", list);
		return "frontend/good/goodList";
	}
	
	
	@RequestMapping(value = "/goodDetail")
	public String Detail(Model model,Integer id) {
		System.out.println("id---"+id);
		//商品详情
		model.addAttribute("id", id);
		return "frontend/good/goodDetail";
	}
	
	
	
}
