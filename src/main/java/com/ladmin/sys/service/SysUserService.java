package com.ladmin.sys.service;

import java.util.List;

import com.ladmin.common.vo.PageObject;
import com.ladmin.sys.entity.SysUser;

/**
*@author zhangtao
*说明:会员删除
*/

public interface SysUserService {
	//查询总删除会员的记录
	
	PageObject<SysUser>findObjects(String username,String startTime,String endTime,Integer pageCurrent);
	
}
