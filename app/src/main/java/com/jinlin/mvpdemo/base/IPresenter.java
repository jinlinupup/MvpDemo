package com.jinlin.mvpdemo.base;

/*********************************************************
 * IPresenter
 * @author jinlin
 * @email jinlinsu@qq.com
 * @dete 2018/7/9
 *********************************************************/
public interface IPresenter<V extends IView> {
    /**
     * 绑定 View
     */
    void attachView(V mView);

    /**
     * 解除 View
     */
    void detachView();
}
