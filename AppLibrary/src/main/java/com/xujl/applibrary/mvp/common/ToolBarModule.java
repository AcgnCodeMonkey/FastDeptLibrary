package com.xujl.applibrary.mvp.common;

import android.app.Activity;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.xujl.applibrary.R;
import com.xujl.baselibrary.mvp.common.BaseToolBarModule;
import com.xujl.baselibrary.mvp.common.LayoutConfig;
import com.xujl.baselibrary.mvp.port.IBasePresenter;

/**
 * Created by xujl on 2017/7/4.
 */

public class ToolBarModule extends BaseToolBarModule {
    protected TextView mTitleTV;
    protected ImageButton mLeftIB;
    protected ImageButton mRightIB;
    protected IBasePresenter mPresenter;

    /**
     * 使用此构造器会根据子类返回的toolBar的布局id自动创建toolBar并和内容布局拼接
     * 到一起
     *
     * @param activity
     * @param layoutId activity布局id
     * @param config
     */
    public ToolBarModule (Activity activity, int layoutId, LayoutConfig config) {
        super(activity, layoutId, config);
    }


    @Override
    public void initSetting (IBasePresenter presenter) {
        super.initSetting(presenter);
        mTitleTV = (TextView) getToolbar().findViewById(R.id.toolbar_layout_titleTV);
        mLeftIB = (ImageButton) getToolbar().findViewById(R.id.toolbar_layout_leftImageBtn);
        mRightIB = (ImageButton) getToolbar().findViewById(R.id.toolbar_layout_rightImageBtn);
        mPresenter = presenter;
        final ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
        }
        getToolbar().setTitle("");
    }

    public void showBackBtn (boolean isShow) {
        final ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(isShow);
        }
        if (!isShow) {
            return;
        }
        getToolbar().setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                mPresenter.back();
            }
        });
    }

    @Override
    protected int getToolBarId () {
        return R.id.toolbar;
    }

    @Override
    protected int getToolBarLayoutId () {
        return R.layout.toolbar_layout;
    }

    public ImageButton getLeftIB () {
        return mLeftIB;
    }

    public ImageButton getRightIB () {
        return mRightIB;
    }

    public void setTitle (String title) {
        mTitleTV.setText(title);
    }

}
