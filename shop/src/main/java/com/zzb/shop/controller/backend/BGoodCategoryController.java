package com.zzb.shop.controller.backend;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zzb.shop.controller.BaseController;
import com.zzb.shop.domain.GoodCategory;
import com.zzb.shop.domain.Page;
import com.zzb.shop.domain.PushMsg;
import com.zzb.shop.service.GoodCategoryService;
import com.zzb.shop.util.JSON;
import com.zzb.shop.util.PageData;
import com.zzb.shop.util.StringUtil;

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
	 * 列表页
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "goodCategory")
	public String sysUser(Model model) {
		return "backend/goodCategory/goodCategory";
	}
	/**
	 * 列表数据页
	 * @param model
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/goodCategoryList")
	@ResponseBody
	public Object goodCategoryList(Model model,Page page) {
		PageData pd = new PageData();
		HashMap result = new HashMap();
		pd = this.getPageData();
		String key = pd.getString("key"); // 检索条件 关键词
		if (null != key && !"".equals(key)) {
			pd.put("key", key.trim());
		}
		page.setPd(pd);
		List<PageData> list = goodCategoryService.list(page);
		String json = JSON.Encode(list);
		return json;
		
	}
	
	
	
	/**
	 * 点击树形页
	 * @param model
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/goodCategoryListClick")
	@ResponseBody
	public Object sysUserListClick(Model model,Page page) {
		PageData pd = new PageData();
		HashMap result = new HashMap();
		pd = this.getPageData();
		String key = pd.getString("key"); // 检索条件 关键词
		if (null != key && !"".equals(key)) {
			pd.put("key", key.trim());
		}
		page.setPd(pd);
		List<PageData> list = goodCategoryService.list(page);// 列出用户列表
		if(list!=null&&list.size()>0){
			for(HashMap d:list){
				d.put("id",d.get("id"));
				d.put("pid",d.get("parent_id"));
				d.put("text",d.get("name"));
			}
			
		}else{
			list=new ArrayList<PageData>();
		}
		PageData m=new PageData();
		m.put("id", 0);
		m.put("pid", null);
		m.put("text", "顶层");
		list.add(m);
		String json = JSON.Encode(list);
		return json;
		
	}
	
	@RequestMapping(value = "/delGoodCategory")
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
				goodCategoryService.deleteByPrimaryKey(Long.parseLong(id));
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
	@RequestMapping(value = "editGoodCategory")
	public String editSysUser(Model model) {
		return "backend/goodCategory/editGoodCategory";
	}
	/**
	 * 获取用户
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/getGoodCategory")
	@ResponseBody
	public Object getSysUser(Page page){
		PushMsg pushMsg = new PushMsg("获取成功！", true);
		pushMsg.setCode("1");
		try{
			PageData pd = new PageData();
			pd = this.getPageData();
			String id = pd.getString("id");
			GoodCategory domain = goodCategoryService.selectByPrimaryKey(Long.parseLong(id));
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
	 * 保存分类
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/saveGoodCategory")
	@ResponseBody
	public Object saveGoodCategory(GoodCategory domain){
		PushMsg pushMsg = new PushMsg("保存成功！", true);
		pushMsg.setCode("1");
		try {
			Date date=new Date();
			if (StringUtil.isNullOrEmpty(domain.getId())){
				
				domain.setCreateDate(date);
				domain.setUpdateDate(date);
				domain.setDelFlag("0");
				goodCategoryService.insert(domain);
			}else{
				
				domain.setUpdateDate(date);
				goodCategoryService.updateByPrimaryKeySelective(domain);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			pushMsg.setStatus(false);
			pushMsg.setCode("0");
			pushMsg.setInfo("保存失败请稍后再试！");
		}
		return pushMsg;
	}
}
