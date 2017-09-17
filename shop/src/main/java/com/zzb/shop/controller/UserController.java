package com.zzb.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zzb.shop.domain.Page;
import com.zzb.shop.domain.User;
import com.zzb.shop.service.UserService;
import com.zzb.shop.util.PageData;

@Controller
@RequestMapping(value = "/frontend/user")
public class UserController extends BaseController{
	
	@Autowired
    private UserService userService;
	
	/**
	 * 主页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "buyMain")
	public String buyMain(Model model) {
		return "frontend/user/buyMain";
	}
	
	@RequestMapping(value = "sellMain")
	public String sellMain(Model model) {
		return "frontend/user/sellMain";
	}
    
}