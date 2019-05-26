package com.tientham.androidsample.ui;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.tientham.androidsample.MainApplication;
import com.tientham.androidsample.di.components.ApplicationComponent;
import com.tientham.androidsample.di.modules.ActivityModule;
import com.tientham.androidsample.ui.navigation.Navigator;

import javax.inject.Inject;

/**
 * Created by tientham (tien.tominh@gmail.com) on 2019-05-26.
 */
public abstract class BaseActivity extends Activity {

    @Inject
    public Navigator navigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getApplicationComponent().inject(this);
    }

    protected void addFragment(int containerViewId, Fragment fragment) {
        final FragmentTransaction fragmentTransaction = this.getFragmentManager().beginTransaction();
        fragmentTransaction.add(containerViewId, fragment);
        fragmentTransaction.commit();
    }

    protected ApplicationComponent getApplicationComponent() {
        return ((MainApplication) getApplication()).getApplicationComponent();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }
}
