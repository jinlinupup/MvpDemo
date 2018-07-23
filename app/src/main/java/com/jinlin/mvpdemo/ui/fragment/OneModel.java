package com.jinlin.mvpdemo.ui.fragment;

import com.jinlin.mvpdemo.base.BaseModel;
import com.jinlin.mvpdemo.base.BaseResponse;
import com.jinlin.mvpdemo.bean.NewsBean;
import com.jinlin.mvpdemo.net.RetrofitUtil;

import java.util.List;

import io.reactivex.Observable;

/*********************************************************
 * OneModel
 * @author jinlin
 * @email jinlinsu@qq.com
 * @dete 2018/7/23
 *********************************************************/
public class OneModel extends BaseModel implements OneContract.Model {

    @Override
    public Observable<BaseResponse<List<NewsBean>>> getData() {
        return RetrofitUtil.getHttpService().newsData();
    }
}
