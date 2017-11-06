package com.xujl.applibrary.mvp.common;

import com.google.gson.Gson;
import com.xujl.baselibrary.mvp.common.BaseModelHelper;
import com.xujl.utilslibrary.data.JsonUtil;

/**
 * Created by xujl on 2017/7/4.
 */

public class CommonModelHelper extends BaseModelHelper{
    public <T> T fromJson (String json, Class<T> classOfT) {
        return JsonUtil.fromJson(json,classOfT);
    }

    public String toJson (Object src) {
        return JsonUtil.toJson(src);
    }
}
