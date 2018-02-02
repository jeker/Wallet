package com.gionee.wallet.utils;


import com.gionee.wallet.core.utils.CommonConfig;

public class WalletConfig   extends CommonConfig {
    private static final String TAG = "WalletConfig.class";

    // 三个不同环境的配置
    public static final String BASE_RELEASE = "https://wallet.gionee.com/gionee-wallet/walletService.do";
    public static final String BASE_RELEASE_HTTP = "http://wallet.gionee.com:8088/gionee-wallet/walletService.do";
    public static final String BASE_TEST = "http://121.41.108.162:8008/gionee-wallet/walletService.do";
    private static String sBaseDev = "";// "http://18.8.10.24/pay/";

    public static String getBaseDev() {
        return sBaseDev;
    }

    public static void setBaseDev(String baseDev) {
        sBaseDev = "http://" + baseDev + "/gionee-wallet/walletService.do";
    }

    public final static String CREATE_ORDER = "010001";
    public final static String CREATE_WAP_ORDER = "010002";
    public final static String QUERY_NUMBER_ATTRIBUTION = "020002";
    public static final String QUERY_CONSUME_RECORD = "020003";
    // public static final String QUERY_CAROUSEL_DIAGRAM = "020005";
    public static final String QUERY_CAROUSEL_DIAGRAM = "020041";
    public static final String QUERY_GOLD_COIN = "020006";
    // 获取充值记录
    public static final String QUERY_RECHARGE_RECORD = "020009";
    // 获取成功的流量充值记录
    public static final String QUERY_FLOW_RECHARGE_RECORD = "020010";

    public static final String GET_BILL_RECHARGE_PACKAGE = "020013";

    // 4.0.0用新的编号
    // 1.这个接口返回的数据有3部分，首页的头部，底部和优惠页面的头部。
    public static final String GET_SERVICES_LIST = "020027";
    // 2.这个接口返回的数据有优惠页面的最热抢宝
    public static final String LOTTERY = "020028";
    // 3.这个接口返回的数据有优惠页面的最新活动
    public static final String LATEST_EVENTS = "020029";
    // 4.获取我的页面优惠券列表
    public static final String COUPONS = "020030";
    // 5.查询余额
    public static final String QUERY_COIN = "020031";

    // 6.查询个税汇率
    public static final String GET_PERSONAL_RATE = "020026";
    // 6.查询房贷汇率
    public static final String GET_HOUSE_RATE = "020023";
    // 6.查询夺宝产品信息
    public static final String GET_PRODUCT_INFO = "020032";
    // 查询启动页配置信息
    public static final String WELCOME_PAGE = "020039";
    // 查询手机流量赠送
    public static final String FLOW_RECORD = "020040";

    // A币充值
    public static final String RECHARGE_A_BI_SERVICEID = "00000087";
    // 流量
    public static final String RECHARGE_FLOW_SERVICEID = "00000092";
    // //A币充值
//    public static final String RECHARGE_A_BI_SERVICEID = "1001";
//    //流量
//    public static final String RECHARGE_FLOW_SERVICEID = "1002";
    // 流量充值
    public static final String RECHARGE_FLOW_SERVICE_TYPE_FLAG = "flow_package";
    // 话费充值
    public static final String BILL_FLOW_SERVICE_TYPE_FLAG = "bill";

    // 金立支付成功返回码
    public static final String GIONEE_PAY_SUCCESS = "9000";
    // 金立网页支付成功返回码
    public static final int GIONEE_WAP_PAY_SUCCESS = 9001;

    // 卡片未开通
    public static final String MY_CARD_IS_NOT_OPEN = "4";
    // 卡片已开通
    public static final String MY_CARD_IS_OPEN = "5";

    public static final String INTENT_EXTRA_KEY_SERVICE_ID = "service_id";
    public static final String INTENT_EXTRA_KEY_SERVICE_TYPE = "service_type";
    public static final String TITLE = "title";

    /**
     * 服务器返回码定义
     *
     * @author chenls
     */
    public static final class ResponseCode {
        public static final String STATUS_CODE_EXCEPTION = "-1";
        public static final String STATUS_CODE_SUCCESS = "0000";

        // 非广东省客户，暂时不支持流量充值
        public static final int NUMBER_ATTRIBUTION_NOT_SUPPORT = 3004;
        // access_token已失效
        public static final String ACCESS_TOKEN_FAILURE = "3005";
    }

    /**
     * start activity request code
     */
    public static final int MALLET_CUSTOM_DETAIL_REQUEST_CODE = 880;

    /**
     * startActivityForResult
     *
     * @author chenls
     */
    public static final class CustomResultCode {
        public final static int ACTION_PICK_RESULT_CODE = 10;
    }

    // 接口定义
    // 1
    private static String sWalletURL;

    public static String getWalletURL() {
        return sWalletURL;
    }

    public static void setWalletURL(String walletURL) {
        sWalletURL = walletURL;
    }

    private static final String WAP_PAY_URL = "http://pay.gionee.com/order/wap/easy/pay";
    private static final String WAP_PAY_TEST_URL = "http://test3.gionee.com/pay/order/wap/easy/pay";

    private static String sWapPayURL = WAP_PAY_TEST_URL;

    public static String getWapPayURL() {
        return sWapPayURL;
    }

    public static void setWapPayURL(String wapPayURL) {
        sWapPayURL = wapPayURL;
    }

    public static final String URL_CMB_APK_DOWNLOAD_TEST = "http://121.41.108.162:8008/wallet-pic/download/CMBMobileBank_Yst51.apk";
    public static final String URL_CMB_APK_DOWNLOAD_RELEASE = "https://wallet.gionee.com/wallet-pic/download/CMBMobileBank_Yst51.apk";
    private static String sCmbApkDownloadUrl = URL_CMB_APK_DOWNLOAD_RELEASE;

    public static String getsCmbApkDownloadUrl() {
        return sCmbApkDownloadUrl;
    }

    public static void setsCmbApkDownloadUrl(String sCmbApkDownloadUrl) {
        WalletConfig.sCmbApkDownloadUrl = sCmbApkDownloadUrl;
    }

    public static final String YJ_CHANNEL_ID = "Amigo_Play";

    public static final String WALLET_TEST_SP_NAME = "wallet_test";
    public static final String WALLET_PRO_SP_NAME = "wallet_pro";

    private static String sWalletSpName = WALLET_PRO_SP_NAME;

    public static String getsWalletSpName() {
        return sWalletSpName;
    }

    public static void setsWalletSpName(String sWalletSpName) {
        WalletConfig.sWalletSpName = sWalletSpName;
    }

    public final static class FAQDefine {
        public static final String FAQ_DEV_URL = "http://121.41.108.162:8008/gionee-wallet/jsp/faq/FAQ.html";
        public static final String FAQ_TEST_URL = "http://121.41.108.162:8008/gionee-wallet/jsp/faq/FAQ.html";
        public static final String FAQ_PRO_URL = "https://wallet.gionee.com/gionee-wallet/jsp/faq/FAQ.html";
        private static String sFaqUrl = FAQ_PRO_URL;

        public static String getsFaqUrl() {
            return sFaqUrl;
        }

    }

    public static void initServerEnviroment() {
//        try {
//            // 默认为正式地址
//            String tempPath = BASE_RELEASE;
//            sWalletSpName = WALLET_PRO_SP_NAME;
//            FAQDefine.sFaqUrl = FAQDefine.FAQ_PRO_URL;
//            setWapPayURL(WAP_PAY_URL);
//            sCmbApkDownloadUrl = URL_CMB_APK_DOWNLOAD_RELEASE;
//
//            if (CommonUtils.isFileExit(FLAG_DEV_ENVIRONMENT)) {
//                setBaseDev(getDevURL());
//                tempPath = getBaseDev();
//                sWalletSpName = WALLET_TEST_SP_NAME;
//                FAQDefine.sFaqUrl = FAQDefine.FAQ_DEV_URL;
//                setWapPayURL(WAP_PAY_TEST_URL);
//                sCmbApkDownloadUrl = URL_CMB_APK_DOWNLOAD_TEST;
//            } else if (CommonUtils.isFileExit(FLAG_TEST_ENVIRONMENT)) {
//                tempPath = BASE_TEST;
//                sWalletSpName = WALLET_TEST_SP_NAME;
//                FAQDefine.sFaqUrl = FAQDefine.FAQ_TEST_URL;
//                setWapPayURL(WAP_PAY_TEST_URL);
//                sCmbApkDownloadUrl = URL_CMB_APK_DOWNLOAD_TEST;
//            }
//
//            // 游戏大厅测试环境
//            if (CommonUtils.isFileExit(FLAG_GAME_TEST_ENVIRONMENT)) {
//                setGameTestEnvironment(true);
//            }
//            // 1
//            setWalletURL(tempPath);
//
//          //  LogUtils.d(TAG, LogUtils.getThreadName() + ",initServerEnviroment,sWalletURL=" + getWalletURL());
//
//        } catch (Exception e) {
//            LogUtils.e(TAG,e);
//            e.printStackTrace();
//        }
    }

    public static final String INTENT_EXTRA_CUSTOM_CHANNEL = "custom_channel";
    public static final String INTENT_EXTRA_KEY_SHARE_CONTENT = "share_content";
    public static final String INTENT_EXTRA_KEY_SHARE_URL = "share_url";
    public static final String INTENT_EXTRA_KEY_SHARE_MEDIA_URL = "share_media_url";
    public static final String INTENT_EXTRA_KEY_CATEGORY = "category";

    public static class ORDER_STATUS {
        /*
        0   取消
        1   待支付
        2   支付失败
        3   交易处理中（支付成功）
        4   交易成功
        5   退款中
        6   退款成功
        7   订单过期
        8   暂存订单
         */
        public static final int CANCEL = 0;
        public static final int WAIT_FOR_PAY = 1;
        public static final int FAILED = 2;
        public static final int HANDLING = 3;
        public static final int SUCCESS = 4;
        public static final int REFUNDING = 5;

        public static final int REFUND_SUCESSFUL = 6;
        public static final int ORDER_TIMEOUT = 7;
        public static final int TMP_ORDER = 8;
        public static final int UNKNOWN = -1;
    }

    public static class RquestCode {
        public static final int BASE_REQUEST_CODE = 20000;
        public static final int MYWALLET_MY_BILL_REQUEST_CODE = BASE_REQUEST_CODE + 1;
        public static final int REQUEST_CODE_WAP_PAY = BASE_REQUEST_CODE + 2;
        public static final int MYWALLET_NFC_REQUEST_CODE = BASE_REQUEST_CODE + 3;
        public static final int MYWALLET_FLOW_REQUEST_CODE = BASE_REQUEST_CODE + 4;
    }

    // wallet 新增
    public static final String ORDER_NO = "order_no";
    public static final String PAY_TYPE = "pay_type";
    public static final String PAYMENT = "payment";
    public static final String PROD_TITLE = "prod_title";
    public static final String PROD_NAME = "prod_name";
    public static final String PROD_TYPE = "prod_type";
    public static final String ORDER_TYPE = "order_type";
    public static final String DETAIL_URL = "detail_url";
    public static final String ORDER_SUBMIT_TIME = "order_submit_time";
    public static final String MERCHANT = "merchant";
    public static final String BUSI_SHOP_NAME = "busi_shop_name";
    public static final String INDEX = "index";
    public static final String IS_SELF_ORDER = "is_self_order";
    public static final String ORDER_PAY_INFO = "order_pay_info";
    public static final String STATUS_DESC = "status_desc";

    public static final int CONNECTION_TYPE_IDLE = 0;
    public static final int CONNECTION_TYPE_CMWAP = 1;
    public static final int CONNECTION_TYPE_CMNET = 2;
    public static final int CONNECTION_TYPE_WIFI = 3;

    public static final int MESSAGE_CHECK_RESULT_OK = 230;
    public static final int MESSAGE_CHECK_RESULT_NETWORK_ERROR = 231;
    public static final int MESSAGE_CHECK_RESULT_NO_UPDATE = 232;
    public static final int MESSAGE_START_DOWNLOAD = 233;
    public static final int MESSAGE_ERROR_NO_SPACE = 234;
    public static final int MESSAGE_ERROR_NO_CARD = 235;
    public static final int MESSAGE_DOWNLOAD_COMPLETE = 236;
    public static final int MESSAGE_NO_ENOUGH_SPACE = 237;
    public static final int MESSAGE_NO_SDCARD = 238;
    public static final int MESSAGE_NO_NEED_UPDATE = 239;
    public static final int MESSAGE_MESSAGE_DOWNLOAD_NETWORK_ERROR = 240;

    public static final boolean IS_UNIPAY = true;



    //---------------------------------------------

//    public static final String UTF_8 = "UTF-8";
//    public static final String DEFAULT_VALUE = "";
//
//    public static final int HUNDRED = 100;
//    public static final String PRECISION = "%.2f";
//    public static final String PRECISION_SERVER = "%.4f";

}
