package com.gionee.wallet.api;

import com.gionee.wallet.model.bean.WangyiNewsListBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by jeker on 17-12-21.
 * 网易api
 */

public interface WangyiApi {
    // 对应地址
    //http://c.m.163.com/nc/article/headline/T1348647909107/0-20.html

    public final  String HOST ="http://c.m.163.com";

    @GET("/nc/article/headline/T1348647909107/{id}-20.html")
    Observable<WangyiNewsListBean> getNewList(@Path("id") int  id);


}
