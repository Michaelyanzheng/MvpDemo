package com.zheng.mvpdemo.proxy;

import android.util.Log;

/**
 * Created by Administrator on 2016/8/26.
 */
public class RealObject extends AbstractObject{

    @Override
    public void operation() {

        Log.e("zheng", "RealObject operation");
    }
}
