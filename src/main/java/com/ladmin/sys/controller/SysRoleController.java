package com.ladmin.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ladmin.common.vo.response.QueryResponseResult;
import com.ladmin.sys.service.SysPermissionService;
import com.ladmin.sys.service.SysRoleService;

/**
 *@author 刘小刘
 *角色控制类
 * 
 */
@RestController
@RequestMapping("/role")
public class SysRoleController {
	
	@Autowired
	private SysRoleService sysRoleService;
	
	@Autowired
	private SysPermissionService sysPermissionService;

	@GetMapping("/list")
	public QueryResponseResult findList( int page,int size,String beginTime,String endTime,String name) {
		
		return sysRoleService.findRoleList(page,size ,beginTime,endTime,name);
	}
	@GetMapping("/edit/{roleId}")
	public QueryResponseResult findbyId(@PathVariable("roleId")long roleId) {
		return sysRoleService.findRoleByRoleId(roleId);
	}


}
