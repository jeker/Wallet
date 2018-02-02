package com.gionee.wallet.model.bean.response;

import com.gionee.wallet.core.base.bean.response.BaseResponseBean;
import com.gionee.wallet.core.base.bean.response.BaseResponseForRequestByHead;

import java.io.Serializable;
import java.util.List;
/**
 * Created by jeker on 2018/1/2
 *
 */
public class CarouselDiagramResponse extends BaseResponseForRequestByHead implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private CarouselDiagramResponseBody body = new CarouselDiagramResponseBody();

    public CarouselDiagramResponseBody getBody() {
        return body;
    }

    public void setBody(CarouselDiagramResponseBody body) {
        this.body = body;
    }

    public static class CarouselDiagramResponseBody extends BaseResponseBean implements Serializable {

        private static final long serialVersionUID = 1L;
        private String version;
        private String total;
        private List<CarouselDiagramResponseBodyList> list;

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public List<CarouselDiagramResponseBodyList> getList() {
            return list;
        }

        public void setList(List<CarouselDiagramResponseBodyList> list) {
            this.list = list;
        }

        public static class CarouselDiagramResponseBodyList
                extends ServicesListResponse.ServicesListResponseBody.ServicesListResponseBodyList
                implements Serializable {

            private static final long serialVersionUID = 1L;

        }
    }

}
