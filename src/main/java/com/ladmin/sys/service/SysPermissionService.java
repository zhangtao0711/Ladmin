package com.ladmin.sys.service;

import java.util.List;

import com.ladmin.sys.entity.SysPermission;

public interface SysPermissionService {
	/**
	 * 权限列表
	 * 
	 * @return List<SysPermission>
	 */
	List<SysPermission> getPermissions();
}
