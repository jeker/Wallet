package com.gionee.wallet.core.utils;

import android.Manifest;
import android.app.Service;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jeker on 2018/1/2
 */

public class IMEIUtil {

    // 手机系统属性集合
    private static final List<String> sPropList = new ArrayList<>();
    // 7523A03验证，用了深研的数据
    // GBL7553A02验证，用了深研的数据
    // BJ_G1602验证，用了深研的数据
    static {
        // 北研项目
        sPropList.add("persist.sys.imei_for_y3");
        sPropList.add("persist.sys.imei1_for_y3");
        sPropList.add("persist.sys.meid_for_y3");
        // 深研项目
        sPropList.add("persist.radio.imei");
        sPropList.add("persist.radio.imei1");
        sPropList.add("persist.radio.meid");
    }
    public static final String DEFAULT_VALUE = "";
    // 手机没有写IMEI的时候，用这个默认值
    public static final String DEFAULT_IMEI = "00000000000000";
    private static String sIMEI = DEFAULT_VALUE;

    /**
     * 获取手机IMEI号
     * 
     * @param context
     * @return
     */
    public static String getIMEI(final Context context) {
        // 上次获取过了，直接返回
        if (!DEFAULT_VALUE.equals(sIMEI)) {
            return sIMEI;
        }
        synchronized (IMEIUtil.class) {
            if (!DEFAULT_VALUE.equals(sIMEI)) {// NOSONAR
                return sIMEI;// NOSONAR
            }
            for (String prop : sPropList) {
                String value = getSystemProp(prop);
                // System.out.println("prop=" + prop + ",value=" + value);
                if (TextUtils.isEmpty(value)) {
                    continue;
                }
                sIMEI = value;
                return sIMEI;
            }
            // 以前非属性值项目imei的获取
            String deviceId = getDeviceId(context);
            if (TextUtils.isEmpty(deviceId)) {
                return DEFAULT_IMEI;
            }

            sIMEI = deviceId;
            return sIMEI;
        }
    }

    private static String getSystemProp(String key) {
        try {
            Class<?> c = Class.forName("android.os.SystemProperties");
            Method method = c.getMethod("get", String.class, String.class);
            return (String) method.invoke(null, key, DEFAULT_VALUE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return DEFAULT_VALUE;
    }

    /**
     * 获取IMEI，这个需要异步调用，否则可能导致anr
     */
    private static String getDeviceId(Context context) {
        try {
            if (!hasPermission(context, Manifest.permission.READ_PHONE_STATE)) {
                return DEFAULT_VALUE;
            }
            TelephonyManager telManage = (TelephonyManager) context
                    .getSystemService(Service.TELEPHONY_SERVICE);
            String deviceId = telManage.getDeviceId();
            if (TextUtils.isEmpty(deviceId)) {
                deviceId = DEFAULT_IMEI;
            }
            return deviceId;
        } catch (Exception e) {
            e.printStackTrace();
            return DEFAULT_VALUE;
        }
    }

    /**
     * 这个需要异步调用，否则可能导致anr
     *
     * @param context
     * @param permission
     * @return
     */
    private static boolean hasPermission(Context context, String permission) {
        try {
            return context.checkPermission(permission, Binder.getCallingPid(),
                    Binder.getCallingUid()) == PackageManager.PERMISSION_GRANTED;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
