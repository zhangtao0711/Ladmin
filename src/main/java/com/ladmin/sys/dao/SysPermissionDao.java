package com.ladmin.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ladmin.sys.entity.SysPermission;

@Mapper
public interface SysPermissionDao {
	/** <!--权限列表 --> */
	List<SysPermission> getSysPermissions();
	/**
	 * 
	 */
}
