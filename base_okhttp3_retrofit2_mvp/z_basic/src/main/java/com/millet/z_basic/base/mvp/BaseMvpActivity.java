package com.millet.z_basic.base.mvp;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.gyf.immersionbar.ImmersionBar;
import com.millet.z_basic.base.dialog.LoadingDialog;
import com.millet.z_basic.net.dialog.NetLoadingUtils;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

public abstract class BaseMvpActivity<V extends IBaseMvpView, P extends BaseMvpPresenter<V>> extends RxAppCompatActivity implements IBaseMvpView, IActivity, View.OnClickListener {

    protected P mPresenter;

    protected LoadingDialog dialog;

    @SuppressWarnings("unchecked")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ImmersionBar.with(this).init();
        if (mPresenter == null) {
            mPresenter = createPresenter();
        }
        mPresenter.attachMvpView((V) this);
        initImmersionBar();
        dialog = NetLoadingUtils.createDialog(this, "记载中...");
        initView();
        initData(savedInstanceState);
    }

    protected abstract P createPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachMvpView();
        }
    }

    /**
     * 初始化沉浸式
     * Init immersion bar.
     */
    protected void initImmersionBar() {
        //设置共同沉浸式样式
        ImmersionBar.with(this).init();
    }

}
