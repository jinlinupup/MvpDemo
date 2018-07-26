package com.jinlin.mvpdemo.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Html;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.jinlin.mvpdemo.R;
import com.jinlin.mvpdemo.base.BaseFragment;
import com.jinlin.mvpdemo.base.BaseMvpFragment;
import com.jinlin.mvpdemo.base.IView;

/*********************************************************
 * FragmentThree
 * @author jinlin
 * @email jinlinsu@qq.com
 * @dete 2018/7/23
 *********************************************************/
public class FragmentThree extends BaseMvpFragment<OnePresenter> implements IView {
    private static final String TAG = "FRAGMENT_THREE";
    Button btnType;
    TextView tvText;

    public static FragmentThree newInstance() {
        FragmentThree ft = new FragmentThree();
        return ft;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main_three;
    }

    @Override
    protected void initView(View view) {
//        TextView tvInfo = view.findViewById(R.id.textView);
        btnType = view.findViewById(R.id.btnType);
//        tvInfo.setText("FROU");
        btnType.setOnTouchListener(shopCarSettleTouch);

        tvText = view.findViewById(R.id.tvText);

        tvText.setText(Html.fromHtml("北京市发布霾黄色预警，<span style=\"font-size=156px\">1</span>口罩"));
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

    private View.OnTouchListener shopCarSettleTouch = new View.OnTouchListener() {
        int lastX, lastY;

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            int ea = event.getAction();
            DisplayMetrics dm = getResources().getDisplayMetrics();
            int screenWidth = dm.widthPixels;
//            int screenHeight = dm.heightPixels - 100;//需要减掉图片的高度
            int screenHeight = dm.heightPixels;//需要减掉图片的高度
            switch (ea) {
                case MotionEvent.ACTION_DOWN:
                    lastX = (int) event.getRawX();//获取触摸事件触摸位置的原始X坐标
                    lastY = (int) event.getRawY();
                case MotionEvent.ACTION_MOVE:
                    //event.getRawX();获得移动的位置
                    int dx = (int) event.getRawX() - lastX;
                    int dy = (int) event.getRawY() - lastY;
                    int l = v.getLeft() + dx;
                    int b = v.getBottom() + dy;
                    int r = v.getRight() + dx;
                    int t = v.getTop() + dy;

                    //下面判断移动是否超出屏幕
                    if (l < 0) {
                        l = 0;
                        r = l + v.getWidth();
                    }
                    if (t < 0) {
                        t = 0;
                        b = t + v.getHeight();
                    }
                    if (r > screenWidth) {
                        r = screenWidth;
                        l = r - v.getWidth();
                    }
                    if (b > screenHeight) {
                        b = screenHeight;
                        t = b - v.getHeight();
                    }
                    v.layout(l, t, r, b);
                    Log.e(TAG, "onTouch: " + l + "==" + t + "==" + r + "==" + b);
                    lastX = (int) event.getRawX();
                    lastY = (int) event.getRawY();
                    v.postInvalidate();
                    break;
                case MotionEvent.ACTION_UP:
                    break;
            }
            return true;
        }

    };
}
