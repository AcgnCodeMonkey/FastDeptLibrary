package com.xujl.applibrary.util;


import com.xujl.utilslibrary.system.DensityUtil;
import com.xujl.utilslibrary.system.InternetState;
import com.xujl.utilslibrary.system.StartUpApplication;

/**
 * Created by xujl on 2017/7/6.
 */

public class AppApplication extends StartUpApplication {
    private static AppApplication sApplication;
    private String mViewPackageName;
    private String mModelPackageName;

    public static AppApplication getInstance () {
        return sApplication;
    }

    @Override
    public void onCreate () {
        super.onCreate();
        sApplication = this;
        setModelPackageName("com.xujl.mvpllirary.mvp.model");
        setViewPackageName("com.xujl.mvpllirary.mvp.view");
        DensityUtil.mContext = getApplicationContext();
        InternetState.setContext(getApplicationContext());
    }


    public String getViewPackageName () {
        return mViewPackageName;
    }

    public void setViewPackageName (String viewPackageName) {
        mViewPackageName = viewPackageName;
    }

    public String getModelPackageName () {
        return mModelPackageName;
    }

    public void setModelPackageName (String modelPackageName) {
        mModelPackageName = modelPackageName;
    }

}
