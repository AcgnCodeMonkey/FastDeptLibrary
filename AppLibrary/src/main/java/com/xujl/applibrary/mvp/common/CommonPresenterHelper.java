package com.xujl.applibrary.mvp.common;

import android.content.Intent;
import android.os.Bundle;

import com.xujl.applibrary.mvp.port.ICommonModel;
import com.xujl.applibrary.mvp.port.ICommonPresenter;
import com.xujl.applibrary.mvp.port.ICommonView;
import com.xujl.applibrary.mvp.port.IRequestType;
import com.xujl.applibrary.util.CustomToast;
import com.xujl.baselibrary.mvp.common.BasePresenterHelper;
import com.xujl.baselibrary.mvp.presenter.BaseActivityPresenter;
import com.xujl.baselibrary.utils.ActivityManger;
import com.xujl.datalibrary.network.ResultEntity;
import com.xujl.rxlibrary.BaseObserver;
import com.xujl.utilslibrary.data.ParamsMapTool;
import com.xujl.utilslibrary.view.ViewTool;

import io.reactivex.annotations.NonNull;

/**
 * Created by xujl on 2017/7/4.
 */

public class CommonPresenterHelper extends BasePresenterHelper {
    /**
     * @param type
     * @param paramsMapTool
     * @param showHint      是否显示加载提示
     */
    public void requestForGet (final IRequestType type, ParamsMapTool paramsMapTool, final boolean showHint,
                               ICommonModel model, final ICommonView view, final ICommonPresenter presenter) {
        request(type, Setting.init()
                        .setParams(paramsMapTool)
                        .setType(Setting.GET)
                        .setShowHint(showHint)
                , model, view, presenter);
    }

    /**
     * @param type
     * @param paramsMapTool
     * @param showHint      是否显示加载提示
     */
    public void requestForPost (final IRequestType type, ParamsMapTool paramsMapTool, final boolean showHint,
                                ICommonModel model, final ICommonView view, final ICommonPresenter presenter) {
        request(type, Setting.init()
                        .setParams(paramsMapTool)
                        .setType(Setting.POST)
                        .setShowHint(showHint)
                , model, view, presenter);
    }

    public void request (final IRequestType type, final Setting setting, ICommonModel model,
                         final ICommonView view, final ICommonPresenter presenter) {

        if (setting.isShowHint()) {
            view.showLoading();
        }
        //网络请求与生命周期绑定，界面被销毁时，不接受回调结果
        if (setting.getType() == Setting.GET) {
            model.requestForGet(type, setting.getParams(),
                    setting.isBind() ? presenter.getRxLife() : null, new BaseObserver<ResultEntity>() {
                        @Override
                        public void onNext (@NonNull ResultEntity resultEntity) {
                            super.onNext(resultEntity);
                            if (setting.isShowHint()) {
                                view.dismissLoading();
                            }
                            if (resultEntity.getErrorCode() == 0) {
                                type.requestSuccess(presenter, resultEntity.getResultJson());
                                return;
                            }
                            type.requestFailed(presenter, resultEntity.getErrorCode(),
                                    resultEntity.getErrorString(), resultEntity.getResultJson());
                        }
                    });
        } else if (setting.getType() == Setting.POST) {
            model.requestForPost(type, setting.getParams(),
                    setting.isBind() ? presenter.getRxLife() : null, new BaseObserver<ResultEntity>() {
                        @Override
                        public void onNext (@NonNull ResultEntity resultEntity) {
                            super.onNext(resultEntity);
                            if (setting.isShowHint()) {
                                view.dismissLoading();
                            }
                            if (resultEntity.getErrorCode() == 0) {
                                type.requestSuccess(presenter, resultEntity.getResultJson());
                                return;
                            }
                            type.requestFailed(presenter, resultEntity.getErrorCode(),
                                    resultEntity.getErrorString(), resultEntity.getResultJson());
                        }
                    });
        }

    }

    public void exit (BaseActivityPresenter activity) {
        ActivityManger.newInstance().finishActivity(activity);
    }


    public void gotoActivity (BaseActivityPresenter presenter, Class<?> cls, Bundle bundle) {
        final Intent intent = new Intent(presenter, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        presenter.startActivity(intent);
    }


    public void gotoActivity (BaseActivityPresenter presenter, Class<?> cls, Bundle bundle, int requestCode) {
        final Intent intent = new Intent(presenter, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        presenter.startActivityForResult(intent, requestCode);
    }


    public void gotoActivity (BaseActivityPresenter presenter, Class<?> cls) {
        gotoActivity(presenter, cls, null);
    }


    public void gotoActivity (BaseActivityPresenter presenter, Class<?> cls, int requestCode) {
        gotoActivity(presenter, cls, null, requestCode);
    }


    public void backForResult (BaseActivityPresenter presenter, Bundle bundle, int result) {
        if (bundle != null) {
            final Intent intent = new Intent();
            intent.putExtras(bundle);
            presenter.setResult(result, intent);
        } else {
            presenter.setResult(result);
        }
        exit(presenter);
    }

    public void backForResult (BaseActivityPresenter presenter, Intent intent, int result) {
        if (intent != null) {
            presenter.setResult(result, intent);
        } else {
            presenter.setResult(result);
        }
        exit(presenter);
    }

    public void backForResult (BaseActivityPresenter presenter, int result) {
        presenter.setResult(result);
        exit(presenter);
    }


    public void gotoActivity (BaseActivityPresenter presenter, Intent intent, int requestCode) {
        presenter.startActivityForResult(intent, requestCode);
    }

    public void gotoActivity (BaseActivityPresenter presenter, Intent intent) {
        presenter.startActivity(intent);
    }


}
