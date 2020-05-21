package com.ladmin.sys.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class SysUserList implements Serializable {
	
	private static final long serialVersionUID = -4120833016920076997L;
	private Integer id;
	private String username;

	private String phone;
	private String email;
	private String listRole;//角色
	private Date listTime;//加入时间

}
