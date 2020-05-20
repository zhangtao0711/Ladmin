package com.ladmin.wuzile;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ladmin.common.vo.PageObject;
import com.ladmin.sys.dao.SysPermissionDao;
import com.ladmin.sys.dao.SysUserDao;
import com.ladmin.sys.entity.SysPermission;
import com.ladmin.sys.entity.SysUser;
import com.ladmin.sys.service.SysPermissionService;
import com.ladmin.sys.service.SysUserService;

@SpringBootTest
public class WuzileTest {
	@Autowired
	private SysPermissionDao permissionDao;
	@Autowired
	private SysPermissionService permissionService;
	@Autowired
	private SysUserDao dao;
	@Autowired
	private SysUserService daoService;
	@Test
	public void testone() {
		List<SysPermission> sysPermissions = permissionService.getPermissions();
//		List<SysPermission> sysPermissions = perissionDao.getSysPermissions();
		System.out.println(sysPermissions);
		System.out.println(sysPermissions.size());

	}
	@Test
	public void doTestUser() {
		List<SysUser>list=dao.findPageObjects("张三", 1, 2);
		PageObject<SysUser>page=daoService.findPageObjects("张三", 2);
		System.out.println(list);
		System.out.println(page);
	}
}
