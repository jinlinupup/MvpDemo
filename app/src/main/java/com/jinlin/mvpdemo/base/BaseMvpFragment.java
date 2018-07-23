package com.jinlin.mvpdemo.base;

import android.support.v4.app.Fragment;

import com.jinlin.mvpdemo.base.BasePresenter;
import com.jinlin.mvpdemo.base.IView;

/*********************************************************
 * BaseMvpFragment
 * @author jinlin
 * @email jinlinsu@qq.com
 * @dete 2018/7/23
 *********************************************************/
public abstract class BaseMvpFragment<T extends BasePresenter> extends BaseFragment implements IView {
    protected T mPresenter;

    @Override
    public void showLoading() {
        showLoadingDialog();
    }

    @Override
    public void hideLoading() {
        hideLoadingDialog();
    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void onStart() {
        super.onStart();
        if (getUserVisibleHint()) {
            mPresenter = createPresenter();
            if (mPresenter != null) {
                mPresenter.attachView(this);
            }
        }
    }

    protected abstract T createPresenter();
}
