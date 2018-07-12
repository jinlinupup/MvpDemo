package com.jinlin.mvpdemo.ui.home;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.bumptech.glide.Glide;
import com.jinlin.mvpdemo.R;
import com.jinlin.mvpdemo.base.BaseMvpActivity;
import com.jinlin.mvpdemo.base.adapter.CommonAdapter;
import com.jinlin.mvpdemo.base.adapter.ViewHolder;
import com.jinlin.mvpdemo.bean.TaobaoBean;
import com.jinlin.mvpdemo.util.ClickUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class HomeActivity extends BaseMvpActivity<HomePresenter> implements HomeContract.View {

    private CommonAdapter<TaobaoBean> adapter;
    private List<TaobaoBean> mData;


    @BindView(R.id.lvDemo)
    ListView lvDemo;
    @BindView(R.id.btnRes)
    Button btnRes;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.getTaobaoData();
    }

    @Override
    protected HomePresenter createPresenter() {
        return new HomePresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void initView() {
        Log.d("TAG--", "initView");
        if (mData == null) {
            mData = new ArrayList<>();
        }
        adapter = new CommonAdapter<TaobaoBean>(this, mData, R.layout.activity_home_list_item) {
            @Override
            public void convert(ViewHolder helper, TaobaoBean item, int position) {
                helper.setText(R.id.tvUser, item.getUser());
                helper.setText(R.id.tvTitle, item.getTitle());
                helper.setText(R.id.tvPrice, "" + item.getPrice());
                Glide.with(HomeActivity.this).load(item.getImage()).into((ImageView) helper.getView(R.id.ivImage));
                helper.setText(R.id.tvTime, item.getTime());
                helper.setText(R.id.tvRegion, item.getRegion());
            }
        };

        lvDemo.setAdapter(adapter);

    }

    @Override
    protected void initListener() {
        btnRes.setOnClickListener(view -> {
            if (!ClickUtils.isFastDoubleClick(R.id.btnRes))
                mPresenter.getTaobaoData();
        });
    }

    @Override
    protected void initData() {
        Log.d("TAG--", "initListener");
    }

    @Override
    public void showData(List<TaobaoBean> data) {
        mData.addAll(data);
        if (mData != null && mData.size() > 0) {
            adapter.updateListView(mData);
        }
    }

    @Override
    public void showError(String msg) {

    }
}
