package com.yongxingg.mydemo.mvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.EditText;

import com.yongxingg.mydemo.R;

public class LoginView extends AppCompatActivity implements LoginContracts.View{
    EditText username,password;
    AppCompatButton submit;
    private LoginContracts.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_view);
        username = (EditText) findViewById(R.id.userName);
        password = (EditText) findViewById(R.id.password);
        submit = (AppCompatButton) findViewById(R.id.submit);
        mPresenter.getNetData();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isCheck = mPresenter.checkUser(getUserInfo());
                if (isCheck){
                    mPresenter.submit();
                }
            }
        });
    }

    @Override
    public UserBean getUserInfo() {
        UserBean bean = new UserBean();
        bean.setName(username.getText().toString().trim());
        bean.setPassword(password.getText().toString().trim());
        return bean;
    }

    @Override
    public void setData(UserBean string) {

    }

    @Override
    public void showDialog() {
        //
    }

    @Override
    public void dismissDialog() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null != mPresenter){
            mPresenter.onDestory();
            mPresenter = null;
        }
    }

    @Override
    public void setPresenter(LoginContracts.Presenter presenter) {
        mPresenter = presenter;
    }
}
