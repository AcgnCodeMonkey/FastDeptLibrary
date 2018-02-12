package com.xujl.applibrary.mvp.model;

import android.support.annotation.Nullable;

import com.xujl.applibrary.mvp.common.CommonModelHelper;
import com.xujl.applibrary.mvp.port.ICommonModel;
import com.xujl.applibrary.mvp.port.IRequestType;
import com.xujl.baselibrary.mvp.model.BaseModel;
import com.xujl.datalibrary.network.InternetUtil;
import com.xujl.datalibrary.network.ResultEntity;
import com.xujl.datalibrary.network.port.NetworkPort;
import com.xujl.rxlibrary.BaseObservable;
import com.xujl.rxlibrary.BaseObservableEmitter;
import com.xujl.rxlibrary.BaseObserver;
import com.xujl.rxlibrary.RxHelper;
import com.xujl.rxlibrary.RxLife;
import com.xujl.utilslibrary.data.DataException;
import com.xujl.utilslibrary.data.ParamsMapTool;
import com.xujl.utilslibrary.port.RequestCallBack;
import com.xujl.utilslibrary.validator.VaUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xujl on 2017/7/4.
 */

public abstract class CommonModel extends BaseModel implements ICommonModel {
    protected NetworkPort mNetworkPort;


    @Override
    public CommonModelHelper getModelHelper () {
        if (!(super.getModelHelper() instanceof CommonModelHelper)) {
            setModelHelper(new CommonModelHelper());
        }
        return (CommonModelHelper) super.getModelHelper();
    }


    @Override
    public <T> T fromJson (String json, Class<T> classOfT) {
        return getModelHelper().fromJson(json, classOfT);
    }

    @Override
    public String toJson (Object src) {
        return getModelHelper().toJson(src);
    }

    @Override
    public void requestForGet (final IRequestType type, ParamsMapTool paramsMapTool, RxLife rxLife, BaseObserver<ResultEntity> observer) {
        if (mNetworkPort == null) {
            throw new NullPointerException("mNetworkPort未初始化");
        }
        final Map<String, Object> params = new HashMap<>();
        type.addParams(this,params, paramsMapTool);
        RxHelper.onCreate(rxLife)
                .createNormal(new BaseObservable<ResultEntity>() {
                    @Override
                    public void emitAction (final BaseObservableEmitter<ResultEntity> e) throws Exception {
                        mNetworkPort.requestForGet(params, "", new RequestCallBack() {
                            @Override
                            public void notice (String json) {
                                e.onNext(new ResultEntity(json));
                                e.onComplete();
                            }

                            @Override
                            public void error (@JsonICode int error, @Nullable String json) {
                                e.onNext(new ResultEntity(json, error));
                                e.onComplete();
                            }
                        }, type.getApiName());
                    }
                })
                .newThreadToMain()
                .run(observer);
    }

    @Override
    public void requestForPost (final IRequestType type, ParamsMapTool paramsMapTool, RxLife rxLife, BaseObserver<ResultEntity> observer) {
        if (mNetworkPort == null) {
            throw new NullPointerException("mNetworkPort未初始化");
        }
        final Map<String, Object> params = new HashMap<>();
        type.addParams(this,params, paramsMapTool);
        RxHelper.onCreate(rxLife)
                .createNormal(new BaseObservable<ResultEntity>() {
                    @Override
                    public void emitAction (final BaseObservableEmitter<ResultEntity> e) throws Exception {
                        mNetworkPort.requestForPost(params, "", new RequestCallBack() {
                            @Override
                            public void notice (String json) {
                                e.onNext(new ResultEntity(json));
                                e.onComplete();
                            }

                            @Override
                            public void error (@JsonICode int error, @Nullable String json) {
                                e.onNext(new ResultEntity(json, error));
                                e.onComplete();
                            }
                        }, type.getApiName());
                    }
                })
                .newThreadToMain()
                .run(observer);
    }


    protected void resetBaseUrl (String baseUrl) {
        mNetworkPort = new InternetUtil(baseUrl);
    }

    @Override
    public Object validatorData (Object obj, int... groups) throws DataException {
        new VaUtils().validatorAll(obj, groups);
        return obj;
    }

}
