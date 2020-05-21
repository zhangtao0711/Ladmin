package com.ladmin.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ladmin.common.vo.response.QueryResponseResult;
import com.ladmin.common.vo.response.ResponseResult;
import com.ladmin.sys.entity.SysRole;
import com.ladmin.sys.service.SysPermissionService;
import com.ladmin.sys.service.SysRoleService;

import io.micrometer.core.instrument.util.StringUtils;

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
	public QueryResponseResult findbyId(@PathVariable("roleId")Integer roleId) {
		return sysRoleService.findRoleByRoleId(roleId);
	}

	@PostMapping("/save")
	public ResponseResult save(SysRole role,Integer... permissionId) {
		
		if(role.getRoleId()!=null&&role.getRoleId()!=0) {
			return sysRoleService.updateRole(role,permissionId);
		}
		
		return sysRoleService.insertRole(role,permissionId);
	}
	
	@GetMapping("/updateStatus")
	public ResponseResult updateStatus(Integer roleId,String status) {
		return sysRoleService.updateStatusById(roleId, status);
	}
	
	@GetMapping("/delete")
	public  ResponseResult  deleteById(Integer roleId) {
		return sysRoleService.deleteRoleById(roleId);
	}

	@GetMapping("/deleteByIds")
	public  ResponseResult  deleteById(Integer... roleIds) {
		return sysRoleService.deleteRoleByIds(roleIds);
	}
	@GetMapping("/checkRoleName/{roleName}")
	public QueryResponseResult checkRoleName(@PathVariable("roleName")String roleName) {
		return sysRoleService.checkRoleNameExist(roleName);
	}
	
	@GetMapping("/checkRoleKey/{roleKey}")
	public QueryResponseResult checkRoleKey(@PathVariable("roleKey")String roleKey) {
		return sysRoleService.checkRoleKeyExist(roleKey);
	}
}
