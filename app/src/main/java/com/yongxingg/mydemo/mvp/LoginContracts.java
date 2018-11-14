package com.yongxingg.mydemo.mvp;

/**
 * Created by gaoyongxing on 2018-11-13.
 */
public interface LoginContracts {
    public interface View extends LoginBase.BaseView<Presenter> {
        String getUserName();
        String getPassword();
        void setData(String string);
    }
    public interface Presenter extends LoginBase.BasePresenter{
        boolean checkUser();
        void getNetData();
        void submit();
    }

}
