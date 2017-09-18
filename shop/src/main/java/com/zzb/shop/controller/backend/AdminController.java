package com.zzb.shop.controller.backend;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzb.shop.controller.BaseController;
import com.zzb.shop.domain.Page;
import com.zzb.shop.domain.PushMsg;
import com.zzb.shop.domain.SysUser;
import com.zzb.shop.service.SysUserService;
import com.zzb.shop.util.JSON;
import com.zzb.shop.util.PageData;
import com.zzb.shop.util.StringUtil;
/**
 * 
 * @author zhouzb
 *
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController extends BaseController{

	@Autowired
	private SysUserService sysUserService;
	/**
	 * 登录页
	 */
	@RequestMapping(value = "")
	public String index(Model model) {
		return "admin/login";
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
	public Object ajaxLogin(Model model,SysUser sysUser,HttpServletRequest request,HttpServletResponse response) {
		//登录成功标志
		PushMsg pushMsg=new PushMsg("登录成功！",true);
		pushMsg.setCode("1");
		try{			
			SysUser sys=sysUserService.selectUser(sysUser);
			if(sys==null){
				pushMsg.setCode("2");	
				pushMsg.setInfo("没有此用户或密码错误！");
			}else{
				request.getSession().setAttribute("sysUser", sys);
			}
		}catch(Exception ex){
			ex.printStackTrace();
			pushMsg.setStatus(false);
			pushMsg.setCode("0");
			pushMsg.setInfo("登录失败请稍后再试！");
		}
		return pushMsg;
	}
	
}
