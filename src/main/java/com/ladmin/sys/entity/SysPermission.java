package com.ladmin.sys.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class SysPermission implements Serializable {
	private static final long serialVersionUID = 2187325814658840997L;
	private int id;
	/** 权限名 */
	private String permissionName;
	/** 权限标识 */
	private String permissionLable;
	/** 权限类型 */
	private String permissionType;
}
