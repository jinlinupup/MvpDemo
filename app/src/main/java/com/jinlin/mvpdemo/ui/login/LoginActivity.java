package com.jinlin.mvpdemo.ui.login;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jinlin.mvpdemo.bean.UserBean;
import com.jinlin.mvpdemo.R;
import com.jinlin.mvpdemo.base.BaseMvpActivity;
import com.jinlin.mvpdemo.util.ClickUtils;

import butterknife.BindView;

/*********************************************************
 * LoginActivity
 * @author jinlin
 * @email jinlinsu@qq.com
 * @dete 2018/7/10
 *********************************************************/
public class LoginActivity extends BaseMvpActivity<LoginPresenter> implements LoginContract.View {

    @BindView(R.id.etUserName)
    EditText etUserName;

    @BindView(R.id.etPWd)
    EditText etPWd;

    @BindView(R.id.btnLogin)
    Button btnLogin;

    @BindView(R.id.tvUserInfo)
    TextView tvUserInfo;

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initListener() {
        btnLogin.setOnClickListener(view -> {
            if (!ClickUtils.isFastDoubleClick(R.id.btnLogin)) {
                if (etUserName.getText().toString().equals("") || etPWd.getText().toString().equals("")) {
                    Toast.makeText(LoginActivity.this, "用户名密码不能为空", Toast.LENGTH_SHORT).show();
                } else {
                    mPresenter.requestData(etUserName.getText().toString(), etPWd.getText().toString());
                }
            }

        });
    }

    @Override
    protected void initData() {

    }

    @Override
    public void showError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void showData(UserBean userBean) {
        tvUserInfo.setText("User:" + userBean.getUser()
                + '\n' + "Token:" + userBean.getToken()
                + '\n' + "Uid:" + userBean.getUid());
    }
}
