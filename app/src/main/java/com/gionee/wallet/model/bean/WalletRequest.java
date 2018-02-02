package com.gionee.wallet.model.bean;


import com.gionee.wallet.core.base.bean.request.BaseRequestParamterByHead;

import java.io.Serializable;
/**
 * Created by jeker on 2018/1/2
 *
 */
public class WalletRequest extends BaseRequestParamterByHead implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * @param transCode
     *            每个接口的交易码
     */
    public WalletRequest(String transCode) {
        super("0080");
        setTransCode(transCode);
    }

}
