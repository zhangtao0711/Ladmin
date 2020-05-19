package com.ladmin.common.vo;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 控制层值对象
 * 
 * @author Administrator
 *
 */
@Data
@NoArgsConstructor // lombok生成无参构造函数
public class JsonResult implements Serializable {
	private static final long serialVersionUID = -71106164039928180L;
	/** 状态码对应消息 */
	private String message = "ok";
	/** 状态码:用于表示服务端要返回给客户端的数据是正常还是异常数据 */
	private int state = 1;// 1默认标识ok,0标识error
	
	/** 通过此属性存储业务层的正常数据，尤其是查询 */
	private Object data;

	public JsonResult(String message) {
		this.message = message;
	}

	public JsonResult(Object data) {
		this.data = data;
	}

	public JsonResult(Throwable e) {
		this.state = 0;
		this.message = e.getMessage();
	}
}
