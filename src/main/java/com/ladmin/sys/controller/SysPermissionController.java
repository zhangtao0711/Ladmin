package com.ladmin.sys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ladmin.common.vo.JsonResult;
import com.ladmin.sys.entity.SysPermission;
import com.ladmin.sys.service.SysPermissionService;

@Controller
@ResponseBody
@RequestMapping("/permission/")
public class SysPermissionController {
	@Autowired
	private SysPermissionService sysPermissionService;

	@RequestMapping("getPermissions")
	public JsonResult getPermissions() {
		List<SysPermission> permissions = sysPermissionService.getPermissions();
		return new JsonResult(permissions);
	}
}
