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
@RequestMapping(value = "/user")
public class UserController extends BaseController{
	
	@Autowired
    private UserService userService;
	
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getUser(Model model, @PathVariable("id") Long id) {
        User user = userService.selectByPrimaryKey(id);
        model.addAttribute("user", user);
        return "user2";
    }
    
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String getUserList(Model model,Page page) {
    	PageData pd = new PageData();
		try{
			pd = this.getPageData();
			/*String keywords = pd.getString("keywords");							//检索条件 关键词
			if(null != keywords && !"".equals(keywords)){
				pd.put("keywords", keywords.trim());
			}*/
			page.setPd(pd);
			List<PageData>	userList=userService.listUsers(page);//列出用户列表
			int total=userService.listUsersCount();
			page.setCurrentResult(userList.size());
			page.setTotalResult(total);
			page.setTotalPage(page.getTotalPage());
			model.addAttribute("userList", userList);
			model.addAttribute("page", page);
		} catch(Exception e){
			e.printStackTrace();
		}
        return "userList";
    }
    
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String getUser() {
        return "user-Hello";
    }
	
	@RequestMapping(value = "/show1", method = RequestMethod.GET)
    public String getUserJsp(Model model) {
	 model.addAttribute("user", "jabin");
     return "user";
    }
	
	@RequestMapping(value = "/show2", method = RequestMethod.GET)
    public ModelAndView  getUserJsp2() {
		 ModelAndView res = new ModelAndView("user22");
	     res.addObject("user", "jabin");
	     return res;
    }
	
	
	@RequestMapping(value = "/show23", method = RequestMethod.GET)
    public String  addUser(Model model,Page page) {
		PageData pd = new PageData();
		try{
			pd = this.getPageData();
			/*String keywords = pd.getString("keywords");							//检索条件 关键词
			if(null != keywords && !"".equals(keywords)){
				pd.put("keywords", keywords.trim());
			}*/
			page.setPd(pd);
			List<PageData>	userList=userService.listUsers(page);//列出用户列表
			int total=userService.listUsersCount();
			page.setCurrentResult(userList.size());
			page.setTotalResult(total);
			page.setTotalPage(page.getTotalPage());
			model.addAttribute("userList", userList);
			model.addAttribute("page", page);
		} catch(Exception e){
			e.printStackTrace();
		}
        model.addAttribute("user", "jabin");
        return "user";
    }
}