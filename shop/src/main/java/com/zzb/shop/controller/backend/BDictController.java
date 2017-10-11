package com.zzb.shop.controller.backend;

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
import com.zzb.shop.domain.Dict;
import com.zzb.shop.domain.Page;
import com.zzb.shop.domain.PushMsg;
import com.zzb.shop.service.DictService;
import com.zzb.shop.util.JSON;
import com.zzb.shop.util.PageData;
import com.zzb.shop.util.StringUtil;
/**
 * 
 * @author zhouzb
 *
 */
@Controller
@RequestMapping(value = "/backend/dict")
public class BDictController extends BaseController{

	@Autowired
	private DictService dictService;
	
	
	/**
	 * 列表页
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "dict")
	public String sysUser(Model model) {
		return "backend/dict/dict";
	}
	/**
	 * 获取字典列表
	 * @param model
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/dictList")
	@ResponseBody
	public Object sysUserList(Model model,Page page) {
		PageData pd = new PageData();
		HashMap result = new HashMap();
		pd = this.getPageData();
		String key = pd.getString("key"); // 检索条件 关键词
		if (null != key && !"".equals(key)) {
			pd.put("key", key.trim());
		}
		//pd.put("sortField","a."+pd.get("sortField"));
		page.setPd(pd);
		List<PageData> list = dictService.list(page);// 列出用户列表
		/*int total = dictService.listCount(page);
		result.put("data", list);
		result.put("total", total);*/
		String json = JSON.Encode(list);
		return json;
		
	}
	
	/**
	 * 获取所有字典列表
	 * @param model
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/allList")
	@ResponseBody
	public Object allList(Model model,Page page) {
		PageData pd = new PageData();
		HashMap result = new HashMap();
		pd = this.getPageData();
		String key = pd.getString("key"); // 检索条件 关键词
		if (null != key && !"".equals(key)) {
			pd.put("key", key.trim());
		}
		//pd.put("sortField","a."+pd.get("sortField"));
		page.setPd(pd);
		List<PageData> list = dictService.list(page);// 列出用户列表
		int total = dictService.listCount(page);
		result.put("data", list);
		result.put("total", total);
		String json = JSON.Encode(result);
		return json;
		
	}
	
	@RequestMapping(value = "/delDict")
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
				dictService.deleteByPrimaryKey(Long.parseLong(id));
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
	@RequestMapping(value = "editDict")
	public String editSysUser(Model model) {
		return "backend/dict/editDict";
	}
	/**
	 * 获取用户
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/getDict")
	@ResponseBody
	public Object getSysUser(Page page){
		PushMsg pushMsg = new PushMsg("获取成功！", true);
		pushMsg.setCode("1");
		try{
			PageData pd = new PageData();
			pd = this.getPageData();
			String id = pd.getString("id");
			Dict domain = dictService.selectByPrimaryKey(Long.parseLong(id));
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
	@RequestMapping(value = "/saveDict")
	@ResponseBody
	public Object saveSysUser(Dict domain){
		PushMsg pushMsg = new PushMsg("保存成功！", true);
		pushMsg.setCode("1");
		try {
			Date date=new Date();
			if (StringUtil.isNullOrEmpty(domain.getId())){
				
				domain.setCreateDate(date);
				domain.setUpdateDate(date);
				domain.setDelFlag("0");
				dictService.insert(domain);
			}else{
				
				domain.setUpdateDate(date);
				dictService.updateByPrimaryKeySelective(domain);
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
