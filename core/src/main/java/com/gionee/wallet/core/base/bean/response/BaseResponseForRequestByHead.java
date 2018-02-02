package com.gionee.wallet.core.base.bean.response;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 *  Created by jeker on 2018/1/2
 * 针对BaseRequestParamterByHead请求类型的响应数据
 *
 */
public class BaseResponseForRequestByHead extends BaseResponseBean implements Serializable {

    private static final long serialVersionUID = 2002709124146120440L;

    @SerializedName("rsp_code")
    private String rspCode;
    @SerializedName("rsp_desc")
    private String rspDesc;
    @SerializedName("access_token")
    private String accessToken;
    @SerializedName("rcv_sys")
    private String rcvSys;
    @SerializedName("rcv_date")
    private String rcvDate;
    @SerializedName("rcv_trans_id")
    private String rcvTransId;
    @SerializedName("rcv_time")
    private String rcvTime;

//    public boolean hasSuccess() {
//        return EPayConfig.ResponseCode.STATUS_CODE_SUCCESS.equals(rspCode);
//    }

    public String getRspCode() {
        return rspCode;
    }

    public void setRspCode(String rspCode) {
        this.rspCode = rspCode;
        // 兼容一下支付的返回字段
        //setStatus(rspCode);
    }

    public String getRspDesc() {
        return rspDesc;
    }

    public void setRspDesc(String rspDesc) {
        this.rspDesc = rspDesc;
        // 兼容一下支付的返回字段
        //setDescription(rspDesc);
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRcvSys() {
        return rcvSys;
    }

    public void setRcvSys(String rcvSys) {
        this.rcvSys = rcvSys;
    }

    public String getRcvDate() {
        return rcvDate;
    }

    public void setRcvDate(String rcvDate) {
        this.rcvDate = rcvDate;
    }

    public String getRcvTransid() {
        return rcvTransId;
    }

    public void setRcvTransid(String rcvTransid) {
        this.rcvTransId = rcvTransid;
    }

    public String getRcvtime() {
        return rcvTime;
    }

    public void setRcvtime(String rcvtime) {
        this.rcvTime = rcvtime;
    }

}