package com.speed.projectx.module;

import android.app.Activity;

import com.speed.projectx.R;
import com.xujl.baselibrary.mvp.common.LayoutConfig;
import com.xujl.baselibrary.mvp.port.IBasePresenter;
import com.xujl.baselibrary.mvp.presenter.BaseActivityPresenter;

/**
 * Created by xujl on 2017/11/17.
 */

public class ToolBarModule extends com.xujl.applibrary.mvp.common.ToolBarModule {
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
    }

    @Override
    public void showBackBtn (boolean isShow) {
        super.showBackBtn(isShow);
//        getToolbar().setNavigationIcon(R.drawable.ic_back);
    }
}
