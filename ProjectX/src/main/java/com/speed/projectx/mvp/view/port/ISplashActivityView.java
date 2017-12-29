package com.speed.projectx.mvp.view.port;


import android.graphics.Bitmap;

import com.speed.projectx.basecore.mvp.view.port.IBaseCoreView;

/**
 *
 */
public interface ISplashActivityView extends IBaseCoreView {
    void start();

    void hideImageView ();

    void clearImage ();
}

