package com.speed.projectx.basecore.mvp.presenter;

import android.os.Bundle;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.speed.projectx.basecore.mvp.model.BaseCoreModel;
import com.speed.projectx.basecore.mvp.model.port.IBaseRefreshListModel;
import com.speed.projectx.basecore.mvp.view.port.IBaseRefreshListView;
import com.xujl.utilslibrary.data.ListUtils;
import com.xujl.utilslibrary.data.ParamsMapTool;
import com.xujl.utilslibrary.system.Log;
import com.xujl.widgetlibrary.widget.RefreshLayout;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by xujl on 2017/12/4.
 */

public abstract class BaseRefreshListActivityPresenter<V extends IBaseRefreshListView, M extends IBaseRefreshListModel, S extends BaseQuickAdapter>
        extends BaseCoreActivityPresenter<V, M> implements RefreshLayout.RefreshListener{
    protected BaseQuickAdapter mAdapter;

    @Override
    protected void initPresenter (Bundle savedInstanceState) {
        initAdapter();
    }

    private void initAdapter () {
        Type type = getClass().getGenericSuperclass();
        Type[] types = null;
        try {
            types = ((ParameterizedType) type).getActualTypeArguments();
        } catch (ClassCastException e) {
            Log.e("BaseRefreshListActivityPresenter---->", "需要传入泛型实例化Presenter");
            return;
        }
        Type adapterType = types[2];
        try {
            final Constructor<?>[] constructor = ((Class<S>) adapterType).getConstructors();
            final Class<?>[] parameterTypes = constructor[0].getParameterTypes();
            //判断构造器参数数量
            if (parameterTypes.length == 1) {
                mAdapter = (S) constructor[0].newInstance(mModel.getDataList());
            } else {
                mAdapter = (S) constructor[0].newInstance(mModel.getDataList(), exposeContext());
            }

        } catch (InstantiationException e) {
            e.printStackTrace();
            return;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return;
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            return;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return;
        }
        mView.setAdapter(mAdapter);
    }

    @Override
    public void onRefresh (RefreshLayout refreshLayout) {
        mView.enableLoad(false);
        mModel.resetCount();
        requestForGetNoHint(BaseCoreModel.MODE_1,getRefreshParams());
    }
    /**
     *
     * @return 传递刷新请求时的参数
     */
    protected ParamsMapTool getRefreshParams(){return null;}
    /**
     *
     * @return 传递加载请求时的参数
     */
    protected ParamsMapTool getLoadingParams(){return null;}
    @Override
    public void onLoading (RefreshLayout layout) {
        if (ListUtils.getSize(mModel.getDataList()) < mModel.getTotalCount()) {
            requestForGetNoHint(BaseCoreModel.MODE_2,getLoadingParams());
        }
    }
}
