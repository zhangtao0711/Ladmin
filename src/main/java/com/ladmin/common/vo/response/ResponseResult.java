package com.ladmin.common.vo.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *@author 刘小刘 
 * 公共的页面响应消息
 */
@Data
@ToString
@NoArgsConstructor
public class ResponseResult {

	//操作是否成功
    boolean success = true;

    //操作代码
    int code = 10000;

    //提示信息
    String message;
    public ResponseResult(ResultCode resultCode){
        this.success = resultCode.success();
        this.code = resultCode.code();
        this.message = resultCode.message();
    }
    
    public static ResponseResult SUCCESS(){
        return new ResponseResult(CommonCode.SUCCESS);
    }
    public static ResponseResult FAIL(){
        return new ResponseResult(CommonCode.FAIL);
    }

}
