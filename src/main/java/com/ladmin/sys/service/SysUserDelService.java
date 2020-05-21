
package com.ladmin.sys.service;


import com.ladmin.common.vo.PageObject;
import com.ladmin.sys.entity.SysUserDel;

/**
*@author zhangtao
*说明:会员删除
*/



public interface SysUserDelService {
	//查询总删除会员的记录
	
	PageObject<SysUserDel>findObjects(String username,String startTime,String endTime,Integer pageCurrent);
	
}

