package com.ladmin.sys.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.ladmin.sys.entity.SysUserDel;

/**
 * 会员管理:会员删除,会员恢复
 * zt
 * */

@Mapper
public interface SysUserDelDao {
	/**
	 * 根据分页信息查询
	 * */
	List<SysUserDel>findObjects(String username,Integer startIndex,Integer pageSize,String startTime,String endTime);
	//查询总记录
	int getRowCount(String username);
}
