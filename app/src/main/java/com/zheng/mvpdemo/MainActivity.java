package com.zheng.mvpdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.zheng.mvpdemo.factory.Location;
import com.zheng.mvpdemo.factory.LocationFactory;
import com.zheng.mvpdemo.mode.UserBean;
import com.zheng.mvpdemo.presenter.UserLoginPresenter;
import com.zheng.mvpdemo.proxy.AbstractObject;
import com.zheng.mvpdemo.proxy.ProxyObject;
import com.zheng.mvpdemo.singleton.Singleton;
import com.zheng.mvpdemo.strategy.AdvancedMemberStrategy;
import com.zheng.mvpdemo.strategy.MemberStrategy;
import com.zheng.mvpdemo.strategy.Price;
import com.zheng.mvpdemo.view.ILoginView;

public class MainActivity extends AppCompatActivity implements ILoginView, View.OnClickListener
{

    EditText mEtUsername;
    EditText mEtPassword;
    Button mBtnLogin;
    Button mBtnClear;
    ProgressBar mProgressBar;

    private UserLoginPresenter mUserLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e("zheng", "代理 Proxy");
        AbstractObject abstractObject = new ProxyObject();
        abstractObject.operation();

        Log.e("zheng", "策略 strategy");
        MemberStrategy memberStrategy = new AdvancedMemberStrategy();
        Price price = new Price(memberStrategy);
        double quote = price.quote(100);

        Log.e("zheng", "工厂 factory");
        Location location = new LocationFactory().getInstance("google");
        location.getPosition();

        Log.e("zheng", "单例 singleton");
        Singleton singleton = Singleton.getInstance();
        singleton.doSomething();




        mEtUsername = (EditText) findViewById(R.id.et_username);
        mEtPassword = (EditText) findViewById(R.id.et_password);
        mBtnLogin = (Button) findViewById(R.id.btn_login);
        mBtnClear = (Button) findViewById(R.id.btn_clear);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);

        mBtnLogin.setOnClickListener(this);
        mBtnClear.setOnClickListener(this);

        mUserLoginPresenter = new UserLoginPresenter(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.btn_login:


                mUserLoginPresenter.login();

                break;

            case R.id.btn_clear:

                mUserLoginPresenter.clear();

                break;
        }
    }

    @Override
    public String getUserName() {
        return mEtUsername.getText().toString();
    }

    @Override
    public String getPassword() {
        return mEtPassword.getText().toString();
    }

    @Override
    public void loginSuccessToMainActivity(UserBean userBean) {

        Toast.makeText(MainActivity.this, "loginSuccessToMainActivity", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginFail() {

        Toast.makeText(MainActivity.this, "loginFail", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clearUserName() {

        mEtUsername.setText("");

    }

    @Override
    public void clearPassword() {

        mEtPassword.setText("");

    }

    @Override
    public void showProgressBar() {

        mProgressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideProgressBar() {

        mProgressBar.setVisibility(View.GONE);
    }

}
