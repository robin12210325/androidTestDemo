package com.yongxingg.mydemo.UI.androidUI;

import android.content.Context;

import com.yongxingg.mydemo.net.RetrofitUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by gaoyongxing on 2018-11-22.
 */
public class AndroidPresenter implements AndroidContracts.Presenter {
    private AndroidContracts.View view;
    private Context mContext;
    public AndroidPresenter(AndroidContracts.View view){
//        this.mContext = mContext;
        this.view = view;
        this.view.setPresenter(this);
    }

    @Override
    public void getAndroidData(String pageCount,int pageNum) {
        view.showDialog();
        RetrofitUtil.getInstance().getAndroidNews(pageCount,pageNum)
                .enqueue(new Callback<AndroidModel>() {
                    @Override
                    public void onResponse(Call<AndroidModel> call, Response<AndroidModel> response) {
                        view.dismissDialog();
                        if (null != view){
                            view.showData(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<AndroidModel> call, Throwable t) {
                        view.dismissDialog();
                    }
                });
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onDestory() {
        System.out.println("AndroidPresenter=" + "onDestory");
        if (null != view){
            view = null;
        }
    }
}
