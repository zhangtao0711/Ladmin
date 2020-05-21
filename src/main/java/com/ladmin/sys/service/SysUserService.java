package com.ladmin.sys.service;
import java.nio.charset.Charset;
import java.util.List;
import com.ladmin.common.vo.PageObject;
import com.ladmin.sys.entity.SysUser;


public interface SysUserService {
	PageObject<SysUser> findPageObjects(String username,Integer pageCurrent);
	int saveObject(SysUser entit);
	int updateObject(SysUser entity);
	int updatePassword(Charset user_pwd,
			           Charset newuser_pwd,
			           Charset cfguser_pwd);
}
