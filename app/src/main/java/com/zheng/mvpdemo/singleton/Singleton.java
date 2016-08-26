package com.zheng.mvpdemo.singleton;

import android.util.Log;

/**
 * Created by Administrator on 2016/8/26.
 */
public class Singleton {

//    private static Singleton sSingleton;
//
//    private Singleton(){}
//
//    public static Singleton getIntance(){
//
//        if (sSingleton == null){
//            sSingleton = new Singleton();
//        }
//        return sSingleton;
//    }

    // Thread secure
    private static class SingletonHolder{
        public static Singleton sSingleton = new Singleton();
    }

    private Singleton(){}

    public static Singleton getInstance(){
        return SingletonHolder.sSingleton;
    }

    public void doSomething(){

        Log.e("zheng", "doSomething: ");
    }
}
