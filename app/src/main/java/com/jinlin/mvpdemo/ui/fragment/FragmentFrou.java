package com.jinlin.mvpdemo.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jinlin.mvpdemo.R;
import com.jinlin.mvpdemo.base.BaseFragment;
import com.jinlin.mvpdemo.base.BaseMvpFragment;
import com.jinlin.mvpdemo.base.IView;

/*********************************************************
 * FragmentFrou
 * @author jinlin
 * @email jinlinsu@qq.com
 * @dete 2018/7/23
 *********************************************************/
public class FragmentFrou extends BaseMvpFragment<OnePresenter> implements IView {
    public static FragmentFrou newInstance() {
        FragmentFrou ft = new FragmentFrou();
        return ft;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main_four;
    }

    @Override
    protected void initView(View view) {
        
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected OnePresenter createPresenter() {
        return new OnePresenter();
    }
}
