package com.ladmin.common.vo.response;

import java.util.List;

import lombok.Data;
import lombok.ToString;

/**
 *@author 刘小刘
 * 分页查询返回公共类
 */
@Data
@ToString
public class QueryResult<T> {
	
	    //数据列表
		private List< T> list;
		//总记录数
		private long total;
}
