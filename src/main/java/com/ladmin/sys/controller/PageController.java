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
<<<<<<< HEAD

=======
	 @RequestMapping("doDeleteMember")
	  public String doDeleteMember() {
		  return "member-del";
	  }
	 @RequestMapping("doPageUI")
	 public String doPageUI() {
		 return"page";
	 }
>>>>>>> 2eaf973f4968e64b6c2b45a070e523d4650c4760
}
