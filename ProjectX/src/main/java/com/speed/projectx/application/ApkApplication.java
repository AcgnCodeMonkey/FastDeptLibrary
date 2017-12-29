package com.speed.projectx.application;

import android.support.multidex.MultiDexApplication;

import com.speed.projectx.R;
import com.xujl.utilslibrary.other.DebugConfig;
import com.xujl.utilslibrary.system.DelegateApplication;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by xujl on 2017/12/29.
 */

public class ApkApplication extends MultiDexApplication{
    @Override
    public void onCreate () {
        super.onCreate();
        DelegateApplication.getInstance().init(this);
        DebugConfig.setDebug(true);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/PingFangLight.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build());
    }
}
