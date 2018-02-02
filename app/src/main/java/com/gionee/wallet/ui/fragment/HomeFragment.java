package com.gionee.wallet.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.gionee.wallet.R;
import com.gionee.wallet.adapter.HomeFragmentAdapter;
import com.gionee.wallet.adapter.HomeTopWrapper;
import com.gionee.wallet.contract.home.tabs.HomeContract;
import com.gionee.wallet.core.base.BasePresenter;
import com.gionee.wallet.core.base.fragment.BaseMVPCompatFragment;
import com.gionee.wallet.core.utils.LogUtils;
import com.gionee.wallet.core.utils.ToastUtils;
import com.gionee.wallet.model.bean.response.CarouselDiagramResponse;
import com.gionee.wallet.model.bean.response.HomeFragmentBean;
import com.gionee.wallet.model.bean.response.HomeFragmentDataListResponse;
import com.gionee.wallet.model.bean.response.ServicesListResponse;
import com.gionee.wallet.presenter.home.HomePresenter;
import com.gionee.wallet.utils.CommonUtils;
import com.zhxu.recyclerview.pullrefresh.PullToRefreshView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by jeker on 2018/1/8.
 * <p>
 */

public class HomeFragment extends BaseMVPCompatFragment<HomeContract.IHomePresenter, HomeContract.IHomeModel>
        implements HomeContract.IHomeView {

//    @BindView(R.id.data_tv)
//    TextView textView;

    @BindView(R.id.rv_recommend)
    RecyclerView mRecyclerView;
    @BindView(R.id.ptr)
    PullToRefreshView mPullView;

    private HomeFragmentAdapter adapter;
    private HomeTopWrapper mHomeTopWrapper;

    private List<Fragment> fragments;

    public static HomeFragment newInstance() {
        Bundle args = new Bundle();
        HomeFragment fragment = new HomeFragment();
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
        return R.layout.home_fragment_tab;
    }

    @Override
    public void initUI(View view, @Nullable Bundle savedInstanceState) {

    }

    @NonNull
    @Override
    public BasePresenter initPresenter() {
        return HomePresenter.newInstance();
    }

    /**
     * 加载到数据
     * 
     * @param result
     */
    @Override
    public void showData(HomeFragmentDataListResponse result) {
        // textView.setText(str);

        LogUtils.d("--jeker showData---------" + result);

        List<CarouselDiagramResponse.CarouselDiagramResponseBody.CarouselDiagramResponseBodyList> bannerList = result
                .getCarouselDiagramResponse().getBody().getList();

        List<ServicesListResponse.ServicesListResponseBody.ServicesListResponseBodyList> bodyList = result
                .getServicesListResponse().getBody().getList();
        List<ServicesListResponse.ServicesListResponseBody.ServicesListResponseBodyList> newTopServicesList = new ArrayList<ServicesListResponse.ServicesListResponseBody.ServicesListResponseBodyList>();
        List<ServicesListResponse.ServicesListResponseBody.ServicesListResponseBodyList> newBottomServicesList = new ArrayList<ServicesListResponse.ServicesListResponseBody.ServicesListResponseBodyList>();

        for (ServicesListResponse.ServicesListResponseBody.ServicesListResponseBodyList temp : bodyList) {
            String serviceType = temp.getServiceType();
            if (CommonUtils.isHomePageTopService(serviceType)) {
                newTopServicesList.add(temp);
            } else if (CommonUtils.isHomePageBottomService(serviceType)) {
                newBottomServicesList.add(temp);
                newBottomServicesList.add(temp);
            }
        }

        LogUtils.d("--jeker newTopServicesList---------" + newTopServicesList);
        LogUtils.d("--jeker mServiceBeanBottom---------" + newBottomServicesList);

        List<HomeFragmentBean.ServiceBean> serviceBeanList = new ArrayList<>();

        if(newTopServicesList.size()>0){
        HomeFragmentBean.ServiceBean mServiceBeanTop = new HomeFragmentBean.ServiceBean(newTopServicesList,
                null, 0);
        serviceBeanList.add(mServiceBeanTop);
        }

        if(newBottomServicesList.size()>0) {
            HomeFragmentBean.ServiceBean mServiceBeanBottom = new HomeFragmentBean.ServiceBean(null,
                    newBottomServicesList, 1);
            serviceBeanList.add(mServiceBeanBottom);
        }

        // --- test ---
//        serviceBeanList.add(mServiceBeanTop);
//        serviceBeanList.add(mServiceBeanBottom);

//        serviceBeanList.add(mServiceBeanTop);
//        serviceBeanList.add(mServiceBeanBottom);
        // --- test ---
        LogUtils.d("--jeker mServiceBeanBottom---------" + serviceBeanList);

        // 转换数据
        HomeFragmentBean mHomeFragmentBean = new HomeFragmentBean(bannerList, serviceBeanList);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new HomeFragmentAdapter(CommonUtils.getContext(), mHomeFragmentBean.getServiceBeanList());
        mHomeTopWrapper = new HomeTopWrapper(CommonUtils.getContext(), adapter);//为RecycleView添加头部(添加头部轮播图)

        List<String> list = new ArrayList<>();

        for (CarouselDiagramResponse.CarouselDiagramResponseBody.CarouselDiagramResponseBodyList temp : mHomeFragmentBean.getBannerList())
        {
            list.add(temp.getServiceIconUrl());
        }
        mHomeTopWrapper.setData(list);

        LogUtils.d("---轮播图----list-------"+list);

        mRecyclerView.setAdapter(mHomeTopWrapper);
        mPullView.setPullDownEnable(false);
        mPullView.setPullUpEnable(false);
//        mPullView.setListener(new PullToRefreshView.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//
//            }
//
//            @Override
//            public void onLoadMore() {
//            //    mPresenter.getRecommendFragmentMoreData(mBaseActivity);
//            }
//        });
        adapter.setOnItemClickListenter(new HomeFragmentAdapter.OnItemClickListenter() {
            @Override
            public void goDetailActivity(String packageName) {
                ToastUtils.showToast("点击了");
//                Intent intent = new Intent(mBaseActivity, AppDetailActivity.class);
//                intent.putExtra("packageName", packageName);
//                mBaseActivity.startActivity(intent);
            }
        });

    }

}
