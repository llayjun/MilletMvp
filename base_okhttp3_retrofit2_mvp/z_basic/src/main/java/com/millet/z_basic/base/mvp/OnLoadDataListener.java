package com.millet.z_basic.base.mvp;

public interface OnLoadDataListener<T> {

    /**
     * 成功
     *
     * @param t 数据
     */
    void onSuccess(T t);

    /**
     * 失败
     *
     * @param error 错误信息
     */
    void onFailure(String error);

}
