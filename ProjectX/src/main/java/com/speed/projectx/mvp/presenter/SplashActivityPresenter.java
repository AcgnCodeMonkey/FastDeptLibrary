package com.speed.projectx.mvp.presenter;


import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import com.speed.projectx.basecore.mvp.presenter.BaseCoreActivityPresenter;
import com.speed.projectx.mvp.model.port.ISplashActivityModel;
import com.speed.projectx.mvp.view.port.ISplashActivityView;
import com.speed.projectx.widget.WowView;
import com.xujl.rxlibrary.BaseObserver;
import com.xujl.rxlibrary.RxHelper;


/**
 *
 */

public class SplashActivityPresenter extends BaseCoreActivityPresenter<ISplashActivityView, ISplashActivityModel>
        implements WowView.Callback {

    @Override
    protected void initPresenter (Bundle savedInstanceState) {
        RxHelper.onCreate(mRxLife)
                .createDelay(1000)
                .newThreadToMain()
                .run(new BaseObserver<Object>() {
                    @Override
                    public void onNext (Object o) {
                        super.onNext(o);
                        mView.hideImageView();
                        mView.start();
                    }
                });
    }

    @Override
    public void requestSuccess (int mode, String json) {
        super.requestSuccess(mode, json);

    }

    @Override
    protected void onDestroy () {
        mView.clearImage();
        super.onDestroy();
    }

    @Override
    public boolean enableUseLoadingLayout () {
        return false;
    }

    @Override
    public void complete () {
        exit();
    }

    @Override
    public void finish () {
        super.finish();
        overridePendingTransition(0,0);
    }
}

