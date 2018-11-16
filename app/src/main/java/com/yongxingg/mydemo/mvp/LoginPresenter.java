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
    public boolean checkUser(UserBean bean) {

        return false;
    }

    @Override
    public void getNetData() {
        //获取数据返回View
//        view.success();
        UserLoginModel model = new UserLoginModel();
        UserBean bean = model.getUserInfoData(view.getUserInfo());
        view.setData(bean);
    }

    @Override
    public void submit() {


    }

    @Override
    public void onDestory() {
        if (null != view){
            view = null;
        }
    }
}
