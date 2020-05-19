package com.ladmin.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * zhangtao
 * 会员删除
 * */
import com.ladmin.common.vo.JsonResult;
import com.ladmin.sys.service.SysUserService;

/**
 * zt
 *会员删除
 * */
@RestController
@RequestMapping("/user")
public class SysUserController {
	@Autowired
	SysUserService sysUserService;
	@RequestMapping("doFindUsers")
	public JsonResult doFindUsers(String username,String startTime,String endTime,Integer pageCurrent) {		
		return new JsonResult(sysUserService.findObjects(username, startTime, endTime, pageCurrent));
	}
}
