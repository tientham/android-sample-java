package com.tientham.androidsample;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;
import com.tientham.androidsample.di.components.ApplicationComponent;
import com.tientham.androidsample.di.components.DaggerApplicationComponent;
import com.tientham.androidsample.di.modules.ApplicationModule;

/**
 * Created by tientham (tien.tominh@gmail.com) on 2019-05-26.
 */
public class MainApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        this.initializeInjector();
        this.initializeLeakDetection();
    }

    private void initializeInjector() {
        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }

    private void initializeLeakDetection() {
        if (BuildConfig.DEBUG) {
            LeakCanary.install(this);
        }
    }
}
