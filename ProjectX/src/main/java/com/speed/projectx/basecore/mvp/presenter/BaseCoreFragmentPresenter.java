package com.speed.projectx.basecore.mvp.presenter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.speed.projectx.basecore.mvp.model.BaseCoreModel;
import com.speed.projectx.basecore.mvp.model.port.IBaseCoreModel;
import com.speed.projectx.basecore.mvp.view.BaseCoreView;
import com.speed.projectx.basecore.mvp.view.port.IBaseCoreView;
import com.xujl.applibrary.mvp.presenter.CommonFragmentPresenter;
import com.xujl.baselibrary.mvp.port.IBaseModel;
import com.xujl.baselibrary.mvp.port.IBasePresenter;
import com.xujl.baselibrary.mvp.port.IBaseView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by xujl on 2017/11/9.
 */

public abstract class BaseCoreFragmentPresenter<V extends IBaseCoreView, M extends IBaseCoreModel>
        extends CommonFragmentPresenter<V, M> implements IBasePresenter {

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
                return BaseCoreFragmentPresenter.this.getLayoutId();
            }

        };
    }

    @Override
    protected IBaseModel autoCreateModel () {
        return new BaseCoreModel() {
        };
    }

    @Override
    public void onDestroy () {
        super.onDestroy();
    }

}
