package com.zzb.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 
 * @author Administrator
 *
 */
@Controller
public class IndexController {

	/**
	 * 首页
	 */
	@RequestMapping(value = "")
	public String index(Model model) {
		return "index";
	}
}
