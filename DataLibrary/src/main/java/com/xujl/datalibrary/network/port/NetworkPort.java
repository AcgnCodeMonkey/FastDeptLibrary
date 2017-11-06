package com.xujl.datalibrary.network.port;


import com.xujl.utilslibrary.port.RequestCallBack;

import java.util.Map;

/**
 * Created by xujl on 2017/11/6.
 */

public interface NetworkPort {
    /**
     * 取消所有请求
     */
    void cancelAllRequest ();

    /**
     * 取消指定tag的请求
     */
     void cancelRequestForTag (String tag);
    /**
     * 添加一个请求tag
     * @param tag
     */
    void addRequestTag (String tag) ;

    /**
     * get请求
     * @param params
     * @param tag
     * @param requestCallBack
     * @param api
     */
    void requestForGet (Map<String, Object> params, String tag, final RequestCallBack requestCallBack, String api);
    /**
     * post请求
     * @param params
     * @param tag
     * @param requestCallBack
     * @param api
     */
    void requestForPost (Map<String, Object> params, String tag, final RequestCallBack requestCallBack, String api);
}
