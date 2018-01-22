package com.xujl.applibrary.mvp.port;

/**
 * Created by xujl on 2018/1/22.
 */

public interface IRequest {
    void requestSuccess(int mode,String json);
    void requestFailed(int mode,int errorCode,String errorMsg,String json);
}
