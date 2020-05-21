package com.ladmin.sys.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * qiao
 * @author Dell
 */
@Controller
@RequestMapping("/login")
public class LoginController {
	 
	  @RequestMapping("doLoginUI")
	  public String doLoginUI() {
		  System.out.println("doLogUI");
		  return "login";
	  }
	 
	 @RequestMapping("checkLogin")
	 public String checkLogin(HttpServletRequest request,HttpServletResponse response){
		 
//		 HashMap<String,Object> map =new HashMap<String,Object>();
//		 map.put("userNmae", username);
//		 map.put("pass", pass);
//		 request.setAttribute("user", map);
		  // 1 接收用户名 密码
		 String username=request.getParameter("userName");
		 String pass=request.getParameter("pass");
		 
		/*
		 * if(username==null||pass==null){ throw new ServiceException("buneng"); }
		 */
		 if(username.equals("admin") && pass.equals("admin")) {
			 System.out.println("登录成功");
			 //通过验证
			 // 2.重定向至index
		    return "redirect:/doIndexUI";
		 }else {
			 
			 return "error";
		 }
		
		 

	  }
	
	
	 
	 
	 
	 public String doLogout(HttpServletRequest request) {
		  // 1清除session
		 request.getSession().invalidate();
		  // 2.重定向至login
		  return "forward:/doLoginUI";
	  }
}
