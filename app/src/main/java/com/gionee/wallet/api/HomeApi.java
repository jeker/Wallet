package com.gionee.wallet.api;

import com.gionee.wallet.model.bean.reques.CarouselDiagramRequest;
import com.gionee.wallet.model.bean.reques.ServicesListRequest;
import com.gionee.wallet.model.bean.response.CarouselDiagramResponse;
import com.gionee.wallet.model.bean.response.ServicesListResponse;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * Created by jeker on 17-12-21.
 * 首页接口api
 */

public interface HomeApi {
    // 获取轮播图 对应地址
    //url=http://121.41.108.162:8008/gionee-wallet/walletService.do?gsp=5.0.0.bi&model=91CA7AF733DE000BDFF7563CF883DBEC&androidVersion=7.1.1&romVersion=5.1.16
    // transCode=020041,transName=获取轮播图

// https 的方式
   // 请求接口:url=https://wallet.gionee.com/gionee-wallet/walletService.do?gsp=5.0.0.bc&model=91CA7AF733DE000BDFF7563CF883DBEC&androidVersion=7.1.1&romVersion=5.1.16&imei=1B81A5F3C743A5408E2E0D8E7DAFD500&ua=Mozilla/5.0(Linux;U;Android7.1.1;zh-cn;GIONEE-GIONEEM7/M7Build/IMM76D)AppleWebKit534.30(KHTML,likeGecko)Version/4.0MobileSafari/534.30Id/1B81A5F3C743A5408E2E0D8E7DAFD500RV/5.1.16,transCode=020041
    // ,transName=获取轮播图



    public final  String HOST ="https://wallet.gionee.com/gionee-wallet/";

    @POST("walletService.do")
    Observable<CarouselDiagramResponse> queryCarouselDiagram(@QueryMap Map<String, String> options, @Body CarouselDiagramRequest request);

    @POST("walletService.do")
    Observable<ServicesListResponse> queryHomeFragmentServicesList(@QueryMap Map<String, String> options, @Body ServicesListRequest request);


//    / 链接 http://baseurl/blog/id?param1=Param1&param2=Param2...
//    public interface BlogService{
//        @GET("blog/{id}")
//        Call<ResponseBody> getBlog(@Path("id") int id, @QueryMap Map<String, String> options);
//    }



}
