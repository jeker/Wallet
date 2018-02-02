package com.gionee.wallet.model.bean.response;

import java.util.List;

/**
 * jeker HomeFragmentBean
 */

public class HomeFragmentBean {
    private List<CarouselDiagramResponse.CarouselDiagramResponseBody.CarouselDiagramResponseBodyList> bannerList;// 轮播图数据源
    private List<ServiceBean> serviceBeanList;

    public HomeFragmentBean(
            List<CarouselDiagramResponse.CarouselDiagramResponseBody.CarouselDiagramResponseBodyList> bannerList,
            List<ServiceBean> serviceBeanList) {
        this.bannerList = bannerList;
        this.serviceBeanList = serviceBeanList;
    }

    public List<CarouselDiagramResponse.CarouselDiagramResponseBody.CarouselDiagramResponseBodyList> getBannerList() {
        return bannerList;
    }

    public List<ServiceBean> getServiceBeanList() {
        return serviceBeanList;
    }

    public static class ServiceBean {
        /** 头部 recommend */
        protected List<ServicesListResponse.ServicesListResponseBody.ServicesListResponseBodyList> topList;
        /** sever list */
        private List<ServicesListResponse.ServicesListResponseBody.ServicesListResponseBodyList> serverList;
        private int type = 0;

        public ServiceBean(
                List<ServicesListResponse.ServicesListResponseBody.ServicesListResponseBodyList> topList,
                List<ServicesListResponse.ServicesListResponseBody.ServicesListResponseBodyList> serverList,
                int type) {
            this.topList = topList;
            this.serverList = serverList;
            this.type = type;
        }

        public List<ServicesListResponse.ServicesListResponseBody.ServicesListResponseBodyList> getTopList() {
            return topList;
        }

        public List<ServicesListResponse.ServicesListResponseBody.ServicesListResponseBodyList> getServerList() {
            return serverList;
        }

        public int getType() {
            return type;
        }
    }
}
