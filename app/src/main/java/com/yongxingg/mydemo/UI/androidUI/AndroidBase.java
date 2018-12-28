package com.yongxingg.mydemo.UI.androidUI;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;

/**
 * Created by gaoyongxing on 2018-11-22.
 */
public interface AndroidBase {
    public interface BaseView<T extends BasePresenter>{
        void showDialog();
        void dismissDialog();
        void setPresenter(T presenter);
    }
    public interface BasePresenter extends LifecycleObserver {
        @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
        void onCreate();
        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        void onDestory();
    }
}
