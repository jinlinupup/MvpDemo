package com.jinlin.mvpdemo.ui.fragment;

import com.jinlin.mvpdemo.base.BaseObserver;
import com.jinlin.mvpdemo.base.BasePresenter;
import com.jinlin.mvpdemo.bean.NewsBean;
import com.jinlin.mvpdemo.rx.RxSchedulers;

import java.util.List;

/*********************************************************
 * OnePresente
 * @author jinlin
 * @email jinlinsu@qq.com
 * @dete 2018/7/23
 *********************************************************/
public class OnePresenter extends BasePresenter<OneContract.Model, OneContract.View> {
    @Override
    protected OneContract.Model createModel() {
        return new OneModel();
    }

    public void getNewsData() {
        getmModel().getData()
                .compose(RxSchedulers.applySchedulers(getLifecycleProvider()))
                .subscribe(new BaseObserver<List<NewsBean>>(getmView()) {
                    @Override
                    public void onSuccess(List<NewsBean> result) {
                        getmView().showData(result);
                    }

                    @Override
                    public void onFailure(String errMsg) {
                        getmView().showError(errMsg);
                    }
                });
    }
}
