package com.gionee.wallet.core.base.bean.request;

import com.gionee.wallet.core.utils.AppUtils;
import com.gionee.wallet.core.utils.CoreCommonUtils;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by jeker on 2018/1/2
 *
 * 带请求头基类
 */
public class BaseRequestParamterByHead extends BaseRequestBean implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * @param reqSys
     *            子系统编码
     */
    public BaseRequestParamterByHead(String reqSys) {
        this.reqSys = reqSys;
        reqChannel = "01";
        reqDate = CoreCommonUtils.getCustomDateTime("yyyyMMdd");
        reqTime = CoreCommonUtils.getCustomDateTime("yyyyMMddHHmmsss");
        imei = CoreCommonUtils.getIMEINumber(AppUtils.getContext());
        version = CoreCommonUtils.getVersionName(AppUtils.getContext());
        ua = CoreCommonUtils.getUAString(getImei(), AppUtils.getContext()).replace(" ", "");
        model = CoreCommonUtils.getModel();
        androidVersion = CoreCommonUtils.getAndroidVersion();
        romVersion = CoreCommonUtils.getRomVersion();
        packageName = AppUtils.getContext().getPackageName();
    }


    @SerializedName("trans_code")
    private String transCode;

    @SerializedName("req_sys")
    private String reqSys;

    @SerializedName("req_channel")
    private String reqChannel;

    @SerializedName("req_date")
    private String reqDate;

    @SerializedName("req_time")
    private String reqTime;

    private String imei;

    private String version;

    private String ua;
    // 新增字段备用
    private String model;

    @SerializedName("android_version")
    private String androidVersion;

    @SerializedName("rom_version")
    private String romVersion;

    @SerializedName("package_name")
    private String packageName;

    private boolean cache;

    public String getTransCode() {
        return transCode;
    }

    public String getReqSys() {
        return reqSys;
    }

    public String getReqChannel() {
        return reqChannel;
    }

    public String getReqDate() {
        return reqDate;
    }

    public String getReqTime() {
        return reqTime;
    }

    public String getImei() {

        return imei;
    }

    public String getVersion() {
        return version;
    }

    public String getUa() {

        return ua;
    }

    public boolean isCache() {
        return cache;
    }

    protected void setCache(boolean cache) {
        this.cache = cache;
    }

    public String getModel() {
        return model;
    }

    public String getAndroidVersion() {
        return androidVersion;
    }

    public String getRomVersion() {
        return romVersion;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public void setTransCode(String transCode) {
        this.transCode = transCode;
    }

}
