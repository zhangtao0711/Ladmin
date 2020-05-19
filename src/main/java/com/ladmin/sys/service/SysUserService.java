<<<<<<< HEAD
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
=======
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
>>>>>>> 8566b1a0014d120eafb395a0ab4e47bd2c0a9f08
