package com.tientham.androidsample.di.components;

import android.app.Activity;

import com.tientham.androidsample.di.PerActivity;
import com.tientham.androidsample.di.modules.ActivityModule;

import dagger.Component;

/**
 * Created by tientham (tien.tominh@gmail.com) on 2019-05-26.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
interface ActivityComponent {
    Activity activity();
}
