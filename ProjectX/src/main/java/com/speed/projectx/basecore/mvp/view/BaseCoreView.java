package com.speed.projectx.basecore.mvp.view;

import com.speed.projectx.basecore.mvp.view.port.IBaseCoreView;
import com.speed.projectx.module.ToolBarModule;
import com.xujl.applibrary.mvp.view.CommonView;
import com.xujl.baselibrary.mvp.common.BaseToolBarModule;
import com.xujl.baselibrary.mvp.port.IBasePresenter;
import com.xujl.baselibrary.mvp.port.IBaseView;

/**
 * Created by xujl on 2017/11/8.
 */

public abstract class BaseCoreView extends CommonView implements IBaseCoreView {

    @Override
    public ToolBarModule getToolBarModule () {
        return (ToolBarModule) super.getToolBarModule();
    }

    @Override
    public BaseToolBarModule createToolBarModule (IBaseView view, IBasePresenter presenter, int layoutId) {
        return new ToolBarModule(presenter.exposeActivity(), layoutId, getViewHelper().getConfig());
    }

}
