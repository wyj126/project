package com.d.controller;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.d.entity.Person;
import com.d.service.IService;

@RestController
@RequestMapping("/loginController")
public class LoginHandler {

	//	personlogin adminlogin
	
	@Autowired
	private IService personService;
	
	@Autowired
	private com.d.service.adminService adminService;
	
	
	@RequestMapping("/adminlogin")
	public String queryByname(@RequestParam(value="name") String aname,@RequestParam(value="password") String apassword,HttpSession session) {
		String is = null;
		is = adminService.queryAdmin(aname, apassword);
		 if (is != null && !"".equals(is)) {
	            session.setAttribute("name", aname);
	        } else {
	        	
	        }
		System.out.println(aname+"----"+apassword);
		
		return is;
	}
	
	@RequestMapping("/personlogin")
	public String queryByname2(@RequestParam(value="name") String name,@RequestParam(value="password") String password,HttpSession session) {
		String is = null;
		is = personService.queryLogin(name, password);
		 if (is != null && !"".equals(is)) {
	            session.setAttribute("name", name);
	        } else {
	        	
	        }
		return is;
	}
	
	
	@RequestMapping("/loginout")
	public ModelAndView queryByname3(HttpSession session) {
		 session.removeAttribute("name");
        return new ModelAndView(new RedirectView("/index.html"));
	}
	
}
