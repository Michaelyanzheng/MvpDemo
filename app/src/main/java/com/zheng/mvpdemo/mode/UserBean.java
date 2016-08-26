package com.zheng.mvpdemo.mode;

/**
 * Created by Administrator on 2016/8/26.
 */
public class UserBean {

    private String mUserName;
    private String mPassword;

    public UserBean() {
    }

    public UserBean(String userName, String password) {
        mUserName = userName;
        mPassword = password;
    }

    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String userName) {
        mUserName = userName;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }
}
