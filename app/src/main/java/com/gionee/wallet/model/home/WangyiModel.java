package com.gionee.wallet.model.home;

import com.gionee.wallet.api.WangyiApi;
import com.gionee.wallet.contract.home.tabs.WangyiContract;
import com.gionee.wallet.core.netHelper.RetrofitCreateHelper;
import com.gionee.wallet.core.netHelper.RxHelper;
import com.gionee.wallet.model.bean.WangyiNewsListBean;

import io.reactivex.Observable;

/**
 * Created by jeker on 17-12-19. 网易
 */

public class WangyiModel implements WangyiContract.IWangyiModel {

    public static WangyiModel newInstance() {
        return new WangyiModel();
    }

    @Override
    public Observable<WangyiNewsListBean> getNewList(int id) {
        return RetrofitCreateHelper.createApi(WangyiApi.class, WangyiApi.HOST).getNewList(id)
                .compose(RxHelper.<WangyiNewsListBean>rxSchedulerHelper());
    }
}
