package com.speed.projectx.basecore.mvp.view;

import android.support.v7.widget.RecyclerView;

import com.speed.projectx.R;
import com.speed.projectx.basecore.mvp.common.RefreshRecyclerViewHelper;
import com.speed.projectx.basecore.mvp.view.port.IBaseRefreshListView;
import com.xujl.baselibrary.mvp.port.HelperType;
import com.xujl.baselibrary.mvp.port.IBasePresenter;
import com.xujl.utilslibrary.system.ResUtil;
import com.xujl.widgetlibrary.widget.RefreshLayout;

/**
 * Created by xujl on 2017/12/4.
 */

public abstract class BaseRefreshListView extends BaseCoreView implements IBaseRefreshListView {
    @Override
    public void initView (IBasePresenter presenter) {
        super.initView(presenter);
        getViewHelper().addHelper(HelperType.TYPE_ONE, new RefreshRecyclerViewHelper(mRootView, refreshLayoutId(), recyclerViewId()));
        getRefreshRvHelper().initRefreshLayout();
        //判断是否自定义recyclerView配置，没有自定义则用默认配置
        if (!customInitRecyclerView()) {
            getRefreshRvHelper().initRecyclerViewDivider(presenter.exposeContext(), getRecyclerViewDividerSize(), getRecyclerViewDividerColor())
                    .setLinearLayoutManager()
                    .enableLoading(false)
                    .setOnRefreshListener((RefreshLayout.RefreshListener) presenter)
                    .enableRefresh(true);
        }
    }

    public boolean customInitRecyclerView () {
        return false;
    }

    public abstract int refreshLayoutId ();

    public abstract int recyclerViewId ();

    @Override
    public RefreshRecyclerViewHelper getRefreshRvHelper () {
        return getViewHelper().getHelper(HelperType.TYPE_ONE);
    }

    @Override
    public void showListViewItem (int position) {
        getRefreshRvHelper().getRecyclerView().scrollToPosition(position);
    }

    @Override
    public void setAdapter (RecyclerView.Adapter adapter) {
        getRefreshRvHelper().setAdapter(adapter);
    }

    @Override
    public int getRecyclerViewDividerSize () {
        return 1;
    }

    @Override
    public int getRecyclerViewDividerColor () {
        return ResUtil.getColor(R.color.colorPrimary);
    }

    //====================刷新布局方法===============================================================================
    @Override
    public void startRefresh () {
        getRefreshRvHelper().startRefresh();
    }

    @Override
    public void startLoadMore () {
        getRefreshRvHelper().startLoadMore();
    }

    @Override
    public void enableRefresh (boolean enable) {
        getRefreshRvHelper().enableRefresh(enable);
    }

    @Override
    public void enableLoad (boolean enable) {
        getRefreshRvHelper().enableLoading(enable);
    }

    @Override
    public void refreshLoadingComplete () {
        getRefreshRvHelper().refreshLoadingComplete();
    }

}
