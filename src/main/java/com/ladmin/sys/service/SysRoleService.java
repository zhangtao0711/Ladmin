package com.ladmin.sys.service;

import com.ladmin.common.vo.response.QueryResponseResult;
import com.ladmin.common.vo.response.ResponseResult;
import com.ladmin.sys.entity.SysRole;

/**
 *@author 刘小刘
 *角色业务接口层 
 */
public interface SysRoleService {

	/**根据条件分页*/
	public QueryResponseResult findRoleList(int page, int size, String beginTime, String endTime, String name);
	
	/**根据用户ID查找角色列表*/
	public QueryResponseResult findRoleListByUserId(String userId);
	
	/**根据RoleId 查找角色*/
	public QueryResponseResult findRoleByRoleId(Integer roleId);
	
	/**根据roleId删除角色表*/
	public ResponseResult deleteRoleById(Integer roleId);
	
	/**根据roleId批量删除角色表*/
	public ResponseResult deleteRoleByIds(Integer[] roleIds);
	
	/**新增一条信息*/
	public ResponseResult insertRole(SysRole role,Integer... permissionIds);
	
	/**更新一条信息*/
	public ResponseResult updateRole(SysRole role,Integer... permissionIds);
	
	/**检查角色名是否存在*/
	public QueryResponseResult checkRoleNameExist(String roleName);
	
	/**检查角色权限是否存在*/
	public QueryResponseResult checkRoleKeyExist(String RoleKey);
	
	public ResponseResult updateStatusById(Integer roleId,String status);

	

	
}
