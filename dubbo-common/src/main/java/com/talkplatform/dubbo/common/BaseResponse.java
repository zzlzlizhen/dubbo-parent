package com.talkplatform.dubbo.common;

import cn.hutool.core.exceptions.ExceptionUtil;
import com.talkplatform.dubbo.common.exception.BaseException;

import java.io.Serializable;
import java.util.Collection;


/**
 * @author: lizhen01
 * @date: 2019/11/4 17:14
 * @desc:
 */
public class BaseResponse implements Serializable {

    private static final long serialVersionUID = 4288929684134206023L;

    private Integer code;
    private String message;
    private Object res;
    private Long timestamp;

    public static BaseResponse success(){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(200);
        baseResponse.setMessage("success");
        baseResponse.setTimestamp(System.currentTimeMillis());
        return baseResponse;
    }

    public static BaseResponse value(Object o){
        BaseResponse baseResponse = success();
        baseResponse.setRes(o);
        return baseResponse;
    }

    public static BaseResponse list(Collection<?> collection){
        BaseResponse baseResponse = success();
        baseResponse.setRes(collection);
        return baseResponse;
    }

    public static BaseResponse error(Throwable throwable){
        BaseResponse baseResponse = null;
        if(throwable instanceof BaseException){
            BaseException baseException = (BaseException)throwable;
            baseResponse = bussinessError(baseException);
        }else{
            baseResponse = sysError(throwable);
        }
        return baseResponse;
    }

    private static BaseResponse sysError(Throwable throwable){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(500);
        baseResponse.setMessage("system error");
        baseResponse.setMessage(ExceptionUtil.stacktraceToOneLineString(throwable));
        baseResponse.setTimestamp(System.currentTimeMillis());
        return baseResponse;
    }

    private static BaseResponse bussinessError(BaseException baseException){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(baseException.getCode());
        baseResponse.setMessage(baseException.getMessage());
        baseResponse.setTimestamp(System.currentTimeMillis());
        return baseResponse;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getRes() {
        return res;
    }

    public void setRes(Object res) {
        this.res = res;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
