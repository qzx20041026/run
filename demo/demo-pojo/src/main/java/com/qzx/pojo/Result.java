package com.qzx.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private Integer code;//编码
    private String msg;//错误信息
    private Object data;//数据


    public static Result success(){
        Result result=new Result();
        result.code=1;
        result.msg="success";
        return result;
    }
    public static Result success(Object data){
        Result result=new Result();
        result.code=1;
        result.msg="success";
        result.data=data;
        return result;
    }
    public static Result error(String message) {
        Result result=new Result();
        result.code=0;
        result.msg=message;
        return result;
    }
}
