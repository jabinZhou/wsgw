package com.zzb.shop.controller.frontend;

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
import com.zzb.shop.domain.Order;
import com.zzb.shop.domain.Page;
import com.zzb.shop.domain.PushMsg;
import com.zzb.shop.domain.ShopCar;
import com.zzb.shop.domain.SysUser;
import com.zzb.shop.domain.User;
import com.zzb.shop.service.OrderService;
import com.zzb.shop.util.JSON;
import com.zzb.shop.util.PageData;
import com.zzb.shop.util.StringUtil;
/**
 * 
 * @author zhouzb
 *
 */
@Controller
@RequestMapping(value = "/frontend/order")
public class OrderController extends BaseController{

	@Autowired
	private OrderService orderService;
	
	
	/**
	 * 列表页
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "order")
	public String sysUser(Model model) {
		return "backend/order/order";
	}
	/**
	 * 列表数据页
	 * @param model
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/orderList")
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
		List<PageData> list = orderService.list(page);// 列出用户列表
		int total = orderService.listCount(page);
		result.put("data", list);
		result.put("total", total);
		String json = JSON.Encode(result);
		return json;
		
	}
	@RequestMapping(value = "/delOrder")
	@ResponseBody
	public Object delSysUser(Page page){
		PushMsg pushMsg = new PushMsg("删除成功！", true);
		pushMsg.setCode("1");
		try {
			PageData pd = new PageData();
			pd = this.getPageData();
			String idStr = pd.getString("id");
			if (StringUtil.isNullOrEmpty(idStr))
				return pushMsg;
			String[] ids = idStr.split(",");
			for (int i = 0, l = ids.length; i < l; i++) {
				String id = ids[i];
				orderService.deleteByPrimaryKey(Long.parseLong(id));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			pushMsg.setStatus(false);
			pushMsg.setCode("0");
			pushMsg.setInfo("删除失败请稍后再试！");
		}
		return pushMsg;

	}
	/**
	 * 新增、编辑页
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "editOrder")
	public String editSysUser(Model model) {
		return "backend/order/editOrder";
	}
	/**
	 * 获取用户
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/getOrder")
	@ResponseBody
	public Object getSysUser(Page page){
		PushMsg pushMsg = new PushMsg("获取成功！", true);
		pushMsg.setCode("1");
		try{
			PageData pd = new PageData();
			pd = this.getPageData();
			String id = pd.getString("id");
			Order domain = orderService.selectByPrimaryKey(Long.parseLong(id));
			String json = JSON.Encode(domain);
			Map<String,Object>attr=new HashMap<String,Object>();
			attr.put("data", json);
			pushMsg.setAttr(attr);
		}catch(Exception ex){
			ex.printStackTrace();
			pushMsg.setStatus(false);
			pushMsg.setCode("0");
			pushMsg.setInfo("获取失败请稍后再试！");
		}
		return pushMsg;

	}
	
	/**
	 * 保存用户
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/saveOrder")
	@ResponseBody
	public Object saveSysUser(Order domain){
		PushMsg pushMsg = new PushMsg("保存成功！", true);
		pushMsg.setCode("1");
		try {
			Date date=new Date();
			if (StringUtil.isNullOrEmpty(domain.getId())){
				
				domain.setCreateDate(date);
				domain.setUpdateDate(date);
				domain.setDelFlag("0");
				orderService.insert(domain);
			}else{
				
				domain.setUpdateDate(date);
				orderService.updateByPrimaryKeySelective(domain);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			pushMsg.setStatus(false);
			pushMsg.setCode("0");
			pushMsg.setInfo("保存失败请稍后再试！");
		}
		return pushMsg;
	}
	
	/**
	 * 购买
	 * @param model
	 * @param order
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/ajaxAddOrder")
	@ResponseBody
	public Object ajaxAddOrder(Model model,Order order,HttpServletRequest request,HttpServletResponse response) {
		//登录成功标志
		PushMsg pushMsg=new PushMsg("操作成功！",true);
		pushMsg.setCode("1");
		try{		
			User user=(User) request.getSession().getAttribute("user");
			order.setUserId(user.getId());
			int ret=orderService.addOrder(order);
			if(ret<0){
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
	
	/**
	 * 付款
	 * @param model
	 * @param order
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/ajaxPayOrder")
	@ResponseBody
	public Object ajaxPayOrder(Model model,Order order,HttpServletRequest request,HttpServletResponse response) {
		//登录成功标志
		PushMsg pushMsg=new PushMsg("操作成功！",true);
		pushMsg.setCode("1");
		try{		
			User user=(User) request.getSession().getAttribute("user");
			Order o=orderService.selectByPrimaryKey(order.getId());
			if(o!=null){
				o.setOrderStatus(Order.PAY_STATUS);
				int ret=orderService.updateByPrimaryKey(order);
				if(ret<0){
					pushMsg.setStatus(false);
					pushMsg.setCode("0");
					pushMsg.setInfo("操作失败请稍后再试！");
				}
			}else{
				pushMsg.setStatus(false);
				pushMsg.setCode("0");
				pushMsg.setInfo("订单不存在请稍后再试！");
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
			pushMsg.setStatus(false);
			pushMsg.setCode("0");
			pushMsg.setInfo("操作失败请稍后再试！");
		}
		return pushMsg;
	}
	
	/**
	 * 确认买家已付款
	 * @param model
	 * @param order
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/ajaxWiatShippingOrder")
	@ResponseBody
	public Object ajaxWiatShippingOrder(Model model,Order order,HttpServletRequest request,HttpServletResponse response) {
		//登录成功标志
		PushMsg pushMsg=new PushMsg("操作成功！",true);
		pushMsg.setCode("1");
		try{		
			Order o=orderService.selectByPrimaryKey(order.getId());
			if(o!=null){
				o.setOrderStatus(Order.WAIT_SHIPPING_STATUS);
				int ret=orderService.updateByPrimaryKey(order);
				if(ret<0){
					pushMsg.setStatus(false);
					pushMsg.setCode("0");
					pushMsg.setInfo("操作失败请稍后再试！");
				}
			}else{
				pushMsg.setStatus(false);
				pushMsg.setCode("0");
				pushMsg.setInfo("订单不存在请稍后再试！");
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
			pushMsg.setStatus(false);
			pushMsg.setCode("0");
			pushMsg.setInfo("操作失败请稍后再试！");
		}
		return pushMsg;
	}
	
	/**
	 * 卖家发货
	 * @param model
	 * @param order
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/ajaxShippingOrder")
	@ResponseBody
	public Object ajaxShippingOrder(Model model,Order order,HttpServletRequest request,HttpServletResponse response) {
		//登录成功标志
		PushMsg pushMsg=new PushMsg("操作成功！",true);
		pushMsg.setCode("1");
		try{		
			Order o=orderService.selectByPrimaryKey(order.getId());
			if(o!=null){
				o.setOrderStatus(Order.SHIPPING_STATUS);
				o.setExpressCode(order.getExpressCode());
				int ret=orderService.updateByPrimaryKey(order);
				if(ret<0){
					pushMsg.setStatus(false);
					pushMsg.setCode("0");
					pushMsg.setInfo("操作失败请稍后再试！");
				}
			}else{
				pushMsg.setStatus(false);
				pushMsg.setCode("0");
				pushMsg.setInfo("订单不存在请稍后再试！");
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
			pushMsg.setStatus(false);
			pushMsg.setCode("0");
			pushMsg.setInfo("操作失败请稍后再试！");
		}
		return pushMsg;
	}
	
	/**
	 * 确认收货
	 * @param model
	 * @param order
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/ajaxFinishOrder")
	@ResponseBody
	public Object ajaxFinishOrder(Model model,Order order,HttpServletRequest request,HttpServletResponse response) {
		//登录成功标志
		PushMsg pushMsg=new PushMsg("操作成功！",true);
		pushMsg.setCode("1");
		try{		
			Order o=orderService.selectByPrimaryKey(order.getId());
			if(o!=null){
				o.setOrderStatus(Order.FINISH_STATUS);
				int ret=orderService.updateByPrimaryKey(order);
				if(ret<0){
					pushMsg.setStatus(false);
					pushMsg.setCode("0");
					pushMsg.setInfo("操作失败请稍后再试！");
				}
			}else{
				pushMsg.setStatus(false);
				pushMsg.setCode("0");
				pushMsg.setInfo("订单不存在请稍后再试！");
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
