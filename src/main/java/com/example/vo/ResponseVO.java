package com.example.vo;

import java.util.HashMap;

/**
 * @author Administrator
 * @date 2019/9/16 10:39
 */
public class ResponseVO extends HashMap<String,Object> {
    private Integer code;
    private String message;

    private ResponseVO(){
        put("code",0);
        put("message","操作成功");
    }

    public static ResponseVO ok(){
        return new ResponseVO();
    }

    public static ResponseVO error(){
        return error("1","操作失败");
    }

    public static ResponseVO error(String message){
        return error("500",message);
    }

    private static ResponseVO error(String code,String message){
        ResponseVO responseVO = new ResponseVO();
        responseVO.put("code",code);
        responseVO.put("message",message);
        return responseVO;
    }

    @Override
    public ResponseVO put(String key,Object value){
        super.put(key,value);
        return this;
    }
}
