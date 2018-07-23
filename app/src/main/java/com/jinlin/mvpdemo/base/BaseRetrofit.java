package com.jinlin.mvpdemo.base;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.jinlin.mvpdemo.app.BaseApplication;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/*********************************************************
 * BaseRetrofit
 * @author jinlin
 * @email jinlinsu@qq.com
 * @dete 2018/7/9
 *********************************************************/
public class BaseRetrofit {

    private static OkHttpClient client;

    private static volatile Retrofit retrofit;

    public static Retrofit getRetrofit() {


        if (retrofit == null) {
            synchronized (BaseRetrofit.class) {
                if (retrofit == null) {
                    //添加一个log拦截器，打印所有的log
                    HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
                    //可以设置请求过滤的水平
                    httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                    //设置 请求的缓存的大小跟位置
                    File cacheFile = new File(BaseApplication.getContext().getCacheDir(), "cache");
                    Cache cache = new Cache(cacheFile, 1024 * 1024 * 50);//50MB  缓存的大小

                    client = new OkHttpClient
                            .Builder()
                            .addInterceptor(httpLoggingInterceptor) //日志，所有的请求响应
                            .connectTimeout(15, TimeUnit.SECONDS) //连接超时时间
                            .readTimeout(15, TimeUnit.SECONDS) //读取超时时间
                            .writeTimeout(15, TimeUnit.SECONDS)//写入超时时间
                            .retryOnConnectionFailure(false)//连接不上是否重连，false不重连
                            .cache(cache)  //添加缓存
                            .build();
                    retrofit = new Retrofit
                            .Builder()
                            .baseUrl("http://www.wanandroid.com/tools/mockapi/7677/")
                            .client(client)
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                }
            }
        }


        return retrofit;
    }
}
