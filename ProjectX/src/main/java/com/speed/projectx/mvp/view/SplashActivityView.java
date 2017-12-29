package com.speed.projectx.mvp.view;

import android.view.View;
import android.widget.ImageView;

import com.speed.projectx.R;
import com.speed.projectx.basecore.mvp.view.BaseCoreView;
import com.speed.projectx.mvp.view.port.ISplashActivityView;
import com.speed.projectx.widget.WowView;
import com.xujl.baselibrary.mvp.port.IBasePresenter;

/**
 *
 */
public class SplashActivityView extends BaseCoreView implements ISplashActivityView {
    private WowView mWowView;
    private ImageView mImageView;

    @Override
    public void initView (IBasePresenter presenter) {
        super.initView(presenter);
        mImageView = findView(R.id.iv);
        mWowView = findView(R.id.wow_view);
        mWowView.setCallback((WowView.Callback) presenter);
    }

    @Override
    public int getLayoutId () {
        return R.layout.activity_splash;
    }

    @Override
    public void start () {
        mWowView.setVisibility(View.VISIBLE);
        mImageView.setDrawingCacheEnabled(true);
        mWowView.startAnimate(mImageView.getDrawingCache());
    }

    @Override
    public void hideImageView () {
        mImageView.setVisibility(View.GONE);
    }

    @Override
    public void clearImage () {
        mImageView.setDrawingCacheEnabled(false);
    }
}

