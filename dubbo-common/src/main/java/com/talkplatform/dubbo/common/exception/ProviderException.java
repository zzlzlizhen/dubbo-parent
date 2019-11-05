package com.talkplatform.dubbo.common.exception;

/**
 * @author: lizhen01
 * @date: 2019/11/4 19:11
 * @desc:
 */
public class ProviderException extends BaseException {

    public ProviderException(Integer code,String message){
        super(code,message);
    }
}
