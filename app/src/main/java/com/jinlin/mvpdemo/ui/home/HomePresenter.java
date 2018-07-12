package com.jinlin.mvpdemo.ui.home;

import com.jinlin.mvpdemo.base.BaseObserver;
import com.jinlin.mvpdemo.base.BasePresenter;
import com.jinlin.mvpdemo.bean.TaobaoBean;
import com.jinlin.mvpdemo.rx.RxSchedulers;

import java.util.List;

/*********************************************************
 * HomePresenter
 * @author jinlin
 * @email jinlinsu@qq.com
 * @dete 2018/7/12
 *********************************************************/
public class HomePresenter extends BasePresenter<HomeContract.Model, HomeContract.View> {
    @Override
    protected HomeContract.Model createModel() {
        return new HomeModel();
    }

    public void getTaobaoData() {
        getmModel().getData()
                .compose(RxSchedulers.applySchedulers(getLifecycleProvider()))
                .subscribe(new BaseObserver<List<TaobaoBean>>(getmView()) {
                    @Override
                    public void onSuccess(List<TaobaoBean> result) {
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
