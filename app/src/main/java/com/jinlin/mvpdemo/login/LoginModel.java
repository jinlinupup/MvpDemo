package com.jinlin.mvpdemo.login;

import com.jinlin.mvpdemo.bean.UserBean;
import com.jinlin.mvpdemo.base.BaseModel;
import com.jinlin.mvpdemo.base.BaseResponse;
import com.jinlin.mvpdemo.net.RetrofitUtil;

import io.reactivex.Observable;

/*********************************************************
 * LoginModel
 * @author jinlin
 * @email jinlinsu@qq.com
 * @dete 2018/7/9
 *********************************************************/
public class LoginModel extends BaseModel implements LoginContract.Model {
    @Override
    public Observable<BaseResponse<UserBean>> getData(String name, String pwd) {
        return RetrofitUtil.getHttpService().login(name, pwd);
    }
}
