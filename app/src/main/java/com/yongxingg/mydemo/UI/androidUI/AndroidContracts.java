package com.yongxingg.mydemo.UI.androidUI;

/**
 * Created by gaoyongxing on 2018-11-22.
 */
public interface AndroidContracts {
    public interface View extends AndroidBase.BaseView<Presenter> {
        void showData(AndroidModel string);
    }
    public interface Presenter extends AndroidBase.BasePresenter{
        void getAndroidData(String pageCount,int pageNum);
    }
}
