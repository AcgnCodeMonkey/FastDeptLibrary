package com.xujl.applibrary.mvp.port;

import com.xujl.baselibrary.mvp.port.IBaseModel;
import com.xujl.datalibrary.network.ResultEntity;
import com.xujl.rxlibrary.BaseObserver;
import com.xujl.rxlibrary.RxLife;
import com.xujl.utilslibrary.data.DataException;
import com.xujl.utilslibrary.data.ParamsMapTool;

/**
 * Created by xujl on 2017/7/4.
 */

public interface ICommonModel extends IBaseModel {
    void requestForGet (int mode, ParamsMapTool paramsMapTool, final RxLife rxLife, BaseObserver<ResultEntity> observer);

    void requestForPost (int mode, ParamsMapTool paramsMapTool, final RxLife rxLife, BaseObserver<ResultEntity> observer);

    /**
     * 验证数据字段正确性
     * @param obj
     * @throws DataException
     */
    void validatorData (Object obj) throws DataException;


}
