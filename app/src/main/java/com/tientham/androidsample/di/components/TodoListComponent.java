package com.tientham.androidsample.di.components;

import com.tientham.androidsample.di.PerActivity;
import com.tientham.androidsample.di.modules.ActivityModule;
import com.tientham.androidsample.di.modules.TodoListModule;
import com.tientham.androidsample.ui.todo.TodoItemDetailFragment;
import com.tientham.androidsample.ui.todos.TodoListFragment;

import dagger.Component;

/**
 * Created by tientham (tien.tominh@gmail.com) on 2019-05-26.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, TodoListModule.class})
public interface TodoListComponent  extends ActivityComponent {
    void inject(TodoListFragment todoListFragment);
    void inject(TodoItemDetailFragment todoItemDetailFragment);
}
