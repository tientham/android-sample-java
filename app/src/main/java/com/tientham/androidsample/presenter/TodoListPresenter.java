package com.tientham.androidsample.presenter;

import android.support.annotation.NonNull;

import com.tientham.androidsample.di.PerActivity;
import com.tientham.androidsample.mapper.TodoModelDataManager;
import com.tientham.androidsample.model.TodoModel;
import com.tientham.androidsample.ui.todos.TodoListView;
import com.tientham.domain.interactor.GetTodoList;
import com.tientham.domain.model.Todo;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.observers.DefaultObserver;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by tientham (tien.tominh@gmail.com) on 2019-05-26.
 */
@PerActivity
public class TodoListPresenter implements Presenter {

    private TodoListView todoListView;
    private GetTodoList getTodoListUseCase;
    private final TodoModelDataManager todoModelDataManager;

    @Inject
    public TodoListPresenter(GetTodoList getTodoListUseCase, TodoModelDataManager dataManager) {
        this.todoModelDataManager = dataManager;
        this.getTodoListUseCase = getTodoListUseCase;
    }

    public void setTodoListView(@NonNull TodoListView view) {
        this.todoListView = view;
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {

    }

    public void initialize() {
        this.loadTodoList();
    }

    private void loadTodoList() {
        this.showViewLoading();
        this.getTodoList();
    }

    private void showViewLoading() {
        this.todoListView.showLoading();
    }

    private void hideViewLoading() {
        this.todoListView.hideLoading();
    }

    private void showUsersCollectionInView(Collection<Todo> todoListCollection) {
        final Collection<TodoModel> todoListModelsCollection =
                this.todoModelDataManager.transform(todoListCollection);
        this.todoListView.renderTodoList(todoListModelsCollection);
    }

    private void getTodoList() {
        this.getTodoListUseCase.execute(new TodoListObserver(), null);
    }

    private final class TodoListObserver extends DisposableObserver<List<Todo>> {

        @Override
        public void onComplete() {
            TodoListPresenter.this.hideViewLoading();
        }

        @Override
        public void onError(Throwable e) {
            TodoListPresenter.this.hideViewLoading();

        }

        @Override
        public void onNext(List<Todo> todos) {
            TodoListPresenter.this.showUsersCollectionInView(todos);
        }
    }
}
