package com.gionee.wallet.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.TextView;

import com.gionee.wallet.R;
import com.gionee.wallet.contract.home.tabs.HomeContract;
import com.gionee.wallet.core.base.BasePresenter;
import com.gionee.wallet.core.base.activity.BaseMVPCompatActivity;
import com.gionee.wallet.model.bean.response.HomeFragmentDataListResponse;
import com.gionee.wallet.presenter.home.HomePresenter;

public class HomeActivity extends BaseMVPCompatActivity<HomeContract.IHomePresenter, HomeContract.IHomeModel> implements HomeContract.IHomeView {

   // @BindView(R.id.data_tv)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @NonNull
    @Override
    public BasePresenter initPresenter() {
        return HomePresenter.newInstance();
    }

    @Override
    protected void initData() {
        super.initData();
        System.out.print("--jeker---initData-");
        mPresenter.queryCarouselDiagram();
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    public void showData(HomeFragmentDataListResponse result) {
//        textView=(TextView) findViewById(R.id.data_tv);
//        textView.setText(str);
    }
}
