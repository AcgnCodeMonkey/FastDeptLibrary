package com.xujl.utilslibrary.system;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;

/**
 * Created by xujl on 2017/11/6.
 */

public class ResUtil {
    private static Context mContext;

    public static void setContext (Context context) {
        ResUtil.mContext = context;
    }

    public static int getColor (@ColorRes int resId) {
        return ContextCompat.getColor(mContext, resId);
    }

    public static Drawable getDrawable (@DrawableRes int resId) {
        return ContextCompat.getDrawable(mContext, resId);
    }

    public static String getString (@StringRes int resId) {
        return mContext.getResources().getString(resId);
    }
}
