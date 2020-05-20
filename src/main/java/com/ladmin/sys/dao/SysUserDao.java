package com.ladmin.sys.dao;

import java.nio.charset.Charset;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.ladmin.sys.entity.SysUser;

@Mapper
public interface SysUserDao {
//@Select("select count(*) from sys_user where user_name=#{username}")
//	int getRowCounts(@Param("username")String username);
	int getRowCounts(@Param("username")String username);
	int getRowNum(String name);
	List<SysUser> findPageObjects(String username,
			Integer startIndex,Integer pageSize);
	int insertObject(SysUser entity) ;
	int updateObject(SysUser entity);
	int updatePassword(@Param("password")Charset user_pwd,
			            @Param("salt")String salt,
			            @Param("id")Integer id);
}
