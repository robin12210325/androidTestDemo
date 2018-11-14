package com.yongxingg.mydemo.mvp;

/**
 * Created by gaoyongxing on 2018-11-13.
 */
public interface LoginBase {
    public interface BaseView<T extends BasePresenter>{
        void showDialog();
        void dismissDialog();
        void setPresenter(T presenter);
    }
    public interface BasePresenter{

    }
}
