package com.speed.projectx;

import android.content.Intent;
import android.os.Bundle;

import com.speed.projectx.basecore.mvp.presenter.BaseCoreActivityPresenter;
import com.speed.projectx.mvp.presenter.SplashActivityPresenter;

public class MainActivity extends BaseCoreActivityPresenter {

    @Override
    protected void initPresenter (Bundle savedInstanceState) {
        startActivity(new Intent(this, SplashActivityPresenter.class));
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
