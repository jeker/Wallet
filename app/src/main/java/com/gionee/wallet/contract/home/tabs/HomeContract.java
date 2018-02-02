package com.gionee.wallet.contract.home.tabs;

import com.gionee.wallet.core.base.BasePresenter;
import com.gionee.wallet.core.base.IBaseActivity;
import com.gionee.wallet.core.base.IBaseModel;
import com.gionee.wallet.model.bean.reques.CarouselDiagramRequest;
import com.gionee.wallet.model.bean.reques.ServicesListRequest;
import com.gionee.wallet.model.bean.response.HomeFragmentDataListResponse;

import java.util.Map;

import io.reactivex.Observable;

/**
 * Created by jeker on 17-12-19.
 *
 * 首页接口
 *
 */

public interface HomeContract {

//Presenter
    abstract class IHomePresenter extends BasePresenter<IHomeModel, IHomeView> {

        /**
         * 加载轮播图
         */
        public abstract void queryCarouselDiagram();


    }

    // Model
    interface IHomeModel extends IBaseModel {

        //合并加载home 数据（轮播图+ serverlist）
        Observable<HomeFragmentDataListResponse> queryHomeFragmentData(Map<String, String> options, CarouselDiagramRequest carouselDiagramRequest, ServicesListRequest servicesListRequest);

    }

    //view
    interface IHomeView extends IBaseActivity {

        void showData(HomeFragmentDataListResponse result);

    }

}
