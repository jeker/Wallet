package com.gionee.wallet.model.bean.response;

import com.gionee.wallet.core.base.bean.response.BaseResponseForRequestByHead;

import java.io.Serializable;

/**
 * Created by jeker on 2018/1/2
 *
 */
public class HomeFragmentDataListResponse extends BaseResponseForRequestByHead implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private CarouselDiagramResponse carouselDiagramResponse;
    private ServicesListResponse servicesListResponse;



    public CarouselDiagramResponse getCarouselDiagramResponse() {
        return carouselDiagramResponse;
    }

    public void setCarouselDiagramResponse(CarouselDiagramResponse carouselDiagramResponse) {
        this.carouselDiagramResponse = carouselDiagramResponse;
    }

    public ServicesListResponse getServicesListResponse() {
        return servicesListResponse;
    }

    public void setServicesListResponse(ServicesListResponse servicesListResponse) {
        this.servicesListResponse = servicesListResponse;
    }
}
