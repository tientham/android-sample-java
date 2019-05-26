package com.tientham.androidsample.di.modules;

import android.content.Context;

import com.tientham.androidsample.MainApplication;
import com.tientham.androidsample.ui.UIThread;
import com.tientham.data.executor.JobExecutor;
import com.tientham.data.repository.TodoDataRepository;
import com.tientham.domain.executor.PostExecutionThread;
import com.tientham.domain.executor.ThreadExecutor;
import com.tientham.domain.repository.TodoRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by tientham (tien.tominh@gmail.com) on 2019-05-26.
 */
@Module
public class ApplicationModule {
    private final MainApplication application;

    public ApplicationModule(MainApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this.application;
    }

    @Provides @Singleton
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides @Singleton
    PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }

    @Provides
    @Singleton
    TodoRepository provideTodoRepository(TodoDataRepository todoDataRepository) {
        return todoDataRepository;
    }
}
