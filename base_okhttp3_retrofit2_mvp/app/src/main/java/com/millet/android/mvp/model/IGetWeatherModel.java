package com.millet.android.mvp.model;

import com.millet.z_basic.net.bean.WeatherBean;

import io.reactivex.Observable;

public interface IGetWeatherModel {

    Observable<WeatherBean> getWeatherInfo(String cityName);

}
