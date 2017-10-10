package com.zzb.shop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.zzb.shop.domain.SysUser;
import com.zzb.shop.domain.User;

public class SessionInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String path=request.getContextPath();
		String url=request.getRequestURI();
		//登录不做拦截
		if(url.contains("/admin")||("/").equals(url)||url.contains("/login")||url.contains("/ajaxLogin")||url.contains("/ajaxCommon")||url.contains("/file")||url.contains("/city")||url.contains("/goodIndexList")){
			return true;
		}
		if(request.getRequestURI().contains("/frontend")){
			User user=(User) request.getSession().getAttribute("user");
			if(user!=null){
				request.getSession().setAttribute("user", user);
				return true;
			}else{
				response.sendRedirect(path+"/login");  
				return false;
			}
		}else{
			SysUser sysUser=(SysUser) request.getSession().getAttribute("sysUser");
			if(sysUser!=null){
				request.getSession().setAttribute("sysUser", sysUser);
				return true;
			}else{
				
				response.sendRedirect(path+"/admin");  
				return false;
			}
		}
		
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
