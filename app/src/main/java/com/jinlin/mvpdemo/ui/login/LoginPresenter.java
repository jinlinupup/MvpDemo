package com.jinlin.mvpdemo.ui.login;

import com.jinlin.mvpdemo.bean.UserBean;
import com.jinlin.mvpdemo.base.BaseObserver;
import com.jinlin.mvpdemo.base.BasePresenter;
import com.jinlin.mvpdemo.rx.RxSchedulers;

/*********************************************************
 * LoginPresenter
 * @author jinlin
 * @email jinlinsu@qq.com
 * @dete 2018/7/10
 *********************************************************/
public class LoginPresenter extends BasePresenter<LoginContract.Model, LoginContract.View> {
    @Override
    protected LoginContract.Model createModel() {
        return new LoginModel();
    }


    public void requestData(final String name, String pwd) {
        getmModel().getData(name, pwd)
                .compose(RxSchedulers.applySchedulers(getLifecycleProvider()))
                .subscribe(new BaseObserver<UserBean>(getmView()) {
                    @Override
                    public void onSuccess(UserBean result) {
//                        if (result.getStatus() == 1000) {
//                            getmView().showData(result.getData());
//                        }
                        getmView().showData(result);
                    }

                    @Override
                    public void onFailure(String errMsg) {
                        getmView().showError(errMsg);
                    }
                });
    }

}
