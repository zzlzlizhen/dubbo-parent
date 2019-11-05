package com.talkplatform.dubbo.common;

import cn.hutool.json.JSONUtil;

import java.util.Collection;

/**
 * @author: lizhen01
 * @date: 2019/11/4 17:13
 * @desc:
 */
public class BaseController {

    public String value(Object o){
        return JSONUtil.toJsonStr(BaseResponse.value(o));
    }

    public String success(){
        return JSONUtil.toJsonStr(BaseResponse.success());
    }

    public String error(Throwable throwable){
        return JSONUtil.toJsonStr(BaseResponse.error(throwable));
    }

    public String list(Collection<?> collection){
        return JSONUtil.toJsonStr(BaseResponse.list(collection));
    }
}
