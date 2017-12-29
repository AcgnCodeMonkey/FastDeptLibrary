package com.speed.projectx.basecore.mvp.model;

import android.support.annotation.Nullable;

import com.speed.projectx.basecore.mvp.model.port.IBaseCoreModel;
import com.speed.projectx.http.ApiName;
import com.speed.projectx.http.HttpRequest;
import com.xujl.applibrary.mvp.model.CommonModel;
import com.xujl.baselibrary.mvp.port.IBasePresenter;

import java.io.File;

/**
 * Created by xujl on 2017/11/8.
 */

public abstract class BaseCoreModel extends CommonModel implements IBaseCoreModel {
    @Override
    public void initModel (IBasePresenter presenter) {
        super.initModel(presenter);
        mNetworkPort = new HttpRequest(ApiName.BASE_URL);
    }

}
