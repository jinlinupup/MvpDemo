package com.jinlin.mvpdemo.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.jinlin.mvpdemo.R;
import com.jinlin.mvpdemo.base.BaseFragment;
import com.jinlin.mvpdemo.base.BaseMvpFragment;
import com.jinlin.mvpdemo.base.adapter.CommonAdapter;
import com.jinlin.mvpdemo.base.adapter.ViewHolder;
import com.jinlin.mvpdemo.bean.NewsBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/*********************************************************
 * FragmentOne
 * @author jinlin
 * @email jinlinsu@qq.com
 * @dete 2018/7/23
 *********************************************************/
public class FragmentOne extends BaseMvpFragment<OnePresenter> implements OneContract.View {

    private CommonAdapter<NewsBean> adapter;
    private List<NewsBean> mData;
    @BindView(R.id.lvDemo)
    ListView lvDemo;

    public static FragmentOne newInstance() {
        Bundle bundle = new Bundle();
        FragmentOne fragment = new FragmentOne();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void initView(View view) {
        if (mData == null) {
            mData = new ArrayList<>();
        }
        adapter = new CommonAdapter<NewsBean>(getActivity(), mData, R.layout.fragment_one_list_item) {
            @Override
            public void convert(ViewHolder helper, NewsBean item, int position) {
                helper.setText(R.id.tvUser, item.getSubject());
                helper.setText(R.id.tvTitle, item.getTitle());
                helper.setText(R.id.tvContent, item.getContent());
                helper.setText(R.id.tvTime, item.getTime());

            }
        };
        lvDemo.setAdapter(adapter);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        mPresenter.getNewsData();
    }

    @Override
    protected OnePresenter createPresenter() {
        return new OnePresenter();
    }

    @Override
    public void showData(List<NewsBean> data) {
        mData.addAll(data);
        adapter.updateListView(mData);
    }
}
