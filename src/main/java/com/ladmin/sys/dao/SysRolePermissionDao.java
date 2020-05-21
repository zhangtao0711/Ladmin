package com.ladmin.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.ladmin.sys.entity.SysRolePermission;

@Mapper
public interface SysRolePermissionDao {

	@Select("select * from sys_role_permission where role_id=#{roleId}")
	public List<SysRolePermission> findByRoleId(Integer roleId);
	
	@Delete("delete from sys_role_permission where role_id=#{roleId}")
	public int deleteByRoleId(Integer roleId);
	
	@Insert("insert into sys_role_permission values(null,#{roleId},#{permissionId}) ")
	public int insert(SysRolePermission rolePermission);
}
