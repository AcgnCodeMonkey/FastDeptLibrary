package com.xujl.applibrary.mvp.common;

import android.support.annotation.IntDef;

import com.xujl.utilslibrary.data.ParamsMapTool;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by xujl on 2018/1/11.
 */

public class Setting {
    public static final int GET = 0;
    public static final int POST = 1;
    /**
     * 请求参数
     */
    private ParamsMapTool params;
    /**
     * 是否显示加载弹窗提示,默认不显示
     */
    private boolean showHint;
    /**
     * 是否绑定生命周期
     */
    private boolean isBind = true;
    /**
     * 请求类型，默认为GET请求
     */
    private @Type
    int type;

    private Setting () {

    }

    public static Setting init () {
        return new Setting();
    }

    public Setting setParams (ParamsMapTool params) {
        this.params = params;
        return this;
    }

    public Setting setShowHint (boolean showHint) {
        this.showHint = showHint;
        return this;
    }

    public Setting setBind (boolean bind) {
        isBind = bind;
        return this;
    }

    public Setting setType (@Type int type) {
        this.type = type;
        return this;
    }

    public ParamsMapTool getParams () {
        return params;
    }

    public boolean isShowHint () {
        return showHint;
    }

    public boolean isBind () {
        return isBind;
    }

    public int getType () {
        return type;
    }

    @IntDef({GET, POST})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Type {
    }
}
