package com.jinlin.mvpdemo.ui.fragment;

import com.jinlin.mvpdemo.base.BaseResponse;
import com.jinlin.mvpdemo.base.IModel;
import com.jinlin.mvpdemo.base.IView;
import com.jinlin.mvpdemo.bean.NewsBean;

import java.util.List;

import io.reactivex.Observable;

/*********************************************************
 * OneContract
 * @author jinlin
 * @email jinlinsu@qq.com
 * @dete 2018/7/23
 *********************************************************/
public interface OneContract {
    interface View extends IView {
        void showData(List<NewsBean> data);
    }

    interface Model extends IModel {
        Observable<BaseResponse<List<NewsBean>>> getData();
    }
}
