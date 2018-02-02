package com.gionee.wallet.presenter.home;

import com.gionee.wallet.contract.home.tabs.WangyiContract;
import com.gionee.wallet.core.utils.LogUtils;
import com.gionee.wallet.model.bean.WangyiNewsItemBean;
import com.gionee.wallet.model.bean.WangyiNewsListBean;
import com.gionee.wallet.model.home.WangyiModel;

import java.util.List;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Created by jeker on 17-12-20.
 */

public class WangyiPresenter extends WangyiContract.IWangyiPresenter {

    private int mCurrentIndex;

    public static WangyiPresenter newInstance() {
        return new WangyiPresenter();
    }

    @Override
    public WangyiContract.IWangyiModel getModel() {
        return WangyiModel.newInstance();
    }

    @Override
    public void onStart() {

    }

    @Override
    public void loadLatestList() {
        mCurrentIndex = 0;
        Disposable disposable = mIModel.getNewList(mCurrentIndex)
                .subscribe(new Consumer<WangyiNewsListBean>() {
                    @Override
                    public void accept(WangyiNewsListBean wangyiNewsListBean) throws Exception {
                   List<WangyiNewsItemBean> list=wangyiNewsListBean.getNewsList();
                        LogUtils.d("--------list-----"+list);
                        if(mIView!=null){

                            mIView.showData(list.get(0).getTitle());
                        }

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        LogUtils.d("--------list  网络问题-----");
                        System.out.print("--jeker---网络问题-");
                    }
                });
        mRxManager.register(disposable);

    }
}
