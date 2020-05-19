package com.ladmin.sys.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ladmin.common.exception.ServiceException;
import com.ladmin.common.vo.PageObject;
import com.ladmin.sys.dao.SysUserDao;
import com.ladmin.sys.entity.SysUser;
import com.ladmin.sys.service.SysUserService;

/**
*@author zhangtao
*说明:会员删除模块具体业务
*/
@Service
public class SysUserServiceImpl implements SysUserService {
	@Autowired
	SysUserDao sysUserDao;
	
	@Override
	public PageObject<SysUser> findObjects(String username, String startTime,String endTime,Integer pageCurrent) {
		//参数校验		
		int rowCount=sysUserDao.getRowCount(username);
		if(rowCount==0)
			throw new ServiceException("没有查到数据");
		int pageSize=2;
		int startIndex=(pageCurrent-1)*pageSize;
		List<SysUser>records=sysUserDao.findObjects(username, startIndex, pageSize, startTime, endTime);
		return new PageObject<SysUser>(pageCurrent, rowCount, pageSize, records);
	}

}
