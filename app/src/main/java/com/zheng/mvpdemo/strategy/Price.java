package com.zheng.mvpdemo.strategy;

/**
 * Created by Administrator on 2016/8/26.
 */
public class Price {

    private MemberStrategy mMemberStrategy;

    public Price(MemberStrategy memberStrategy){
        this.mMemberStrategy = memberStrategy;
    }

    public double quote(double price){
        return mMemberStrategy.calcPrice(price);
    }
}
