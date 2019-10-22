package com.millet.android.mvp.view;

import com.millet.z_basic.base.mvp.IBaseMvpView;
import com.millet.z_basic.net.bean.WeatherBean;

public interface IGetWeatherView extends IBaseMvpView {

    void getWeatherInfoSuccess(WeatherBean weatherBean);

}
