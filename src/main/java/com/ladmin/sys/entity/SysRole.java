package com.ladmin.sys.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;


/**
 * @author 刘小刘
 * 
 */
@Data
public class SysRole  implements Serializable{

	private static final long serialVersionUID = 491705610265331943L;

	/**角色ID*/
	private Long roleId;
	/**角色名称*/
	private String roleName;
	/**角色权限字符串*/
	private String roleKey;
	/**排序*/
	private Integer roleSort;
	/**数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）、、*/
	private String dataScope;
	/**角色状态【 1 正常 0停用】*/
	private String status;
	/**删除标识 1删除 0存在*/
	private String delFlag;
	/**创建人*/
	private String createBy;
	 /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date  createTime;
	private String updateBy;
	 /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime;
    /**备注*/
	private String remark;
	
}
