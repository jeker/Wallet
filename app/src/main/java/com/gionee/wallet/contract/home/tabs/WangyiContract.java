package com.gionee.wallet.contract.home.tabs;

import com.gionee.wallet.core.base.BasePresenter;
import com.gionee.wallet.core.base.IBaseActivity;
import com.gionee.wallet.core.base.IBaseModel;
import com.gionee.wallet.model.bean.WangyiNewsListBean;

import io.reactivex.Observable;


/**
 * Created by jeker on 17-12-19.
 *
 * 网易接口
 *  presenter
 *  model
 *  view
 */

public interface WangyiContract {

  abstract  class  IWangyiPresenter extends BasePresenter<IWangyiModel,IWangyiView> {

    /**
     * 加载最新的list
     */
    public abstract void loadLatestList();


  }


    interface  IWangyiModel extends IBaseModel {

        Observable<WangyiNewsListBean> getNewList(int id);

    }

    interface  IWangyiView extends IBaseActivity {

      void   showData(String str);

    }


}
