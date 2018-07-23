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
import com.jinlin.mvpdemo.bean.NewsBean;

import java.util.List;

/*********************************************************
 * FragmentOne
 * @author jinlin
 * @email jinlinsu@qq.com
 * @dete 2018/7/23
 *********************************************************/
public class FragmentOne extends BaseMvpFragment<OnePresenter> implements OneContract.View {

    public static FragmentOne newInstance() {
        Bundle bundle = new Bundle();
        FragmentOne fragment = new FragmentOne();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_base;
    }

    @Override
    protected void initView(View view) {
        TextView tvInfo = view.findViewById(R.id.textView);
        tvInfo.setText("ONE");
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

    @Override
    public void showData(List<NewsBean> data) {

    }
}
