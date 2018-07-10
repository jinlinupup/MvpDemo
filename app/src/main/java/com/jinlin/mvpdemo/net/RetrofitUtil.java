package com.jinlin.mvpdemo.net;


import com.jinlin.mvpdemo.base.BaseRetrofit;

/*********************************************************
 * RetrofitUtil
 * @author jinlin
 * @email jinlinsu@qq.com
 * @dete 2018/7/9
 *********************************************************/
public class RetrofitUtil extends BaseRetrofit {
    private static Api httpService;

    public static Api getHttpService() {
        if (httpService == null) {
            httpService = getRetrofit().create(Api.class);
        }
        return httpService;
    }
}
