package com.ladmin.sys.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.ladmin.sys.entity.SysUser;

/**
 * 会员管理:会员删除,会员恢复
 * zt
 * */

@Mapper
public interface SysUserDao {
	/**
	 * 根据分页信息查询
	 * */
	List<SysUser>findObjects(String username,Integer startIndex,Integer pageSize,String startTime,String endTime);
	//查询总记录
	int getRowCount(String username);
}
