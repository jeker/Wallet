package com.gionee.wallet.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;

import com.gionee.wallet.R;
import com.gionee.wallet.contract.home.tabs.HomeContract;
import com.gionee.wallet.core.base.BasePresenter;
import com.gionee.wallet.core.base.fragment.BaseMVPCompatFragment;
import com.gionee.wallet.model.bean.response.HomeFragmentDataListResponse;
import com.gionee.wallet.presenter.home.HomePresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by jeker on 2018/1/8.
 * <p>
 */

public class PersonalFragment extends BaseMVPCompatFragment<HomeContract.IHomePresenter, HomeContract.IHomeModel> implements HomeContract.IHomeView {


    @BindView(R.id.data_tv)
    TextView textView;

    private List<Fragment> fragments;

    public static PersonalFragment newInstance() {
        Bundle args = new Bundle();
        PersonalFragment fragment = new PersonalFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        fragments = new ArrayList<>();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        mPresenter.queryCarouselDiagram();
    }

    @Override
    public int getLayoutId() {
        return R.layout.personal_fragment_tab;
    }

    @Override
    public void initUI(View view, @Nullable Bundle savedInstanceState) {

    }

    @NonNull
    @Override
    public BasePresenter initPresenter() {
        return HomePresenter.newInstance();
    }

    @Override
    public void showData(HomeFragmentDataListResponse result) {
      //  textView.setText(str);
    }

}
