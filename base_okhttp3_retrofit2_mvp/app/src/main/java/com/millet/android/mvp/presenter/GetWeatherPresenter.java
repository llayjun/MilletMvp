package com.millet.android.mvp.presenter;

import android.app.Activity;

import com.millet.android.mvp.model.IGetWeatherModel;
import com.millet.android.mvp.model.impl.GetWeatherModelImpl;
import com.millet.android.mvp.view.IGetWeatherView;
import com.millet.z_basic.base.mvp.BaseMvpPresenter;
import com.millet.z_basic.net.RetrofitFactory;
import com.millet.z_basic.net.bean.WeatherBean;
import com.millet.z_basic.net.dialog.NetLoadingUtils;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class GetWeatherPresenter extends BaseMvpPresenter<IGetWeatherView> {

    private IGetWeatherModel mIGetWeatherModel;

    public GetWeatherPresenter() {
        this.mIGetWeatherModel = new GetWeatherModelImpl();
    }

    public void getWeatherInfo(String name, final Activity activity) {
        RetrofitFactory.setRequest(mIGetWeatherModel.getWeatherInfo(name), new Observer<WeatherBean>() {

            @Override
            public void onSubscribe(Disposable d) {
                NetLoadingUtils.showDialog(activity);
            }

            @Override
            public void onNext(WeatherBean weatherBean) {
                mView.getWeatherInfoSuccess(weatherBean);
            }

            @Override
            public void onError(Throwable e) {
                NetLoadingUtils.hideDialog();
            }

            @Override
            public void onComplete() {
                NetLoadingUtils.hideDialog();
            }
        });
    }

}
