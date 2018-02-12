package com.xujl.applibrary.mvp.presenter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;

import com.xujl.applibrary.mvp.common.CommonPresenterHelper;
import com.xujl.applibrary.mvp.common.Setting;
import com.xujl.applibrary.mvp.model.CommonModel;
import com.xujl.applibrary.mvp.port.ICommonModel;
import com.xujl.applibrary.mvp.port.ICommonPresenter;
import com.xujl.applibrary.mvp.port.ICommonView;
import com.xujl.applibrary.mvp.port.IRequestType;
import com.xujl.applibrary.mvp.view.CommonView;
import com.xujl.baselibrary.mvp.port.IBaseModel;
import com.xujl.baselibrary.mvp.port.IBaseView;
import com.xujl.baselibrary.mvp.presenter.BaseActivityPresenter;
import com.xujl.rxlibrary.RxLife;
import com.xujl.utilslibrary.data.ParamsMapTool;

/**
 * Created by xujl on 2017/7/4.
 */

public abstract class CommonActivityPresenter<V extends ICommonView, M extends ICommonModel>
        extends BaseActivityPresenter<V, M> implements ICommonPresenter {



    @Override
    public <S extends Activity> void gotoActivity (Class<S> cls, Bundle bundle) {
        getPresenterHelper().gotoActivity(this, cls, bundle);
    }

    @Override
    public <S extends Activity> void gotoActivity (Class<S> cls, Bundle bundle, int requestCode) {
        getPresenterHelper().gotoActivity(this, cls, bundle, requestCode);
    }

    @Override
    public void gotoActivity (Intent intent, int requestCode) {
        getPresenterHelper().gotoActivity(this, intent, requestCode);
    }

    @Override
    public void gotoActivity (Intent intent) {
        getPresenterHelper().gotoActivity(this, intent);
    }

    @Override
    public <S extends Activity> void gotoActivity (Class<S> cls) {
        getPresenterHelper().gotoActivity(this, cls);
    }

    @Override
    public <S extends Activity> void gotoActivity (Class<S> cls, int requestCode) {
        getPresenterHelper().gotoActivity(this, cls, requestCode);
    }

    @Override
    public void backForResult (Bundle bundle, int result) {
        getPresenterHelper().backForResult(this, bundle, result);
    }

    @Override
    public void backForResult (Intent intent, int result) {
        getPresenterHelper().backForResult(this, intent, result);
    }

    @Override
    public void backForResult (int result) {
        getPresenterHelper().backForResult(this, result);
    }

    @Override
    public void exit () {
        getPresenterHelper().exit(this);
    }

    @Override
    protected CommonPresenterHelper getPresenterHelper () {
        if (!(super.getPresenterHelper() instanceof CommonPresenterHelper)) {
            setPresenterHelper(new CommonPresenterHelper());
        }
        return (CommonPresenterHelper) super.getPresenterHelper();
    }


    @Override
    protected IBaseView autoCreateView () {
        return new CommonView() {

            @Override
            public int getLayoutId () {
                return CommonActivityPresenter.this.getLayoutId();
            }

        };
    }

    @Override
    protected IBaseModel autoCreateModel () {
        return new CommonModel() {
        };
    }


    /**
     * 关闭MVP模式时应复写此方法
     *
     * @return
     */
    @Override
    public int getLayoutId () {
        return 0;
    }

    @Override
    public void onClick (View v) {
        final int id = v.getId();
        onClick(v, id);
    }

    public void onClick (View v, int id) {

    }
    //<editor-fold desc="网络请求">

    protected void requestForGet (IRequestType type) {
        requestForGet(type, null);
    }

    protected void requestForGet (IRequestType type, ParamsMapTool paramsMapTool) {
        getPresenterHelper().requestForGet(type, paramsMapTool, true, mModel, mView, this);
    }

    protected void requestForGetNoHint (IRequestType type) {
        requestForGetNoHint(type, null);
    }

    protected void requestForGetNoHint (IRequestType type, ParamsMapTool paramsMapTool) {
        getPresenterHelper().requestForGet(type, paramsMapTool, false, mModel, mView, this);
    }

    protected void requestForPost (IRequestType type) {
        requestForPost(type, null);
    }

    protected void requestForPost (IRequestType type, ParamsMapTool paramsMapTool) {
        getPresenterHelper().requestForPost(type, paramsMapTool, true, mModel, mView, this);
    }

    protected void requestForPostNoHint (IRequestType type) {
        requestForPostNoHint(type, null);
    }

    protected void requestForPostNoHint (IRequestType type, ParamsMapTool paramsMapTool) {
        getPresenterHelper().requestForPost(type, paramsMapTool, false, mModel, mView, this);
    }
    protected void request(IRequestType type,Setting setting){
        getPresenterHelper().request(type,setting,mModel, mView, this);
    }
    //</editor-fold>

    @Override
    protected void onDestroy () {
        super.onDestroy();
    }

    @Override
    public RxLife getRxLife () {
        return mRxLife;
    }
}
