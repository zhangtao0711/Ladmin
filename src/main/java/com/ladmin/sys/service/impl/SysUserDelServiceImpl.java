package com.ladmin.sys.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ladmin.common.exception.ServiceException;
import com.ladmin.common.vo.PageObject;
import com.ladmin.sys.dao.SysUserDelDao;
import com.ladmin.sys.entity.SysUserDel;
import com.ladmin.sys.service.SysUserDelService;

/**
*@author zhangtao
*说明:会员删除模块具体业务
*/
@Service
public class SysUserDelServiceImpl implements SysUserDelService {
	@Autowired
	SysUserDelDao sysUserDao;
	
	@Override
	public PageObject<SysUserDel> findObjects(String username, String startTime,String endTime,Integer pageCurrent) {
		//参数校验		
		int rowCount=sysUserDao.getRowCount(username);
		if(rowCount==0)
			throw new ServiceException("没有查到数据");
		int pageSize=2;
		int startIndex=(pageCurrent-1)*pageSize;
		List<SysUserDel>records=sysUserDao.findObjects(username, startIndex, pageSize, startTime, endTime);
		return new PageObject<SysUserDel>(pageCurrent, rowCount, pageSize, records);
	}

}
