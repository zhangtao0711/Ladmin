package com.ladmin.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ladmin.sys.entity.SysRole;
/**
 *@author 刘小刘
 *角色Dao层
 * 
 */
@Mapper
public interface SysRoleDao {

	/**根据条件分页*/
	public List<SysRole> findRoleList(int page, int size, String beginTime, String endTime, String roleName);
	/**查询总记录数*/
	public int findRoleListCount(String beginTime, String endTime, String roleName);
	
	/**根据用户ID查找角色列表*/
	public List<SysRole> findRoleListByUserId(String userId);
	
	/**根据RoleId 查找角色*/

	public SysRole findRoleByRoleId(Integer roleId);
	
	/**根据roleId删除角色表*/
	@Update("update  sys_role set del_flag=1 where role_id=#{roleId}")
	public int deleteRoleById(Integer roleId);
	
	/**根据roleId批量删除角色表*/
	public int deleteRoleByIds(Integer[] roleIds);
	
	/**新增一条信息*/
	public int insertRole(SysRole role);
	
	/**删除一条信息*/
	public int updateRole(SysRole role);
	
	/**检查角色名是否存在*/
	@Select("select count(1) from sys_role where role_name=#{roleName}")
	public int checkRoleNameExist(String roleName);
	
	/**检查角色权限是否存在*/
	@Select("select count(1) from sys_role where role_key=#{roleKey}")
	public int checkRoleKeyExist(String roleKey);
	
	@Update("update sys_role set status =#{status} where role_id=#{roleId}")
	public void updateStatusById(Integer roleId,String status);




	
}
