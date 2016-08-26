package com.zheng.mvpdemo.factory;

/**
 * Created by Administrator on 2016/8/26.
 */
public class LocationFactory {

    public static Location getInstance(String type){

        if (type.equals("baidu")){

            return new BaiduLocation();

        }else {

            return new GoogleLocation();
        }
    }
}
