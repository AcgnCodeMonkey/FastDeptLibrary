package com.xujl.applibrary.mvp.port;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.xujl.baselibrary.mvp.port.IBasePresenter;
import com.xujl.baselibrary.mvp.presenter.BaseFragmentPresenter;
import com.xujl.rxlibrary.RxLife;

/**
 * Created by xujl on 2017/7/4.
 */

public interface ICommonPresenter extends IBasePresenter,IRequest {

    RxLife getRxLife ();
    <S extends Activity> void gotoActivity (Class<S> cls, Bundle bundle);

    <S extends Activity> void gotoActivity (Class<S> cls, Bundle bundle, int requestCode);

    <S extends Activity> void gotoActivity (Class<S> cls);

    void gotoActivity (Intent intent);

    void gotoActivity (Intent intent, int requestCode);

    <S extends Activity> void gotoActivity (Class<S> cls, int requestCode);

    void backForResult (Bundle bundle, int result);//返回activity，需要传入返回码

    void backForResult (Intent intent, int result);//返回activity，需要传入返回码

    void backForResult (int result);//返回activity，需要传入返回码



}
