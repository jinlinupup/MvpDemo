package com.jinlin.mvpdemo.base;

import android.accounts.NetworkErrorException;

import com.jinlin.mvpdemo.net.ServerException;

import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/*********************************************************
 * BaseObserver
 * @author jinlin
 * @email jinlinsu@qq.com
 * @dete 2018/7/10
 *********************************************************/
public abstract class BaseObserver<T> implements Observer<BaseResponse<T>> {

    private IView mView;

    private boolean isShowDialog = true;

    public BaseObserver(IView mView) {
        this.mView = mView;
    }

    public BaseObserver(IView mView, boolean isShowDialog) {
        this.mView = mView;
        this.isShowDialog = isShowDialog;
    }

    @Override
    public void onSubscribe(Disposable d) {
        showLoadingDialog();
    }

    @Override
    public void onNext(BaseResponse<T> tBaseResponse) {
        hideLoadingDialog();
        if (tBaseResponse.getStatus() == 1000) {
            onSuccess(tBaseResponse);
        } else {
            onFailure(tBaseResponse.getDesc());
        }
    }

    @Override
    public void onError(Throwable e) {
        hideLoadingDialog();
        if (e instanceof ConnectException
                || e instanceof TimeoutException
                || e instanceof NetworkErrorException
                || e instanceof UnknownHostException) {
            onFailure(ServerException.handleException(e).getMessage());
        } else {
            onFailure(ServerException.handleException(e).getMessage());
        }
    }

    @Override
    public void onComplete() {

    }

    /**
     * 请求成功返回
     *
     * @param result 服务器返回数据
     */
    public abstract void onSuccess(BaseResponse<T> result);

    /**
     * 请求失败返回
     *
     * @param errMsg 失败信息
     */
    public abstract void onFailure(String errMsg);


    /**
     * 显示 LoadingDialog
     */
    private void showLoadingDialog() {
        if (isShowDialog && mView != null) {
            mView.showLoading();
        }
    }

    /**
     * 隐藏 Loading
     */
    private void hideLoadingDialog() {
        if (isShowDialog && mView != null) {
            mView.hideLoading();
        }
    }
}
