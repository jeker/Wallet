package com.gionee.wallet.model.home;

import com.gionee.wallet.api.HomeApi;
import com.gionee.wallet.contract.home.tabs.HomeContract;
import com.gionee.wallet.core.netHelper.RetrofitCreateHelper;
import com.gionee.wallet.model.bean.reques.CarouselDiagramRequest;
import com.gionee.wallet.model.bean.reques.ServicesListRequest;
import com.gionee.wallet.model.bean.response.CarouselDiagramResponse;
import com.gionee.wallet.model.bean.response.HomeFragmentDataListResponse;
import com.gionee.wallet.model.bean.response.ServicesListResponse;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.BiFunction;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by jeker on 18-1-19.
 */

public class HomeModel implements HomeContract.IHomeModel {


    public static HomeModel newInstance() {
        return new HomeModel();
    }

    @Override
    public Observable<HomeFragmentDataListResponse> queryHomeFragmentData(Map<String, String> options, CarouselDiagramRequest request, ServicesListRequest servicesListRequest) {


        Observable<CarouselDiagramResponse> observable1 = RetrofitCreateHelper.createApi(HomeApi.class, HomeApi.HOST).queryCarouselDiagram(options, request).subscribeOn(Schedulers.io());
        Observable<ServicesListResponse> observable2 = RetrofitCreateHelper.createApi(HomeApi.class, HomeApi.HOST).queryHomeFragmentServicesList(options, servicesListRequest).subscribeOn(Schedulers.io());

        // 合并数据后返回
        return Observable.zip(observable1, observable2, new BiFunction<CarouselDiagramResponse, ServicesListResponse, HomeFragmentDataListResponse>() {

            @Override
            public HomeFragmentDataListResponse apply(CarouselDiagramResponse carouselDiagramResponse, ServicesListResponse servicesListResponse) throws Exception {

                HomeFragmentDataListResponse homeFragmentDataListResponse = new HomeFragmentDataListResponse();

                homeFragmentDataListResponse.setCarouselDiagramResponse(carouselDiagramResponse);
                homeFragmentDataListResponse.setServicesListResponse(servicesListResponse);

                return homeFragmentDataListResponse;
            }
        }).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
//                .subscribe(new Consumer<CarouselDiagramResponse>() {
//                    @Override
//                    public void accept(CarouselDiagramResponse carouselDiagramResponse) throws Exception {
//
//                        LogUtils.d(carouselDiagramResponse.getBody().getTotal());
//
//                    }
//                }, new Consumer<Throwable>() {
//                    @Override
//                    public void accept(Throwable throwable) throws Exception {
//
//                    }
//                });

//        return RetrofitCreateHelper.createApi(HomeApi.class, HomeApi.HOST).queryCarouselDiagram(options,request)
//                .compose(RxHelper.<CarouselDiagramResponse>rxSchedulerHelper());
    }
}
