package com.speed.projectx;

import android.content.Intent;
import android.os.Bundle;

import com.speed.projectx.basecore.mvp.presenter.BaseCoreActivityPresenter;
import com.speed.projectx.mvp.presenter.SplashActivityPresenter;
import com.xujl.baselibrary.mvp.port.Callback;
import com.xujl.rxlibrary.BaseObserver;
import com.xujl.rxlibrary.RxHelper;

public class MainActivity extends BaseCoreActivityPresenter {

    @Override
    protected void initPresenter (Bundle savedInstanceState) {
        subToMain(new Callback() {
            @Override
            public void callback () {

            }
        }, new Callback() {
            @Override
            public void callback () {
                startActivity(new Intent(exposeContext(), SplashActivityPresenter.class));
            }
        });
    }

    @Override
    public boolean isMVP () {
        return false;
    }

    @Override
    public int getLayoutId () {
        return R.layout.activity_main;
    }
}
