package com.jinlin.mvpdemo.ui.home;

import com.jinlin.mvpdemo.base.BaseResponse;
import com.jinlin.mvpdemo.base.IModel;
import com.jinlin.mvpdemo.base.IView;
import com.jinlin.mvpdemo.bean.TaobaoBean;

import java.util.List;

import io.reactivex.Observable;

/*********************************************************
 * HomeContract
 * @author jinlin
 * @email jinlinsu@qq.com
 * @dete 2018/7/12
 *********************************************************/
public interface HomeContract {

    interface View extends IView {
        void showData(List<TaobaoBean> data);
    }

    interface Model extends IModel {
        Observable<BaseResponse<List<TaobaoBean>>> getData();
    }
}
