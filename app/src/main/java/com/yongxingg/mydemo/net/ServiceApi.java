package com.yongxingg.mydemo.net;

import com.yongxingg.mydemo.model.TodayNewsModel;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by gaoyongxing on 2018-11-20.
 */
public interface ServiceApi {
//    @GET("today")
//    Call<TodayNewsModel> getTodayNews();
    @GET("today")
    Observable<TodayNewsModel> getTodayNews();
}
