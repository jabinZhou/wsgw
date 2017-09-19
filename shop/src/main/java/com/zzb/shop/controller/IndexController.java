package com.zzb.shop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzb.shop.domain.PushMsg;
import com.zzb.shop.domain.SysUser;
import com.zzb.shop.domain.User;
import com.zzb.shop.service.UserService;
/**
 * 
 * @author zhouzb
 *
 */
@Controller
public class IndexController {

	@Autowired
	private UserService userService;
	/**
	 * 首页
	 */
	@RequestMapping(value = "")
	public String index(Model model) {
		return "index";
	}
	
	/**
	 * 登录页
	 */
	@RequestMapping(value = "/login")
	public String login(Model model) {
		return "index/login";
	}
	
	/**
	 * 登录
	 * @param model
	 * @param sysUser
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/ajaxLogin")
	@ResponseBody
	public Object ajaxLogin(Model model,User user,HttpServletRequest request,HttpServletResponse response) {
		//登录成功标志
		PushMsg pushMsg=new PushMsg("登录成功！",true);
		pushMsg.setCode("1");
		try{			
			User u=userService.selectUser(user);
			if(u==null){
				pushMsg.setCode("2");	
				pushMsg.setInfo("没有此用户或密码错误！");
			}else{
				request.getSession().setAttribute("user", u);
				//用户类型 0买家 1卖家
				if(u.getUserType().equals("0")){
					pushMsg.setArg1(0);
				}else{
					pushMsg.setArg1(1);
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
			pushMsg.setStatus(false);
			pushMsg.setCode("0");
			pushMsg.setInfo("登录失败请稍后再试！");
		}
		return pushMsg;
	}
	
	@RequestMapping(value = "/ajaxCommon")
	@ResponseBody
	public Object ajaxCommon(HttpServletRequest request) {
		PushMsg pushMsg=new PushMsg("请求成功！",true);
		User user=(User) request.getSession().getAttribute("user");
		pushMsg.setCode("1");
		if(user!=null){
			
		}else{
			pushMsg.setStatus(false);
			pushMsg.setCode("0");
			pushMsg.setInfo("请求失败,session过期!");
		}
		return pushMsg;
	}
}
