package com.gionee.wallet.core.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.gionee.wallet.core.base.ReflectionTools;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by jeker on 2018/1/2
 *
 */

public class CoreCommonUtils {

    private static final String TAG = "CoreCommonUtils.class";

    public static synchronized String getCustomDateTime(String template) {
        Date dt = new Date(System.currentTimeMillis());
        SimpleDateFormat fmt = new SimpleDateFormat(template, Locale.getDefault());
        return fmt.format(dt);
    }

    /**
     * 获取IMEI
     */

    public static String getIMEINumber(Context context) {
        String imei = IMEIUtil.getIMEI(context);
        // imei为多个0(1个或多个)，则为无效imei
        if (CoreCommonUtils.strToInteger(imei, -1) == 0) {
            return IMEIUtil.DEFAULT_VALUE;
        }
        return imei;
    }

    public static Integer strToInteger(String str, int def) {
        Integer value = def;
        try {
            value = Integer.parseInt(str);
        } catch (Exception e) {
        }

        return value;
    }

    public static String getVersionName(Context context) {
        String version = "";
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            version = packInfo.versionName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return version;
    }

    public static String getUAString(String imei, Context context) {
        String userAgent = "";
        // get custom UA
        if (imei != null && imei.length() > 0) {
            // gn平台获取方式
            try {
                Class<?> clazz = Class.forName("com.gionee.utils.ProductConfiguration");
                Method method = clazz.getMethod("getUAString", String.class);
                userAgent = (String) method.invoke(null, imei);
            } catch (Exception ex) {
                LogUtils.e(ex);
            }
            // amigo平台的获取方式
            // 说明，此处不能加非空判断，如果是amigo平台则获取到，否则不影响userAgent的返回值。
            // amigo平台上com.amigo.utils.ProductConfiguration和com.gionee.utils.ProductConfiguration获取到的getUAString不一样。
            // if (isNull(userAgent)) {
            try {
                Class<?> clazz = Class.forName("com.amigo.utils.ProductConfiguration");
                Method method = clazz.getMethod("getUAString", String.class);
                userAgent = (String) method.invoke(null, imei);
                LogUtils.d(TAG + "amigo平台获取方式");
            } catch (Exception ex) {
//                ex.printStackTrace();
                LogUtils.e(ex);
            }
            // }

            if (isNull(userAgent) && isNotNull(context)) {
                // get default UA
                try {
                    // api 19 之前
                    if (Build.VERSION.SDK_INT < 19) {
                        WebView webview = new WebView(context);
                        WebSettings settings = webview.getSettings();
                        userAgent = settings.getUserAgentString();
                    } else {
                        // api >=19
                        userAgent = WebSettings.getDefaultUserAgent(context);
                    }
                    LogUtils.d(TAG + "WebSettings获取方式");
                } catch (Exception ex) {
                    // ex.printStackTrace();
                    LogUtils.e(ex.getMessage());
                }
            }

            // 自定义获取方式
            if (isNull(userAgent)) {
                userAgent = UA.get(imei);
                LogUtils.d(TAG + "自定义获取方式");
            }
        }

        if (isNull(userAgent)) {
            userAgent = "";
        }

        return userAgent;
    }


    public static String getModel() {
        String model = Build.MODEL;
        if (model == null || model.length() <= 0) {
            return "";
        }
        return model;
    }

    public static String getAndroidVersion() {
        return Build.VERSION.RELEASE;
    }

    public static int getAndroidSDK() {
        return Build.VERSION.SDK_INT;
    }



    public static String getRomVersion() {
        String romVersion = "";
        try {
            String className = "android.os.SystemProperties";
            String methodName = "get";
            Class<?>[] parameterTypes = new Class<?>[]{String.class, String.class};
            Object[] args = new Object[]{"ro.gn.gnromvernumber", ""};
            Object roProductManufacturer = ReflectionTools.getMethod(className, methodName, parameterTypes,
                    args);

            romVersion = roProductManufacturer.toString();

            String regex = "\\d";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(romVersion);
            int index = 0;
            if (matcher.find() && !isNull(matcher.group())) {
                index = matcher.start();
            }
            romVersion = romVersion.substring(index);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (isNull(romVersion)) {
            // 我用 Build.VERSION.RELEASE，获取到的是操作系统的版本，我这里想获取ROM的版本
            romVersion = Build.VERSION.RELEASE;
//            SystemProperties.get("ro.build.display.id");
        }
        return romVersion;
    }






    private static boolean isNull(Object object) {
        if (object == null ||CommonConfig.DEFAULT_VALUE.equals(object.toString().trim())
                || "null".equals(object.toString().trim().toLowerCase(Locale.getDefault()))) {
            return true;
        }

        return false;
    }


    public static boolean isNull(Object... objectArray) {
        if (isNullArray(objectArray)) {
            return true;
        }
        for (Object object : objectArray) {
            if (isNull(object)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNullArray(byte[] objectArray) {
        if (objectArray == null) {
            return true;
        }
        if (objectArray.length == 0) {
            return true;
        }
        for (Object object : objectArray) {
            if (isNull(object)) {
                return true;
            }
            continue;
        }
        return false;
    }

    public static boolean isNullArray(Object[] objectArray) {
        if (objectArray == null) {
            return true;
        }
        if (objectArray.length == 0) {
            return true;
        }
        for (Object object : objectArray) {
            if (isNull(object)) {
                return true;
            }
            continue;
        }
        return false;
    }

    private static boolean isNotNull(Object object) {
        return !isNull(object);
    }

    public static boolean isNotNull(Object... objectArray) {
        return !isNull(objectArray);
    }
}
