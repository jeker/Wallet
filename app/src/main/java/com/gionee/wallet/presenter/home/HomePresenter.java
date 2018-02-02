package com.gionee.wallet.presenter.home;

import com.gionee.wallet.contract.home.tabs.HomeContract;
import com.gionee.wallet.core.utils.LogUtils;
import com.gionee.wallet.model.bean.reques.CarouselDiagramRequest;
import com.gionee.wallet.model.bean.reques.ServicesListRequest;
import com.gionee.wallet.model.bean.response.CarouselDiagramResponse;
import com.gionee.wallet.model.bean.response.HomeFragmentDataListResponse;
import com.gionee.wallet.model.bean.response.ServicesListResponse;
import com.gionee.wallet.model.home.HomeModel;
import com.gionee.wallet.utils.CommonUtils;

import java.util.List;
import java.util.Map;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Created by jeker on 17-12-20.
 */

public class HomePresenter extends HomeContract.IHomePresenter {


    public static HomePresenter newInstance() {
        return new HomePresenter();
    }

    @Override
    public HomeContract.IHomeModel getModel() {
        return HomeModel.newInstance();
    }

    @Override
    public void onStart() {

    }

    @Override
    public void queryCarouselDiagram() {

        Map<String, String> options  = CommonUtils.getRequestOptions();
        CarouselDiagramRequest carouselDiagramRequest =new CarouselDiagramRequest();
        ServicesListRequest servicesListRequest =new ServicesListRequest();

      //  传递参数
        Disposable disposable = mIModel.queryHomeFragmentData(options, carouselDiagramRequest,servicesListRequest)
                .subscribe(new Consumer<HomeFragmentDataListResponse>() {
                    @Override
                    public void accept(HomeFragmentDataListResponse result) throws Exception {
                        List<CarouselDiagramResponse.CarouselDiagramResponseBody.CarouselDiagramResponseBodyList> bodyList = result.getCarouselDiagramResponse().getBody().getList();
                        List<ServicesListResponse.ServicesListResponseBody.ServicesListResponseBodyList> ServicesListResponse_bodyList = result.getServicesListResponse().getBody().getList();

                        LogUtils.d("--------list-----"+bodyList);
                        LogUtils.d("--------ServicesListResponse_bodyList-----"+ServicesListResponse_bodyList);

                        if(mIView!=null){

                            mIView.showData(result);
                        }

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        LogUtils.d("--------list  网络问题-----");
                        System.out.print("--jeker---网络问题-");
                    }
                });
        mRxManager.register(disposable);
    }

}
