package com.jinlin.mvpdemo.net;

import com.jinlin.mvpdemo.base.BaseResponse;
import com.jinlin.mvpdemo.bean.UserBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/*********************************************************
 * Api
 * @author jinlin
 * @email jinlinsu@qq.com
 * @dete 2018/6/29
 *********************************************************/
public interface Api {
    @GET("user/login")
    Observable<BaseResponse<UserBean>> login(@Query("name") String name, @Query("password") String pwd);

}
