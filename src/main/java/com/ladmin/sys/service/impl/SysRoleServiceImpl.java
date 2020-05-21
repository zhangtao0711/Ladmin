package com.ladmin.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.ladmin.common.vo.response.CommonCode;
import com.ladmin.common.vo.response.QueryResponseResult;
import com.ladmin.common.vo.response.QueryResult;
import com.ladmin.common.vo.response.ResponseResult;
import com.ladmin.sys.dao.SysRoleDao;
import com.ladmin.sys.dao.SysRolePermissionDao;
import com.ladmin.sys.entity.SysRole;
import com.ladmin.sys.entity.SysRoleExt;
import com.ladmin.sys.entity.SysRolePermission;
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
	@Autowired
	private SysRolePermissionDao sysRolePermissionDao;
	
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
        int startIndex=(page)*size;
        List<SysRole> list=sysRoleDao.findRoleList(startIndex,size,beginTime,endTime,name);
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
	public QueryResponseResult findRoleByRoleId(Integer roleId) {
		// TODO Auto-generated method stub
		SysRole sysRole = sysRoleDao.findRoleByRoleId(roleId);
		List<SysRolePermission> listRolePermission = sysRolePermissionDao.findByRoleId(roleId);
		SysRoleExt sysRoleExt=new SysRoleExt();
		sysRoleExt.setSysRole(sysRole);
		sysRoleExt.setListRolePermission(listRolePermission);
		 QueryResponseResult queryResponseResult=new QueryResponseResult(CommonCode.SUCCESS,sysRoleExt);
		return queryResponseResult;
	}

	@Override
	public ResponseResult deleteRoleById(Integer roleId) {
		// TODO Auto-generated method stub
		 sysRoleDao.deleteRoleById(roleId);
		 return new ResponseResult(CommonCode.SUCCESS);
	}

	@Override
	public ResponseResult deleteRoleByIds(Integer[] roleIds) {
		// TODO Auto-generated method stub
		 sysRoleDao.deleteRoleByIds(roleIds);
		 return new ResponseResult(CommonCode.SUCCESS);
	}

	@Override
	public ResponseResult insertRole(SysRole role,Integer... permissionIds) {
		// TODO Auto-generated method stub
		
		 sysRoleDao.insertRole(role);
		 if(permissionIds.length>0) {
			 for(Integer id : permissionIds) {
				 sysRolePermissionDao.insert(new SysRolePermission(role.getRoleId(),id));
			 }
		 }
		 
		 return new ResponseResult(CommonCode.SUCCESS);
	}

	@Override
	public ResponseResult updateRole(SysRole role,Integer... permissionIds) {
		// TODO Auto-generated method stub
		 sysRoleDao.updateRole(role);
		 if(permissionIds.length>0) {
			 sysRolePermissionDao.deleteByRoleId(role.getRoleId());
			 for(Integer id : permissionIds) {
				 sysRolePermissionDao.insert(new SysRolePermission(role.getRoleId(),id));
			 }
		 }
		 return new ResponseResult(CommonCode.SUCCESS);
	}

	@Override
	public QueryResponseResult checkRoleNameExist(String roleName) {
		// TODO Auto-generated method stub
		 int count = sysRoleDao.checkRoleNameExist(roleName);
		 return new QueryResponseResult(CommonCode.SUCCESS,count);
	}

	@Override
	public QueryResponseResult checkRoleKeyExist(String RoleKey) {
		// TODO Auto-generated method stub
		 int count = sysRoleDao.checkRoleKeyExist(RoleKey);
		 return new QueryResponseResult(CommonCode.SUCCESS,count);
	}


	@Override
	public ResponseResult updateStatusById(Integer roleId,String status) {
		// TODO Auto-generated method stub
		sysRoleDao.updateStatusById(roleId,status);
		 return new ResponseResult(CommonCode.SUCCESS);
	}





}
