package com.yongxingg.mydemo.mvp;

/**
 * Created by gaoyongxing on 2018-11-13.
 */
public interface LoginContracts {
    public interface View extends LoginBase.BaseView<Presenter> {
        UserBean getUserInfo();
        void setData(UserBean string);
    }
    public interface Presenter extends LoginBase.BasePresenter{
        boolean checkUser(UserBean bean);
        void getNetData();
        void submit();
    }

}
