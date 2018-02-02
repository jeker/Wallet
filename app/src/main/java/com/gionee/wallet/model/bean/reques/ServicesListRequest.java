package com.gionee.wallet.model.bean.reques;

import com.gionee.wallet.model.bean.WalletRequest;
import com.gionee.wallet.utils.WalletConfig;

public class ServicesListRequest extends WalletRequest {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public ServicesListRequest() {
        super(WalletConfig.GET_SERVICES_LIST);
    }

}
