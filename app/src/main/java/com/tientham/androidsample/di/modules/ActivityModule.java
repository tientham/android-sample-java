package com.tientham.androidsample.di.modules;

import android.app.Activity;

import com.tientham.androidsample.di.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by tientham (tien.tominh@gmail.com) on 2019-05-26.
 */
@Module
public class ActivityModule {
    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @PerActivity
    Activity activity() {
        return this.activity;
    }
}
