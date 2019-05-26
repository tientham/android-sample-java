package com.tientham.androidsample.ui.todo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.tientham.androidsample.R;
import com.tientham.androidsample.di.HasComponent;
import com.tientham.androidsample.di.components.DaggerTodoListComponent;
import com.tientham.androidsample.di.components.TodoListComponent;
import com.tientham.androidsample.ui.BaseActivity;

/**
 * Created by tientham (tien.tominh@gmail.com) on 2019-05-26.
 */
public class TodoItemDetailActivity extends BaseActivity implements HasComponent<TodoListComponent> {

    private static final String INTENT_EXTRA_PARAM_TODO_ID = "com.tientham.androidsample.ui.todo.INTENT_EXTRA_PARAM_TODO_ID";
    private static final String INTENT_STATE_PARAM_TODO_ID = "com.tientham.androidsample.ui.todo.INTENT_STATE_PARAM_TODO_ID";

    public static Intent getCallingIntent(Context context, int todoItemId) {
        Intent callingIntent = new Intent(context, TodoItemDetailActivity.class);
        callingIntent.putExtra(INTENT_EXTRA_PARAM_TODO_ID, todoItemId);
        return callingIntent;
    }

    private int todoId;
    private TodoListComponent todoListComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);

        this.initializeActivity(savedInstanceState);
        this.initializeInjector();
    }

    @Override protected void onSaveInstanceState(Bundle outState) {
        if (outState != null) {
            outState.putInt(INTENT_STATE_PARAM_TODO_ID, this.todoId);
        }
        super.onSaveInstanceState(outState);
    }


    /**
     * Initializes this activity.
     */
    private void initializeActivity(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            this.todoId = getIntent().getIntExtra(INTENT_EXTRA_PARAM_TODO_ID, -1);
            addFragment(R.id.fragmentContainer, TodoItemDetailFragment.newInstance(todoId));
        } else {
            this.todoId = savedInstanceState.getInt(INTENT_STATE_PARAM_TODO_ID);
        }
    }

    private void initializeInjector() {
        this.todoListComponent = DaggerTodoListComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
    }

    @Override public TodoListComponent getComponent() {
        return todoListComponent;
    }
}
