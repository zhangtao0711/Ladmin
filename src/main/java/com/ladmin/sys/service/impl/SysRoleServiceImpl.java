package com.ladmin.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.ladmin.common.vo.response.CommonCode;
import com.ladmin.common.vo.response.QueryResponseResult;
import com.ladmin.common.vo.response.QueryResult;
import com.ladmin.sys.dao.SysRoleDao;
import com.ladmin.sys.entity.SysRole;
import com.ladmin.sys.service.SysRoleService;

/**
 * 
 *@author 刘小刘
 *角色业务层实现类
 *
 */
@Service
public class SysRoleServiceImpl  implements SysRoleService{

	@Autowired
	private SysRoleDao sysRoleDao;
	
	@Override
	public QueryResponseResult findRoleList(int page, int size, String beginTime, String endTime, String name) {

        if (page <= 0) {
            page = 1;
        }
        page = page - 1;
        if (size <= 0) {
            size = 10;
        }
        if(StringUtils.isEmpty(beginTime)) {
        	beginTime=null;
        }
        if(StringUtils.isEmpty(endTime)) {
        	endTime=null;
        }
        if(StringUtils.isEmpty(name)) {
        	name=null;
        }
    
		//查询总记录数
        int total = sysRoleDao.findRoleListCount(beginTime,endTime,name);
        int startIndex=(page-1)*size;
        List<SysRole> list=sysRoleDao.findRoleList(page,size,beginTime,endTime,name);
        QueryResult queryResult=new QueryResult();
        queryResult.setList(list);
        queryResult.setTotal(total);
        QueryResponseResult queryResponseResult=new QueryResponseResult(CommonCode.SUCCESS,queryResult);
       
		return queryResponseResult;
	}
	
	
	

	@Override
	public QueryResponseResult findRoleListByUserId(String userId) {
		
		 List<SysRole> list = sysRoleDao.findRoleListByUserId(userId);
		 QueryResponseResult queryResponseResult=new QueryResponseResult(CommonCode.SUCCESS,list);
		 return queryResponseResult;
	}

	@Override
	public QueryResponseResult findRoleByRoleId(Long roleId) {
		// TODO Auto-generated method stub
		SysRole sysRole = sysRoleDao.findRoleByRoleId(roleId);
		 QueryResponseResult queryResponseResult=new QueryResponseResult(CommonCode.SUCCESS,sysRole);
		return queryResponseResult;
	}

	@Override
	public int deleteRoleById(Long roleId) {
		// TODO Auto-generated method stub
		return sysRoleDao.deleteRoleById(roleId);
	}

	@Override
	public int deleteRoleByIds(Long[] roleIds) {
		// TODO Auto-generated method stub
		return sysRoleDao.deleteRoleByIds(roleIds);
	}

	@Override
	public int insertRole(SysRole role) {
		// TODO Auto-generated method stub
		return sysRoleDao.insertRole(role);
	}

	@Override
	public int updateRole(SysRole role) {
		// TODO Auto-generated method stub
		return sysRoleDao.updateRole(role);
	}

	@Override
	public int checkRoleNameExist(String roleName) {
		// TODO Auto-generated method stub
		return sysRoleDao.checkRoleNameExist(roleName);
	}

	@Override
	public int checkRoleKeyExist(String RoleKey) {
		// TODO Auto-generated method stub
		return sysRoleDao.checkRoleKeyExist(RoleKey);
	}





}
