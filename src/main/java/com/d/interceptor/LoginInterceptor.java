package com.d.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


import com.d.entity.Person;

/**
 * 登录拦截
 */

@Component
public class LoginInterceptor implements HandlerInterceptor {

	
	  @Override 
	  public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception { 
		  
		  /**拦截请求**/
		  String requestUrl = request.getRequestURL().toString();
		  System.out.println("requestUrl:"+requestUrl);
		  
		  /** 判断session是否存在用户,如果存在说明用户已经登录了,应该放行 */
		  Object admin = request.getSession().getAttribute("name");
		  
		  System.out.println(request.getSession().toString());
		  System.out.println(admin); 
		  if(admin == null) { 
			  System.out.println("尚未登录，调到登录页面");
			  response.sendRedirect("/index.html");		  
			  return false; 
		  }
		  
		  return true; 
		 }
	  


	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("postHandle");

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("afterCompletion");

	}

}
