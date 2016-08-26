package com.zheng.mvpdemo.view;

import com.zheng.mvpdemo.mode.UserBean;

/**
 * Created by Administrator on 2016/8/26.
 */
public interface ILoginView {

    String getUserName();

    String getPassword();

    void loginSuccessToMainActivity(UserBean userBean);

    void loginFail();

    void clearUserName();

    void clearPassword();

    void showProgressBar();

    void hideProgressBar();
}
