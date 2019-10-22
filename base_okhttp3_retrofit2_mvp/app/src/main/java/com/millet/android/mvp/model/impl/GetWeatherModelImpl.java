package com.millet.android.mvp.model.impl;

import com.millet.android.mvp.model.IGetWeatherModel;
import com.millet.z_basic.net.RetrofitFactory;
import com.millet.z_basic.net.bean.WeatherBean;

import io.reactivex.Observable;

public class GetWeatherModelImpl implements IGetWeatherModel {

    @Override
    public Observable<WeatherBean> getWeatherInfo(String cityName) {
        return RetrofitFactory.getInstance().API().getWeatherByCityName(cityName);
    }

}
