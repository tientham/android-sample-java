package com.tientham.androidsample.ui.todo;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;

import com.tientham.androidsample.R;
import com.tientham.androidsample.di.components.TodoListComponent;
import com.tientham.androidsample.model.TodoModel;
import com.tientham.androidsample.presenter.TodoItemDetailPresenter;
import com.tientham.androidsample.ui.BaseFragment;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by tientham (tien.tominh@gmail.com) on 2019-05-26.
 */
public class TodoItemDetailFragment extends BaseFragment implements TodoItemDetailView {

    private static final String PARAM_TODO_ID = "param_todo_id";

    @Bind(R.id.tv_title) TextView tv_title;
    @Bind(R.id.tv_note) TextView tv_note;
    @Bind(R.id.rb_isCompleted) RadioButton rb_isCompleted;
    @Bind(R.id.pb) ProgressBar pb;

    @Inject
    TodoItemDetailPresenter todoItemDetailPresenter;

    public static TodoItemDetailFragment newInstance(int todoId) {
        final TodoItemDetailFragment todoItemDetailFragment = new TodoItemDetailFragment();
        final Bundle arguments = new Bundle();
        arguments.putInt(PARAM_TODO_ID, todoId);
        todoItemDetailFragment.setArguments(arguments);
        return todoItemDetailFragment;
    }

    public TodoItemDetailFragment() {
        setRetainInstance(true);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getComponent(TodoListComponent.class).inject(this);
    }

    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                       Bundle savedInstanceState) {
        final View fragmentView = inflater.inflate(R.layout.fragment_todo_detail, container, false);
        ButterKnife.bind(this, fragmentView);
        return fragmentView;
    }

    @Override public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.todoItemDetailPresenter.setView(this);
        if (savedInstanceState == null) {
            this.loadTodoDetail();
        }
    }

    @Override public void onResume() {
        super.onResume();
        this.todoItemDetailPresenter.resume();
    }

    @Override public void onPause() {
        super.onPause();
        this.todoItemDetailPresenter.pause();
    }

    @Override public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override public void onDestroy() {
        super.onDestroy();
        this.todoItemDetailPresenter.destroy();
    }

    @Override
    public void showLoading() {
        pb.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        pb.setVisibility(View.GONE);
    }

    @Override
    public void renderTodo(TodoModel todoModel) {
        if (todoModel != null) {
            this.tv_title.setText(todoModel.getTitle());
            this.tv_note.setText(String.valueOf(todoModel.getNote()));
            this.rb_isCompleted.setEnabled(todoModel.isCompleted());
        }
    }

    @Override
    public Context context() {
        return this.getActivity().getApplicationContext();
    }

    private void loadTodoDetail() {
        if (this.todoItemDetailPresenter != null) {
            this.todoItemDetailPresenter.initialize(currentTodoId());
        }
    }

    private int currentTodoId() {
        final Bundle arguments = getArguments();
        return arguments.getInt(PARAM_TODO_ID);
    }
}
