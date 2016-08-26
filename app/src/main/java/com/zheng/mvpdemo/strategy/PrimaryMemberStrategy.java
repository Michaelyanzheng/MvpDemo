package com.zheng.mvpdemo.strategy;

/**
 * Created by Administrator on 2016/8/26.
 */
public class PrimaryMemberStrategy implements MemberStrategy{

    @Override
    public double calcPrice(double price) {
        return price;
    }
}
