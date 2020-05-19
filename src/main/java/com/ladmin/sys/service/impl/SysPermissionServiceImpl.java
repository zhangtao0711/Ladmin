package com.ladmin.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ladmin.sys.dao.SysPermissionDao;
import com.ladmin.sys.entity.SysPermission;
import com.ladmin.sys.service.SysPermissionService;

@Service
public class SysPermissionServiceImpl implements SysPermissionService {
	@Autowired
	private SysPermissionDao permissionDao;

	/**
	 * 权限列表
	 * 
	 */
	@Override
	public List<SysPermission> getPermissions() {
		List<SysPermission> sysPermissions = permissionDao.getSysPermissions();
		return sysPermissions;
	}
}
