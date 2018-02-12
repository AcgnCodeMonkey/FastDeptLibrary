package com.xujl.applibrary.mvp.presenter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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
import com.xujl.baselibrary.mvp.presenter.BaseFragmentPresenter;
import com.xujl.rxlibrary.RxLife;
import com.xujl.utilslibrary.data.ParamsMapTool;

/**
 * Created by xujl on 2017/7/4.
 */

public abstract class CommonFragmentPresenter<V extends ICommonView, M extends ICommonModel>
        extends BaseFragmentPresenter<V, M> implements ICommonPresenter {
    @Override
    public void exit () {
        getPresenterHelper().exit(exposeActivity());
    }

    @Override
    public <S extends Activity> void gotoActivity (Class<S> cls, Bundle bundle) {
        getPresenterHelper().gotoActivity(exposeActivity(), cls, bundle);
    }

    @Override
    public <S extends Activity> void gotoActivity (Class<S> cls, Bundle bundle, int requestCode) {
        getPresenterHelper().gotoActivity(exposeActivity(), cls, bundle, requestCode);
    }

    @Override
    public <S extends Activity> void gotoActivity (Class<S> cls) {
        getPresenterHelper().gotoActivity(exposeActivity(), cls);
    }

    @Override
    public <S extends Activity> void gotoActivity (Class<S> cls, int requestCode) {
        getPresenterHelper().gotoActivity(exposeActivity(), cls, requestCode);
    }

    @Override
    public void gotoActivity (Intent intent, int requestCode) {
        getPresenterHelper().gotoActivity(exposeActivity(), intent, requestCode);
    }

    @Override
    public void gotoActivity (Intent intent) {
        getPresenterHelper().gotoActivity(exposeActivity(), intent);
    }

    @Override
    public void backForResult (Bundle bundle, int result) {
        getPresenterHelper().backForResult(exposeActivity(), bundle, result);
    }

    @Override
    public void backForResult (int result) {
        getPresenterHelper().backForResult(exposeActivity(), result);
    }

    @Override
    public void backForResult (Intent intent, int result) {
        getPresenterHelper().backForResult(exposeActivity(), intent, result);
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
                return CommonFragmentPresenter.this.getLayoutId();
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

    /**
     * 完全自定义请求
     * @param type
     * @param setting
     */
    protected void request (IRequestType type, Setting setting) {
        getPresenterHelper().request(type, setting, mModel, mView, this);
    }

    //</editor-fold>

    /**
     * 当前页面跳转同级页面
     *
     * @param fragmentPresenter
     */
    public void startFragmentBrother (BaseFragmentPresenter fragmentPresenter) {
        startRecycle(this, fragmentPresenter);
    }

    /**
     * 循环判断
     *
     * @param nowFragment
     * @param fragmentPresenter
     */
    private void startRecycle (BaseFragmentPresenter nowFragment, BaseFragmentPresenter fragmentPresenter) {
        BaseFragmentPresenter parentFragment = (BaseFragmentPresenter) nowFragment.getParentFragment();
        if (parentFragment != null && parentFragment != nowFragment) {
            startRecycle(parentFragment, fragmentPresenter);
            return;
        }
        nowFragment.start(fragmentPresenter);
    }

    @Override
    public void onDestroy () {
        super.onDestroy();
    }

    @Override
    public RxLife getRxLife () {
        return mRxLife;
    }
}
