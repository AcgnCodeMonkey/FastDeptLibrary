package com.speed.projectx.basecore.mvp.model.port;

import java.util.List;

/**
 * Created by xujl on 2017/12/4.
 */

public interface IBaseRefreshListModel extends IBaseCoreModel {
    void addData (String json, int mode);
    <T> List<T> getDataList ();
    void resetCount ();//重新计数
    int getTotalCount ();//获取总页数
    int getCount ();//获取当前页码
    void setCount (int count);
    void setTotalCount (String totalCount);
    int getDataListSize ();
}
