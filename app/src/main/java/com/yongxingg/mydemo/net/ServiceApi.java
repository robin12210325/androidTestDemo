package com.yongxingg.mydemo.net;

import com.yongxingg.mydemo.UI.androidUI.AndroidModel;
import com.yongxingg.mydemo.model.TodayNewsModel;
import com.yongxingg.mydemo.news.NewsTypesModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by gaoyongxing on 2018-11-20.
 */
public interface ServiceApi {
    //获取当天的数据 Call方式
    @GET("today")
    Call<TodayNewsModel> getTodayNews();
    //RxJava方式
//    @GET("today")
//    Observable<TodayNewsModel> getTodayNews();
    //获取某一个品类的数据
    @GET("data/Android/{pageCount}/{pageNum}")
    Call<AndroidModel> getAndroidNews(@Path("pageCount") String pageCount,@Path("pageNum") int pageNum);
    //获取获取闲读的主分类
    @GET("xiandu/categories")
    Call<NewsTypesModel> getNewsType();
}
