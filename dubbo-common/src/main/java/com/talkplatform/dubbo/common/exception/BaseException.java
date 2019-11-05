package com.talkplatform.dubbo.common.exception;

/**
 * @author: lizhen01
 * @date: 2019/11/4 17:17
 * @desc:
 */
public class BaseException extends Exception {

    private static final long serialVersionUID = 4547097125109674992L;

    private Integer code;
    private String message;

    public BaseException(){
        super();
    }

    public BaseException(Integer code,String message){
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
