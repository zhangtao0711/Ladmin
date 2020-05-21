package com.ladmin.sys.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ladmin.sys.entity.SysUserList;
import com.ladmin.sys.vo.SysUserListVo;

@Mapper
public interface SysUserListDao {
	/*总记录数*/
	int getRowCount(String username);
	/*基于条件进行分页查询*/
	List<SysUserList> findPageObjects(String username,
			Integer startIndex,Integer pageSize); 
	
	@Select("select id,username,phone,email,list_role listRole,list_time listTime from sys_adminlist")
	List<SysUserList> findPageObjects();
}
