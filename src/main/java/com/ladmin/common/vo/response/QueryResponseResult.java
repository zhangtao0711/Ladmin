package com.ladmin.common.vo.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class QueryResponseResult extends ResponseResult {

	Object data;
	
	public QueryResponseResult(ResultCode resultCode,Object data) {
		super(resultCode);
		// TODO Auto-generated constructor stub
		this.data=data;
	}

}
