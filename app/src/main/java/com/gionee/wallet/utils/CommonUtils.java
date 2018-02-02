package com.gionee.wallet.utils;

import android.content.Context;

import com.gionee.wallet.core.global.GlobalApplication;
import com.gionee.wallet.core.utils.CoreCommonUtils;
import com.gionee.wallet.core.utils.UA;

import java.util.HashMap;
import java.util.Map;


public class CommonUtils extends CoreCommonUtils {

    private static final String TAG = "CommonUtils.class";

    private  static Map<String, String> options ;

    /**
     * 获取上下文对象
     *
     * @return 上下文对象
     */
    public static Context getContext() {
        return GlobalApplication.getContext();
    }


    public  static Map<String ,String>  getRequestOptions(){

        if (options!=null){
            return options;
        }
         options  = new HashMap<>();

        // options.put("gsp", CommonUtils.getVersionName(CommonUtils.getContext()));
        options.put("gsp", "5.0.0.bc");
        options.put("model", UA.encode(CommonUtils.getModel()));
        options.put("androidVersion", CommonUtils.getAndroidVersion());
        options.put("romVersion", CommonUtils.getRomVersion());

        String imei = CommonUtils.getIMEINumber(CommonUtils.getContext());
        if (CommonUtils.isNotNull(imei)) {
            options.put("imei", UA.encode(imei));
        }
        String ua = CommonUtils.getUAString(imei, CommonUtils.getContext()).replace(" ", "");
        if (CommonUtils.isNotNull(ua)) {
            options.put("ua", ua);
        }

        return options;
    }



    public static boolean isHomePageTopService(String serviceType) {
        return "04".equals(serviceType);
    }

    public static boolean isHomePageBottomService(String serviceType) {
        return "05".equals(serviceType);
    }

}

