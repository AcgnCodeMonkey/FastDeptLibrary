package com.speed.projectx.mvp.model;


import com.speed.projectx.basecore.mvp.model.BaseCoreModel;
import com.speed.projectx.http.ApiName;
import com.speed.projectx.mvp.model.port.ISplashActivityModel;
import com.xujl.utilslibrary.data.ParamsMapTool;

import java.util.Map;

/**
 *
 */
public class SplashActivityModel extends BaseCoreModel implements ISplashActivityModel {
    @Override
    protected void addParams (int mode, Map<String, Object> params, ParamsMapTool paramsMapTool) {
        super.addParams(mode, params, paramsMapTool);
    }

    @Override
    protected String getApiName (int mode) {
        switch (mode) {
            case SPLISH_IMAGE:
                resetBaseUrl(ApiName.SPLASH_URL);
                return ApiName.SPLASH_API;
            default:
                return ApiName.BASE_URL;

        }

    }

}

