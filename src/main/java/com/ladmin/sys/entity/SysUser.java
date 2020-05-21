package com.ladmin.sys.entity;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Date;

public class SysUser implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6981181795331029160L;
    private Integer user_id;
    private String user_name;
    private String user_sex;
    private String user_phone;
    private String salt;
    private String user_email;
    private String user_address;
    private Date user_jointime;
    private String user_state;
    private Charset user_pwd;
    
    public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	private String user_move;
    private String user_password;
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_sex() {
		return user_sex;
	}
	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_address() {
		return user_address;
	}
	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}
	public Date getUser_jointime() {
		return user_jointime;
	}
	public void setUser_jointime(Date user_jointime) {
		this.user_jointime = user_jointime;
	}
	public String getUser_state() {
		return user_state;
	}
	public void setUser_state(String user_state) {
		this.user_state = user_state;
	}
	public String getUser_move() {
		return user_move;
	}
	public void setUser_move(String user_move) {
		this.user_move = user_move;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
