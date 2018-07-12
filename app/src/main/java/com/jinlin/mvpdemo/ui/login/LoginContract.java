package com.jinlin.mvpdemo.ui.login;

import com.jinlin.mvpdemo.base.IModel;
import com.jinlin.mvpdemo.base.IView;
import com.jinlin.mvpdemo.base.BaseResponse;
import com.jinlin.mvpdemo.bean.UserBean;

import io.reactivex.Observable;

/*********************************************************
 * LoginContract
 * @author jinlin
 * @email jinlinsu@qq.com
 * @dete 2018/7/9
 *********************************************************/
public interface LoginContract {
    //对于经常使用的关于UI的方法可以定义到IView中,如显示隐藏进度条,和显示文字消息

    interface View extends IView {
        void showData(UserBean userBean);

    }

    interface Model extends IModel {
        Observable<BaseResponse<UserBean>> getData(String name, String pwd);
    }
}
