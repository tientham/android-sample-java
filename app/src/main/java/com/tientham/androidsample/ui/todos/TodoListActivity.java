package com.tientham.androidsample.ui.todos;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

import com.tientham.androidsample.R;
import com.tientham.androidsample.di.HasComponent;
import com.tientham.androidsample.di.components.DaggerTodoListComponent;
import com.tientham.androidsample.di.components.TodoListComponent;
import com.tientham.androidsample.model.TodoModel;
import com.tientham.androidsample.ui.BaseActivity;

/**
 * Created by tientham (tien.tominh@gmail.com) on 2019-05-26.
 */
public class TodoListActivity extends BaseActivity implements HasComponent<TodoListComponent>, TodoListFragment.TodoListListener {

    public static Intent getCallingIntent(Context context) {
        return new Intent(context, TodoListActivity.class);
    }

    private TodoListComponent todoListComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.activity_todo_list);
        initializeInjector();

        if (savedInstanceState == null) {
            addFragment(R.id.fragmentContainer, new TodoListFragment());
        }
    }

    private void initializeInjector() {
        this.todoListComponent = DaggerTodoListComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
    }

    @Override
    public TodoListComponent getComponent() {
        return todoListComponent;
    }

    @Override
    public void onTodoClicked(TodoModel todoModel) {
        this.navigator.navigateToTodoDetail(this, todoModel.getTodoId());
    }
}
