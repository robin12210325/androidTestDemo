package com.yongxingg.mydemo.mvp;

/**
 * Created by gaoyongxing on 2018-11-13.
 */
public class LoginPresenter implements LoginContracts.Presenter {
    private LoginContracts.View view;
    public LoginPresenter(LoginContracts.View baseView){
        this.view = baseView;
        this.view.setPresenter(this);
    }
    @Override
    public boolean checkUser() {
        if (view.getUserName().equals("")&& view.getPassword().equals("")){
            return false;
        }
        return true;
    }

    @Override
    public void getNetData() {
        //获取数据返回View
//        view.success();
        view.setData("返回数据");
    }

    @Override
    public void submit() {


    }
}
