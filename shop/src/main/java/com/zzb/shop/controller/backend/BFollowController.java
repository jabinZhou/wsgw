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
import com.zzb.shop.domain.Follow;
import com.zzb.shop.domain.Page;
import com.zzb.shop.domain.PushMsg;
import com.zzb.shop.domain.User;
import com.zzb.shop.service.FollowService;
import com.zzb.shop.util.JSON;
import com.zzb.shop.util.PageData;
import com.zzb.shop.util.StringUtil;
/**
 * 
 * @author zhouzb
 *
 */
@Controller
@RequestMapping(value = "/backend/follow")
public class BFollowController extends BaseController{

	@Autowired
	private FollowService followService;
	
	
	/**
	 * 列表页
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "follow")
	public String sysUser(Model model) {
		return "backend/follow/follow";
	}
	/**
	 * 列表数据页
	 * @param model
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/followList")
	@ResponseBody
	public Object sysUserList(Model model,Page page) {
		PageData pd = new PageData();
		HashMap result = new HashMap();
		pd = this.getPageData();
		String key = pd.getString("key"); // 检索条件 关键词
		if (null != key && !"".equals(key)) {
			pd.put("key", key.trim());
		}
		pd.put("sortField","a."+pd.get("sortField"));
		page.setPd(pd);
		List<PageData> list = followService.list(page);// 列出用户列表
		int total = followService.listCount(page);
		result.put("data", list);
		result.put("total", total);
		String json = JSON.Encode(result);
		return json;
		
	}
	
	/**
	 * 新增、编辑页
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "editFollow")
	public String editSysUser(Model model) {
		return "backend/follow/editFollow";
	}
	/**
	 * 
	 * @param model
	 * @param follow 
	 * @param isFollow 是否关注 0否 1是
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/ajaxFollow")
	@ResponseBody
	public Object ajaxLogin(Model model,Follow follow,Integer isFollow,HttpServletRequest request,HttpServletResponse response) {
		//登录成功标志
		PushMsg pushMsg=new PushMsg("操作成功！",true);
		pushMsg.setCode("1");
		try{			
			int ret=followService.follow(follow, isFollow);
			if(ret>0){
				
			}else{
				pushMsg.setStatus(false);
				pushMsg.setCode("0");
				pushMsg.setInfo("操作失败请稍后再试！");
			}
		}catch(Exception ex){
			ex.printStackTrace();
			pushMsg.setStatus(false);
			pushMsg.setCode("0");
			pushMsg.setInfo("操作失败请稍后再试！");
		}
		return pushMsg;
	}
}
