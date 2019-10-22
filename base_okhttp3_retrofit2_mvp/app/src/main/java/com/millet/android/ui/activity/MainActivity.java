package com.millet.android.ui.activity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.millet.android.R;
import com.millet.android.mvp.presenter.GetWeatherPresenter;
import com.millet.android.mvp.view.IGetWeatherView;
import com.millet.z_basic.base.mvp.BaseMvpActivity;
import com.millet.z_basic.net.bean.WeatherBean;

public class MainActivity extends BaseMvpActivity<IGetWeatherView, GetWeatherPresenter> implements IGetWeatherView {

    @Override
    protected GetWeatherPresenter createPresenter() {
        return new GetWeatherPresenter();
    }

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        TextView textView = findViewById(R.id.tv_click);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.getWeatherInfo("南通", MainActivity.this);
            }
        });
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public void getWeatherInfoSuccess(WeatherBean weatherBean) {

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public Dialog getLoadDialog() {
        return null;
    }

    @Override
    public void cancelLoadDialog() {

    }

}
