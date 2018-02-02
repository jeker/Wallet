package com.gionee.wallet.core.base;

import android.support.annotation.NonNull;

import com.gionee.wallet.core.RxManager;

/**
 * Created by jeker on 2018/1/2
 */

public abstract class BasePresenter<M, V> {

    public M mIModel;
    public V mIView;
    protected RxManager mRxManager =new RxManager();

    public abstract M getModel();

    public void attachMV(@NonNull M m, @NonNull V v) {
        this.mIModel = m;
        this.mIView = v;
        this.onStart();
    }

    public void detachMV() {
        mRxManager.unSubscribe();
        mIView = null;
        mIModel = null;

    }

    public abstract void onStart();

}
