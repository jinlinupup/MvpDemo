package com.jinlin.mvpdemo.base;

/*********************************************************
 * IView
 * @author jinlin
 * @email jinlinsu@qq.com
 * @dete 2018/7/9
 *********************************************************/
public interface IView {
    //显示loading
    void showLoading();

    //隐藏loading
    void hideLoading();

    //显示吐司
    void showError(String msg);
}

