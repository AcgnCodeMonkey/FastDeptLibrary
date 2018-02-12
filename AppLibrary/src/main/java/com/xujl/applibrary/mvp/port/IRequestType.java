package com.xujl.applibrary.mvp.port;

import com.xujl.utilslibrary.data.ParamsMapTool;

import java.util.Map;

/**
 * Created by xujl on 2018/2/11.
 */

public interface IRequestType {

    String getApiName ();

    void addParams (ICommonModel model, Map<String, Object> params, ParamsMapTool paramsMapTool);

    void requestSuccess (ICommonPresenter presenter, String json);

    void requestFailed (ICommonPresenter presenter, int errorCode, String errorMsg, String json);
}
