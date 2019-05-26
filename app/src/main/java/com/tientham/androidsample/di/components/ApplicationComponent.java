package com.tientham.androidsample.di.components;

import android.content.Context;

import com.tientham.androidsample.di.modules.ApplicationModule;
import com.tientham.androidsample.ui.BaseActivity;
import com.tientham.domain.executor.PostExecutionThread;
import com.tientham.domain.executor.ThreadExecutor;
import com.tientham.domain.repository.TodoRepository;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by tientham (tien.tominh@gmail.com) on 2019-05-26.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(BaseActivity baseActivity);

    Context context();
    ThreadExecutor threadExecutor();
    PostExecutionThread postExecutionThread();
    TodoRepository todoRepository();
}
