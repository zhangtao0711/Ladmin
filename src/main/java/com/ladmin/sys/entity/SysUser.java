package com.ladmin.sys.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/**
*@author zhangtao
*说明:会员信息封装
*/
@Data
public class SysUser {
	private Integer userid;
	private String username;
	private String usersex;
	private Integer userphone;
	private String useremail;
	private String useraddress;
	 @JsonFormat(pattern = "yyyy-MM-dd")
	private Date userjoinDate;
	private Integer userstate=0;
	
}
