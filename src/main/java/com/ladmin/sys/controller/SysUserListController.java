package com.ladmin.sys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ladmin.common.vo.JsonResult;
import com.ladmin.sys.entity.SysUserList;
import com.ladmin.sys.service.SysUserListService;
import com.ladmin.sys.vo.SysUserListVo;
/**
 * qiao
 * @author Dell
 */
@Controller
@RequestMapping("/user")
public class SysUserListController {
	
	@Autowired
	private SysUserListService sysUserListService;
	
	@RequestMapping("/doFindActivitys")
	public JsonResult doFindActivitys(Model model) {
		List<SysUserList> list=sysUserListService.findObjects();
		System.out.println("list="+list);
		model.addAttribute("list", list);
		
		return new JsonResult(sysUserListService.findObjects());
	} 
}
