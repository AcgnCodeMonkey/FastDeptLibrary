package com.speed.projectx.basecore.mvp.common;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.speed.projectx.R;
import com.xujl.baselibrary.mvp.common.BaseHelper;
import com.xujl.utilslibrary.system.Log;
import com.xujl.utilslibrary.system.ResUtil;
import com.xujl.widgetlibrary.util.RecycleViewDivider;
import com.xujl.widgetlibrary.widget.RefreshLayout;


/**
 * Created by xujl on 2017/6/14.
 */

public class RefreshRecyclerViewHelper extends BaseHelper {
    private RefreshLayout mRefreshLayout;
    private RecyclerView mRecyclerView;

    public RefreshRecyclerViewHelper (View view, int layoutId, int recyclerViewId) {
        mRefreshLayout = (RefreshLayout) view.findViewById(layoutId);
        mRecyclerView = (RecyclerView) view.findViewById(recyclerViewId);
    }


    public RefreshRecyclerViewHelper setGridLayoutManager (int count) {
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(mRecyclerView.getContext(), count);
        layoutManager.setAutoMeasureEnabled(true);
        mRecyclerView.setLayoutManager(layoutManager);
        return this;
    }

    public RefreshRecyclerViewHelper setLinearLayoutManager () {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(mRecyclerView.getContext());
        layoutManager.setAutoMeasureEnabled(true);
        mRecyclerView.setLayoutManager(layoutManager);
        return this;
    }

    public RefreshRecyclerViewHelper setAdapter (RecyclerView.Adapter adapter) {
        mRecyclerView.setAdapter(adapter);
        return this;
    }

    public RefreshRecyclerViewHelper addOnItemTouchListener (RecyclerView.OnItemTouchListener listener) {
        mRecyclerView.addOnItemTouchListener(listener);
        return this;
    }

    public RefreshLayout getRefreshLayout () {
        return mRefreshLayout;
    }

    public RecyclerView getRecyclerView () {
        return mRecyclerView;
    }

    public RefreshRecyclerViewHelper initRecyclerViewDivider (Context context, int dividerHeight, int dividerColor) {
        if (mRecyclerView == null) {
            Log.e("RefreshStyleViewHelper->", "RecyclerView引用为空");
            return this;
        }
        // 设置分割线
        RecycleViewDivider dividerGridItemDecoration = new RecycleViewDivider(context,
                LinearLayoutManager.HORIZONTAL, dividerHeight, dividerColor);
        mRecyclerView.addItemDecoration(dividerGridItemDecoration);
        return this;
    }

    //====================刷新布局方法===============================================================================

    /**
     * 默认不使用上拉加载
     */
    public RefreshRecyclerViewHelper initRefreshLayout () {
        if (mRefreshLayout == null) {
            Log.e("RefreshStyleViewHelper->", "RefreshLayout引用为空");
            return this;
        }
        final Context context = mRefreshLayout.getContext();
        final int themeColor = ResUtil.getColor(R.color.colorPrimary);
//        ProgressLayout headerView = new ProgressLayout(context);
//        headerView.setColorSchemeColors(themeColor);
//        mRefreshLayout.setHeaderView(headerView);//设置加载样式
//        final BallPulseView bottomView = new BallPulseView(context);
//        bottomView.setAnimatingColor(themeColor);
//        mRefreshLayout.setBottomView(bottomView);
        enableLoading(false);
//        mRefreshLayout.setFloatRefresh(true);//是否使用悬浮加载样式（无侵入式）
        return this;
    }

    public RefreshRecyclerViewHelper setOnRefreshListener (RefreshLayout.RefreshListener listener) {
        mRefreshLayout.setOnRefreshListener(listener);
        return this;
    }

    public RefreshRecyclerViewHelper startRefresh () {
        if (mRefreshLayout == null) {
            Log.e("RefreshStyleViewHelper->", "RefreshLayout引用为空");
            return this;
        }
        mRefreshLayout.startRefresh();
        return this;
    }

    public RefreshRecyclerViewHelper startLoadMore () {
        if (mRefreshLayout == null) {
            Log.e("RefreshStyleViewHelper->", "RefreshLayout引用为空");
            return this;
        }
        mRefreshLayout.startLoadMore();
        return this;
    }

    public void finishRefreshing () {
        mRefreshLayout.finishRefreshing();
    }

    public void refreshLoadingComplete () {
        if (mRefreshLayout == null) {
            Log.e("RefreshStyleViewHelper->", "RefreshLayout引用为空");
            return;
        }
        mRefreshLayout.finishRefreshing();
        mRefreshLayout.finishLoadmore();
    }

    public RefreshRecyclerViewHelper enableLoading (boolean enable) {
        if (mRefreshLayout == null) {
            Log.e("RefreshStyleViewHelper->", "RefreshLayout引用为空");
            return this;
        }
        mRefreshLayout.setEnableLoadmore(enable);
        return this;
    }

    public RefreshRecyclerViewHelper enableRefresh (boolean enable) {
        if (mRefreshLayout == null) {
            Log.e("RefreshStyleViewHelper->", "RefreshLayout引用为空");
            return this;
        }
        mRefreshLayout.setEnableRefresh(enable);
        return this;
    }
}
