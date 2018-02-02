package com.gionee.wallet.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.gionee.wallet.utils.HomeBannalController;
import com.zhxu.recyclerview.wrapper.HeaderAndFooterWrapper;

import java.util.List;

/**
 * 作者名 ： jeker
 * 功能   ：轮播图适配器 为RecycleView添加头部
 */

public class HomeTopWrapper extends HeaderAndFooterWrapper {

    private Context mContext;
    private HomeBannalController mController;//自定义轮播图
    public HomeTopWrapper(Context context, RecyclerView.Adapter adapter) {
        super(adapter);
        this.mContext=context;
        mController=new HomeBannalController(context);
        addHeaderView(mController.getContentView());
    }
    public void setData(List<String> urls){
        if (mController!=null){
            //为轮播图添加数据
            mController.setData(urls);
        }
    }
}
