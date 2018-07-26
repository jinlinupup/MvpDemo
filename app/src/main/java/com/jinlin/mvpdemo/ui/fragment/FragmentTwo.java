package com.jinlin.mvpdemo.ui.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jinlin.mvpdemo.R;
import com.jinlin.mvpdemo.base.BaseFragment;
import com.jinlin.mvpdemo.base.BaseMvpFragment;
import com.jinlin.mvpdemo.base.IView;

import butterknife.BindView;
import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;

/*********************************************************
 * FragmentTwo
 * @author jinlin
 * @email jinlinsu@qq.com
 * @dete 2018/7/23
 *********************************************************/
public class FragmentTwo extends BaseMvpFragment<OnePresenter> implements IView {
//    @BindView(R.id.videoplayer)
    JZVideoPlayerStandard jzVideoPlayerStandard;

    public static FragmentTwo newInstance() {
        FragmentTwo ft = new FragmentTwo();
        return ft;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main_two;
    }

    @Override
    protected void initView(View view) {
//        TextView tvInfo = view.findViewById(R.id.textView);
//        tvInfo.setText("FROU");
        jzVideoPlayerStandard = view.findViewById(R.id.videoplayer);
        jzVideoPlayerStandard.setUp("http://jzvd.nathen.cn/c6e3dc12a1154626b3476d9bf3bd7266/6b56c5f0dc31428083757a45764763b0-5287d2089db37e62345123a1be272f8b.mp4",
                JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL,
                "饺子闭眼睛");

        Glide.with(this).load("http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640").into(jzVideoPlayerStandard.thumbImageView);
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
    public void onPause() {
        super.onPause();
        super.onPause();
        JZVideoPlayer.releaseAllVideos();
    }
}
