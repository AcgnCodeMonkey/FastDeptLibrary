package com.speed.projectx.basecore.mvp.view.port;

import android.support.v7.widget.RecyclerView;

import com.speed.projectx.basecore.mvp.common.RefreshRecyclerViewHelper;


/**
 * Created by xujl on 2017/12/4.
 */

public interface IBaseRefreshListView extends IBaseCoreView {

    RefreshRecyclerViewHelper getRefreshRvHelper ();
    void showListViewItem (int position);// 显示list指定下标item

    void setAdapter (RecyclerView.Adapter adapter);// 设置适配器

    int getRecyclerViewDividerSize ();

    int getRecyclerViewDividerColor ();

    void startRefresh ();//开始刷新

    void enableRefresh (boolean enable);

    void enableLoad (boolean enable);

    void startLoadMore ();//开始加载

    void refreshLoadingComplete ();
}
