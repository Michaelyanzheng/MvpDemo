package com.zheng.mvpdemo.mode;

/**
 * Created by Administrator on 2016/8/26.
 */
public class UserLogin implements IUserLogin {

    @Override
    public void login(final String userName, final String password, final ILogin iLogin) {

        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (userName.equals("zheng") && password.equals("123")){

                    iLogin.onLoginSuccess();

                }else {

                    iLogin.onLoginFail();
                }

            }
        }).start();
    }
}
