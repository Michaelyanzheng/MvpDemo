package com.zheng.mvpdemo.proxy;

/**
 * Created by Administrator on 2016/8/26.
 */
public class ProxyObject extends AbstractObject {

    private RealObject mRealObject;

    @Override
    public void operation() {

        mRealObject.operation();
    }
}
