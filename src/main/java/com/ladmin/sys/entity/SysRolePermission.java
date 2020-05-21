package com.ladmin.sys.entity;
/**
 *@author 刘小刘 
 * 角色权限表
 */

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SysRolePermission implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8675638867817480230L;

	private Integer roleId;
	private Integer PermissionId;
	
}
