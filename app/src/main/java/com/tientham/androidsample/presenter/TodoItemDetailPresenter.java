package com.tientham.androidsample.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.tientham.androidsample.di.PerActivity;
import com.tientham.androidsample.mapper.TodoModelDataManager;
import com.tientham.androidsample.model.TodoModel;
import com.tientham.androidsample.ui.todo.TodoItemDetailView;
import com.tientham.domain.model.Todo;

import javax.inject.Inject;

import io.reactivex.observers.DefaultObserver;

/**
 * Created by tientham (tien.tominh@gmail.com) on 2019-05-26.
 */
@PerActivity
public class TodoItemDetailPresenter implements Presenter {

    private TodoItemDetailView todoItemDetailView;
    private TodoModelDataManager todoModelDataManager;
    private Context mContext;

    @Inject
    public TodoItemDetailPresenter(Context context, TodoModelDataManager todoModelDataManager) {
        this.mContext = context;
        this.todoModelDataManager = todoModelDataManager;
    }

    public void setView(@NonNull TodoItemDetailView view) {
        this.todoItemDetailView = view;
    }

    @Override
    public void resume() {}

    @Override
    public void pause() {}

    @Override
    public void destroy() {}

    public void initialize(int todoId) {
        this.showViewLoading();
    }

    private void showViewLoading() {
        this.todoItemDetailView.showLoading();
    }

    private void hideViewLoading() {
        this.todoItemDetailView.hideLoading();
    }

    private void showError() {
        Toast.makeText(mContext, "Error on receiving Todo", Toast.LENGTH_SHORT).show();
    }

    private void showTodoDetailInView(Todo todo) {
        final TodoModel todoModel = this.todoModelDataManager.transform(todo);
        this.todoItemDetailView.renderTodo(todoModel);
    }

    private final class TodoDetailObserver extends DefaultObserver<Todo> {
        @Override
        public void onComplete() {
            TodoItemDetailPresenter.this.hideViewLoading();
        }

        @Override
        public void onError(Throwable e) {
            TodoItemDetailPresenter.this.hideViewLoading();
            TodoItemDetailPresenter.this.showError();
        }

        @Override
        public void onNext(Todo todo) {
            TodoItemDetailPresenter.this.showTodoDetailInView(todo);
        }
    }
}
