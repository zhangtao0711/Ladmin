package com.ladmin.wuzile;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ladmin.sys.dao.SysPermissionDao;
import com.ladmin.sys.entity.SysPermission;
import com.ladmin.sys.service.SysPermissionService;

@SpringBootTest
public class WuzileTest {
	@Autowired
	private SysPermissionDao permissionDao;
	@Autowired
	private SysPermissionService permissionService;

	@Test
	public void testone() {
		List<SysPermission> sysPermissions = permissionService.getPermissions();
//		List<SysPermission> sysPermissions = perissionDao.getSysPermissions();
		System.out.println(sysPermissions);
		System.out.println(sysPermissions.size());

	}
}
