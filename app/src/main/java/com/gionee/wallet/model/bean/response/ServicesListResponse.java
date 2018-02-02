package com.gionee.wallet.model.bean.response;

import com.gionee.wallet.core.base.bean.response.BaseResponseBean;
import com.gionee.wallet.core.utils.CoreCommonUtils;
import com.gionee.wallet.core.base.bean.response.BaseResponseForRequestByHead;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;
/**
 * Created by jeker on 2018/1/2
 *
 */
public class ServicesListResponse extends BaseResponseForRequestByHead implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private ServicesListResponseBody body = new ServicesListResponseBody();

    public ServicesListResponseBody getBody() {
        return body;
    }

    public void setBody(ServicesListResponseBody body) {
        this.body = body;
    }

    public static class ServicesListResponseBody extends BaseResponseBean implements Serializable {
        /**
         *
         */
        private static final long serialVersionUID = 1L;
        private List<ServicesListResponseBodyList> list;
        private String version;
        private String total;

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

        public List<ServicesListResponseBodyList> getList() {
            return list;
        }

        public void setList(List<ServicesListResponseBodyList> list) {
            this.list = list;
        }

        public static class ServicesListResponseBodyList extends BaseResponseBean implements Serializable {
            /**
             *
             */
            private static final long serialVersionUID = 1L;
            @SerializedName("service_id")
            private String serviceId;
            @SerializedName("service_name")
            private String serviceName;
            @SerializedName("service_desc")
            private String serviceDesc;
            @SerializedName("service_type")
            private String serviceType;

            // ***********************
            @SerializedName("service_icon_url")
            private String serviceIconUrl;
            @SerializedName("service_sub_icon_url")
            private String serviceSubIconUrl;
            @SerializedName("is_need_login_account")
            private String isNeedLoginAccount;
            @SerializedName("is_h5")
            private String isH5;

            // ******************
            @SerializedName("client_version")
            private String clientVersion;
            @SerializedName("click_action")
            private String clickAction;
            @SerializedName("action_type")
            private String actionType;
            @SerializedName("click_action_package_name")
            private String clickActionPackageName;

            // ******************
            @SerializedName("click_action_class_name")
            private String clickActionClassName;
            private String uri;
            @SerializedName("action_param")
            private List<ServicesListResponseBodyListActionParam> actionParam;
            private String provider;// 表示业务类型

            // ********************
            private ServicesListResponseBodyShareInfo shareToInfo;// 分享信息
            private String pushTitle;// push 消息标题
            private String pushContent;// 内容
            private String category;// 业务分类1：话费；2“一样夺宝

            public String getCategory() {
                return category;
            }

            public void setCategory(String category) {
                this.category = category;
            }

            public ServicesListResponseBodyShareInfo getShareToInfo() {
                if (CoreCommonUtils.isNull(shareToInfo)) {
                    shareToInfo = new ServicesListResponseBodyShareInfo();
                }
                return shareToInfo;
            }

            public void setShareToInfo(ServicesListResponseBodyShareInfo shareToInfo) {
                this.shareToInfo = shareToInfo;
            }

            public String getClickActionClassName() {
                return clickActionClassName;
            }

            public void setClickActionClassName(String clickActionClassName) {
                this.clickActionClassName = clickActionClassName;
            }

            public String getActionType() {
                return actionType;
            }

            public void setActionType(String actionType) {
                this.actionType = actionType;
            }

            public String getClickActionPackageName() {
                return clickActionPackageName;
            }

            public void setClickActionPackageName(String clickActionPackageName) {
                this.clickActionPackageName = clickActionPackageName;
            }

            public String getUri() {
                return uri;
            }

            public void setUri(String uri) {
                this.uri = uri;
            }

            public static class ServicesListResponseBodyShareInfo extends BaseResponseBean
                    implements Serializable {
                /**
                 *
                 */
                private static final long serialVersionUID = 1L;
                private String shareContent;
                private String shareUrl;

                public String getShareContent() {
                    return shareContent;
                }

                public void setShareContent(String shareContent) {
                    this.shareContent = shareContent;
                }

                public String getShareUrl() {
                    return shareUrl;
                }

                public void setShareUrl(String shareUrl) {
                    this.shareUrl = shareUrl;
                }
            }

            public String getServiceId() {
                return serviceId;
            }

            public void setServiceId(String serviceId) {
                this.serviceId = serviceId;
            }

            public String getServiceName() {
                return serviceName;
            }

            public void setServiceName(String serviceName) {
                this.serviceName = serviceName;
            }

            public String getServiceDesc() {
                return serviceDesc;
            }

            public void setServiceDesc(String serviceDesc) {
                this.serviceDesc = serviceDesc;
            }

            public String getServiceIconUrl() {
                return serviceIconUrl;
            }

            public void setServiceIconUrl(String serviceIconUrl) {
                this.serviceIconUrl = serviceIconUrl;
            }

            public String getIsNeedLoginAccount() {
                return isNeedLoginAccount;
            }

            public void setIsNeedLoginAccount(String isNeedLoginAccount) {
                this.isNeedLoginAccount = isNeedLoginAccount;
            }

            public String getIsH5() {
                return isH5;
            }

            public void setIsH5(String isH5) {
                this.isH5 = isH5;
            }

            public String getClientVersion() {
                return clientVersion;
            }

            public void setClientVersion(String clientVersion) {
                this.clientVersion = clientVersion;
            }

            public String getClickAction() {
                return clickAction;
            }

            public void setClickAction(String clickAction) {
                this.clickAction = clickAction;
            }

            public List<ServicesListResponseBodyListActionParam> getActionParam() {
                return actionParam;
            }

            public void setActionParam(List<ServicesListResponseBodyListActionParam> actionParam) {
                this.actionParam = actionParam;
            }

            public String getServiceSubIconUrl() {
                return serviceSubIconUrl;
            }

            public void setServiceSubIconUrl(String serviceSubIconUrl) {
                this.serviceSubIconUrl = serviceSubIconUrl;
            }

            public String getProvider() {
                return provider;
            }

            public void setProvider(String provider) {
                this.provider = provider;
            }

            public static class ServicesListResponseBodyListActionParam extends BaseResponseBean
                    implements Serializable {
                /**
                 *
                 */
                private static final long serialVersionUID = 1L;
                @SerializedName("param_type")
                private String paramType;
                @SerializedName("param_value")
                private String paramValue;
                @SerializedName("param_key")
                private String paramKey;

                public String getParamKey() {
                    return paramKey;
                }

                public void setParamKey(String paramKey) {
                    this.paramKey = paramKey;
                }

                public String getParamType() {
                    return paramType;
                }

                public void setParamType(String paramType) {
                    this.paramType = paramType;
                }

                public String getParamValue() {
                    return paramValue;
                }

                public void setParamValue(String paramValue) {
                    this.paramValue = paramValue;
                }
            }

            public String getPushTitle() {
                return pushTitle;
            }

            public void setPushTitle(String pushTitle) {
                this.pushTitle = pushTitle;
            }

            public String getPushContent() {
                return pushContent;
            }

            public void setPushContent(String pushContent) {
                this.pushContent = pushContent;
            }

            public String getServiceType() {
                return serviceType;
            }

            public void setServiceType(String serviceType) {
                this.serviceType = serviceType;
            }

            // 最热抢宝
            private Lottery lottery = new Lottery();

            public Lottery getLottery() {
                return lottery;
            }

            public void setLottery(Lottery lottery) {
                this.lottery = lottery;
            }

            public static class Lottery extends BaseResponseBean implements Serializable {
                private static final long serialVersionUID = 1L;
                // **********************************
                // 活动状态
                private String status;
                // 总共需要参与的人数
                private String totalCnt;
                // 已参与人数
                private String joinCnt;
                // 活动编码
                private String activityNo;
                // 产品ID
                private String productId;

                public String getActivityNo() {
                    return activityNo;
                }

                public void setActivityNo(String activityNo) {
                    this.activityNo = activityNo;
                }

                public String getProductId() {
                    return productId;
                }

                public void setProductId(String productId) {
                    this.productId = productId;
                }

                public String getStatus() {
                    return status;
                }

                public void setStatus(String status) {
                    this.status = status;
                }

                public String getTotalCnt() {
                    return totalCnt;
                }

                public void setTotalCnt(String totalCnt) {
                    this.totalCnt = totalCnt;
                }

                public String getJoinCnt() {
                    return joinCnt;
                }

                public void setJoinCnt(String joinCnt) {
                    this.joinCnt = joinCnt;
                }

            }
        }

    }

}
