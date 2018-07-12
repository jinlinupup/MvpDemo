package com.jinlin.mvpdemo.ui.home;

import com.jinlin.mvpdemo.base.BaseModel;
import com.jinlin.mvpdemo.base.BaseResponse;
import com.jinlin.mvpdemo.bean.TaobaoBean;
import com.jinlin.mvpdemo.net.RetrofitUtil;

import java.util.List;

import io.reactivex.Observable;

/*********************************************************
 * HomeModel
 * @author jinlin
 * @email jinlinsu@qq.com
 * @dete 2018/7/12
 *********************************************************/
public class HomeModel extends BaseModel implements HomeContract.Model {
    @Override
    public Observable<BaseResponse<List<TaobaoBean>>> getData() {
        return RetrofitUtil.getHttpService().taobaoData();
    }
}
