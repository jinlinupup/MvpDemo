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
 * FragmentTwo
 * @author jinlin
 * @email jinlinsu@qq.com
 * @dete 2018/7/23
 *********************************************************/
public class FragmentTwo extends BaseMvpFragment<OnePresenter> implements IView {

    public static FragmentTwo newInstance() {
        FragmentTwo ft = new FragmentTwo();
        return ft;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_base;
    }

    @Override
    protected void initView(View view) {
        TextView tvInfo = view.findViewById(R.id.textView);
        tvInfo.setText("FROU");
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
