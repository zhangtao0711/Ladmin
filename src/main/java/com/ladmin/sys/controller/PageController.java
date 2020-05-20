package com.ladmin.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PageController {
	 @RequestMapping("doLoginUI")
	  public String doLoginUI() {
		  return "login";
	  }
	 @RequestMapping("doIndexUI")
	  public String doIndexUI() {
		  return "index";
	  }

	 @RequestMapping("doPageUI")
	 public String doPageUI() {
		 return"page";
	 }
	 @RequestMapping("member/member-del")
		public String domember() {
			return "html/member-del";
		}
	 
}