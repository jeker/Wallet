package com.gionee.wallet.core.utils;

import android.os.Build;

import java.lang.reflect.Method;
import java.util.Locale;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by jeker on 2018/1/2
 *
 */
public class UA {

    private static final String AES = "AES";
    private static final String VIPARA = "0102030405060708";
    private static final String AES_CBC_PKCS_5_PADDING = "AES/CBC/PKCS5Padding";
    private static final String SEED = "GIONEE2012061900";
    private static final String HEX = "0123456789ABCDEF";
    private static final String CHARSET = "UTF-8";

    public static String get(String imei) {
        String brand = getPhoneSystemInfo("ro.product.brand", "GiONEE");
        String model = getPhoneSystemInfo("ro.product.model", "Phone");
        String extModel = getPhoneSystemInfo("ro.gn.extmodel", "Phone");
        String romVer = getPhoneSystemInfo("ro.gn.gnromvernumber", "GiONEE ROM4.0.1");
        String ver = romVer.substring(romVer.indexOf("M") + 1);
        String language = Locale.getDefault().getLanguage();
        String country = Locale.getDefault().getCountry().toLowerCase(Locale.getDefault());

        String encodeImei = encode(imei);

        String uaString = "Mozilla/5.0 (Linux; U; Android " + Build.VERSION.RELEASE + "; " + language + "-"
                + country + ";" + brand + "-" + model + "/" + extModel
                + " Build/IMM76D) AppleWebKit534.30(KHTML,like Gecko)Version/4.0 Mobile Safari/534.30 Id/"
                + encodeImei + " RV/" + ver;
        return uaString;
    }

    private static String encrypt(String seed, String cleartext) throws Exception {
        byte[] result = encrypt(seed.getBytes(CommonConfig.UTF_8), cleartext.getBytes(CommonConfig.UTF_8));
        return toHex(result);
    }

    private static byte[] encrypt(byte[] raw, byte[] clear) throws Exception {
        IvParameterSpec zeroIv = new IvParameterSpec(VIPARA.getBytes(CommonConfig.UTF_8));
        SecretKeySpec skeySpec = new SecretKeySpec(raw, AES);
        Cipher cipher = Cipher.getInstance(AES_CBC_PKCS_5_PADDING);
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, zeroIv);
        byte[] encrypted = cipher.doFinal(clear);
        return encrypted;
    }

    private static String toHex(byte[] buf) {
        if (buf == null) {
            return CommonConfig.DEFAULT_VALUE;
        }
        StringBuffer result = new StringBuffer(2 * buf.length);
        for (int i = 0; i < buf.length; i++) {
            appendHex(result, buf[i]);
        }
        return result.toString();
    }

    private static void appendHex(StringBuffer sb, byte b) {
        sb.append(HEX.charAt((b >> 4) & 0x0f)).append(HEX.charAt(b & 0x0f));
    }

    public static String encode(String str) {
        if (str == null) {
            str = CommonConfig.DEFAULT_VALUE;
        }

        String masterPassword = SEED;

        try {
            String encryptingCode = encrypt(masterPassword, str);
            return encryptingCode;
        } catch (Exception e) {

            e.printStackTrace();
            return CommonConfig.DEFAULT_VALUE;
        }
    }

    private static String getPhoneSystemInfo(String key, String defalut) {
        String info = defalut;
        try {
            Class<?> c = Class.forName("android.os.SystemProperties");
            Object obj = c.newInstance();
            Method method = c.getMethod("get", String.class, String.class);
            info = (String) method.invoke(obj, key, defalut);
        } catch (Exception e) {
            e.printStackTrace();
            info = defalut;
        }
        return info;
    }
}
