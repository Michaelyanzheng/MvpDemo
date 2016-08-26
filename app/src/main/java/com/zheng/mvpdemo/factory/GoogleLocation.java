package com.zheng.mvpdemo.factory;

import android.util.Log;

/**
 * Created by Administrator on 2016/8/26.
 */
public class GoogleLocation implements Location {

    @Override
    public void getPosition() {

        Log.e("zheng", "Google position");

    }
}
