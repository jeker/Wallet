package com.gionee.wallet.model.bean.reques;

import com.gionee.wallet.core.base.bean.request.BaseRequestBean;
import com.gionee.wallet.model.bean.WalletRequest;
import com.gionee.wallet.utils.WalletConfig;

import java.io.Serializable;

/**
 * Created by jeker on 2018/1/2
 *
 */
public class CarouselDiagramRequest extends WalletRequest {

    private static final long serialVersionUID = 1L;
    private CarouselDiagramRequestBody body = new CarouselDiagramRequestBody();

    public CarouselDiagramRequest() {
        super(WalletConfig.QUERY_CAROUSEL_DIAGRAM);
    }

    public CarouselDiagramRequestBody getBody() {
        return body;
    }

    public void setBody(CarouselDiagramRequestBody body) {
        this.body = body;
    }

    public static class CarouselDiagramRequestBody extends BaseRequestBean implements Serializable {

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        private String type = "02";

    }

}
