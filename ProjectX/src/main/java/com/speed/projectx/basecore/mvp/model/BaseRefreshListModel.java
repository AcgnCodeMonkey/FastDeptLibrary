package com.speed.projectx.basecore.mvp.model;

import com.speed.projectx.basecore.mvp.model.port.IBaseRefreshListModel;
import com.xujl.baselibrary.mvp.port.IBasePresenter;
import com.xujl.utilslibrary.data.BeanUtils;
import com.xujl.utilslibrary.data.ListUtils;
import com.xujl.utilslibrary.data.StringFormat;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by xujl on 2017/12/4.
 *
 * @param <S> Payload类型
 * @param <T> 实体类类型
 */

public abstract class BaseRefreshListModel<S, T> extends BaseCoreModel implements IBaseRefreshListModel {
    public List<T> mList;
    public int mCount = 1;
    public String mTotalCount;
    private Type payloadType;

    @Override
    public void initModel (IBasePresenter presenter) {
        super.initModel(presenter);
        mList = new ArrayList<>();
        mTotalCount = "0";
    }

    @Override
    public void addData (String json, int mode) {
        S payload = fromJson(json, (Class<S>) payloadType);
        if (mode == MODE_1) {
            mList.clear();
        }
        if (payload == null) {
            return;
        }
        //判断子类是否自定义添加了数据，没有自定义添加就自动添加
        if (!customAddData((S) payload)) {
            try {
                mList.addAll((Collection<? extends T>) BeanUtils.getList(payload));
            } catch (NullPointerException e) {
                e.printStackTrace();
                return;
            }
        }

        //这里需要自己根据接口改写一下
//        if (payload.pageInfo != null) {
//            mTotalCount = payload.pageInfo.totalCount;
//        } else if (!ViewTool.isEmpty(payload.totalCount)) {
//            mTotalCount = payload.totalCount;
//        }
        mCount++;
    }

    /**
     * 自定义添加数据
     */
    protected boolean customAddData (S payload) {
        return false;
    }

    @Override
    public void resetCount () {
        mTotalCount = "0";
        mCount = 1;
    }

    @Override
    public List<T> getDataList () {
        return mList;
    }

    @Override
    public int getCount () {
        return mCount;
    }

    @Override
    public int getTotalCount () {
        return StringFormat.intOf(mTotalCount);
    }

    @Override
    public void setCount (int count) {
        mCount = count;
    }

    @Override
    public void setTotalCount (String totalCount) {
        mTotalCount = totalCount;
    }

    @Override
    public int getDataListSize () {
        return ListUtils.getSize(mList);
    }
}
