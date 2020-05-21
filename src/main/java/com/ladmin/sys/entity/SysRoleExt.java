package com.ladmin.sys.entity;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class SysRoleExt implements Serializable{

	private SysRole sysRole;
	private List<SysRolePermission> listRolePermission;
	
}
