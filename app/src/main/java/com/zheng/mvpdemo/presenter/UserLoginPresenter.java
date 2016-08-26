package com.zheng.mvpdemo.presenter;

import android.os.Handler;

import com.zheng.mvpdemo.mode.ILogin;
import com.zheng.mvpdemo.mode.UserBean;
import com.zheng.mvpdemo.mode.UserLogin;
import com.zheng.mvpdemo.view.ILoginView;

/**
 * Created by Administrator on 2016/8/26.
 */
public class UserLoginPresenter {

    private UserLogin mUserLogin;

    private ILoginView mLoginView;

    private Handler mHandler;

    public UserLoginPresenter(ILoginView loginView) {

        mHandler = new Handler();

        mLoginView = loginView;
        mUserLogin = new UserLogin();
    }

    /**
     * 用户登录
     */
    public void login(){

        mLoginView.showProgressBar();

        mUserLogin.login(mLoginView.getUserName(), mLoginView.getPassword(), new ILogin() {

            @Override
            public void onLoginSuccess() {

                mHandler.post(new Runnable() {
                    @Override
                    public void run() {

                        mLoginView.hideProgressBar();

                        UserBean userBean = new UserBean();
                        userBean.setUserName(mLoginView.getUserName());
                        userBean.setPassword(mLoginView.getPassword());

                        mLoginView.loginSuccessToMainActivity(userBean);
                    }
                });
            }

            @Override
            public void onLoginFail() {

                mHandler.post(new Runnable() {
                    @Override
                    public void run() {

                        mLoginView.hideProgressBar();
                        mLoginView.loginFail();
                    }
                });
            }
        });
    }

    /**
     * 用户Clear
     */
    public void clear(){
        mLoginView.clearUserName();
        mLoginView.clearPassword();
    }
}
