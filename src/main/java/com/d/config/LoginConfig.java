package com.d.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.d.interceptor.LoginInterceptor;

@SpringBootConfiguration
public class LoginConfig implements WebMvcConfigurer {

	@Autowired
	private LoginInterceptor li;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(li).addPathPatterns("/**").excludePathPatterns("/index.html","/","/utils/**","/","/css/**","/","/js/**","/","/favicon.ico","/","/loginController/adminlogin","/","/loginController/loginout","/");
		
		 
	}
	
	
}
