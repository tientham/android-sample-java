package com.tientham.androidsample.ui.navigation;

import android.content.Context;
import android.content.Intent;

import com.tientham.androidsample.ui.todo.TodoItemDetailActivity;
import com.tientham.androidsample.ui.todos.TodoListActivity;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by tientham (tien.tominh@gmail.com) on 2019-05-26.
 */
@Singleton
public class Navigator {

    @Inject
    public Navigator() {

    }

    public void navigateToTodoList (Context context) {
        if (context != null) {
            Intent intentToLaunch = TodoListActivity.getCallingIntent(context);
            context.startActivity(intentToLaunch);
        }
    }

    public void navigateToTodoDetail (Context context, int itemId) {
        if (context != null) {
            Intent intentToLaunch = TodoItemDetailActivity.getCallingIntent(context, itemId);
            context.startActivity(intentToLaunch);
        }
    }
}
