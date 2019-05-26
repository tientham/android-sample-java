package com.tientham.androidsample.ui;

import android.content.Context;

/**
 * Created by tientham (tien.tominh@gmail.com) on 2019-05-26.
 */
public interface BaseView {
    void showLoading();
    void hideLoading();
    Context context();
}
