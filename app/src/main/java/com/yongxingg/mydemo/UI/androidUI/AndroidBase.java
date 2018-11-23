package com.yongxingg.mydemo.UI.androidUI;

/**
 * Created by gaoyongxing on 2018-11-22.
 */
public interface AndroidBase {
    public interface BaseView<T extends BasePresenter>{
        void showDialog();
        void dismissDialog();
        void setPresenter(T presenter);
    }
    public interface BasePresenter{
        void onDestory();
    }
}
