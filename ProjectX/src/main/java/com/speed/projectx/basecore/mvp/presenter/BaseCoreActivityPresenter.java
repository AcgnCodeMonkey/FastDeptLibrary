package com.speed.projectx.basecore.mvp.presenter;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;

import com.speed.projectx.R;
import com.speed.projectx.basecore.mvp.model.BaseCoreModel;
import com.speed.projectx.basecore.mvp.model.port.IBaseCoreModel;
import com.speed.projectx.basecore.mvp.view.BaseCoreView;
import com.speed.projectx.basecore.mvp.view.port.IBaseCoreView;
import com.xujl.applibrary.mvp.presenter.CommonActivityPresenter;
import com.xujl.baselibrary.mvp.port.IBaseModel;
import com.xujl.baselibrary.mvp.port.IBasePresenter;
import com.xujl.baselibrary.mvp.port.IBaseView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by xujl on 2017/11/8.
 */

public abstract class BaseCoreActivityPresenter<V extends IBaseCoreView, M extends IBaseCoreModel>
        extends CommonActivityPresenter<V, M> implements IBasePresenter {

    @Override
    protected String getModelClassPackageName () {
        return "com.speed.projectx.mvp.model";
    }

    @Override
    protected String getViewClassPackageName () {
        return "com.speed.projectx.mvp.view";
    }


    @Override
    protected String classNameToCreateView (String viewClassPackageName, String simpleName) {
        return viewClassPackageName + "." + simpleName.replace("Presenter", "View");
    }

    @Override
    protected IBaseView autoCreateView () {
        return new BaseCoreView() {

            @Override
            public int getLayoutId () {
                return BaseCoreActivityPresenter.this.getLayoutId();
            }

        };
    }

    @Override
    protected IBaseModel autoCreateModel () {
        return new BaseCoreModel() {
        };
    }

    @Override
    protected void onDestroy () {
        super.onDestroy();
    }


    @Override
    public void requestSuccess (int mode, String json) {
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

}
