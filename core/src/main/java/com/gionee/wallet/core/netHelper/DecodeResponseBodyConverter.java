package com.gionee.wallet.core.netHelper;

/**
 * Created by jeker on 17-12-27.
 */

import com.gionee.wallet.core.utils.LogUtils;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;

public class DecodeResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final TypeAdapter<T> adapter;
    private final Gson gson;

    DecodeResponseBodyConverter(Gson gson,TypeAdapter<T> adapter) {
        this.adapter = adapter;
        this.gson = gson;
    }

//    @Override
//    public T convert(ResponseBody value) throws IOException {
//        // 解密字符串
//
//      //  return adapter.fromJson(EncryptUtils.decode(value.string()));
//        LogUtils.d("hj-------------返回数据未加密------>"+value.string());
//        return adapter.fromJson(value.string());
//    }

    @Override public T convert(ResponseBody value) throws IOException {

    //    LogUtils.d("hj-------------返回数据未加密------>"+value.string());
        LogUtils.d("hj-------------返回数据未加密------>");

        JsonReader jsonReader = gson.newJsonReader(value.charStream());
        try {
            return adapter.read(jsonReader);
        } finally {
            value.close();
        }
    }



    /**
     * 解密的具体实现
     *
     */
    private static class EncryptUtils {

        //返回一字json符串
        public static String decode(String str) {



            return "";

        }
    }

}
