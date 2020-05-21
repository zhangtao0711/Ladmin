package com.ladmin.sys.service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ladmin.sys.dao.SysUserListDao;
import com.ladmin.sys.entity.SysUserList;
import com.ladmin.sys.service.SysUserListService;
import com.ladmin.sys.vo.SysUserListVo;

@Service
public class SysUserListServiceImpl implements SysUserListService {

	@Autowired
	private SysUserListDao sysUserListDao;

	@Override
	public List<SysUserList> findObjects() {
		List<SysUserList> list = sysUserListDao.findPageObjects();
		System.out.println("lsit="+list);
		return list;
	}



	
}
