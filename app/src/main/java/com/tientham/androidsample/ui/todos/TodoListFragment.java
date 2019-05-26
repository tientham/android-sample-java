package com.tientham.androidsample.ui.todos;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tientham.androidsample.R;
import com.tientham.androidsample.di.components.TodoListComponent;
import com.tientham.androidsample.model.TodoModel;
import com.tientham.androidsample.presenter.TodoListPresenter;
import com.tientham.androidsample.ui.BaseFragment;
import com.tientham.androidsample.ui.todo.TodoListAdapter;

import java.util.Collection;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by tientham (tien.tominh@gmail.com) on 2019-05-26.
 */
public class TodoListFragment extends BaseFragment implements TodoListView {

    public interface TodoListListener {
        void onTodoClicked(final TodoModel todoModel);
    }

    @Inject
    TodoListPresenter todoListPresenter;
    @Inject
    TodoListAdapter todoListAdapter;

    @Bind(R.id.rv_todo_list)
    RecyclerView rv_todo_list;
    @Bind(R.id.pb)
    ProgressBar pb;

    private TodoListListener todoListListener;

    public TodoListFragment() {
        setRetainInstance(true);
    }

    @Override public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof TodoListListener) {
            this.todoListListener = (TodoListListener) activity;
        }
    }

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getComponent(TodoListComponent.class).inject(this);
    }

    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                       Bundle savedInstanceState) {
        final View fragmentView = inflater.inflate(R.layout.fragment_todo_list, container, false);
        ButterKnife.bind(this, fragmentView);
        setupRecyclerView();
        return fragmentView;
    }

    @Override public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.todoListPresenter.setTodoListView(this);
        if (savedInstanceState == null) {
            this.loadUserList();
        }
    }


    @Override
    public void renderTodoList(Collection<TodoModel> todoModelCollection) {
        if (todoModelCollection != null) {
            this.todoListAdapter.setTodosCollection(todoModelCollection);
        }
    }

    @Override
    public void viewTodo(TodoModel todoModel) {

    }

    @Override
    public void showLoading() {
        this.pb.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        this.pb.setVisibility(View.GONE);
    }

    @Override
    public Context context() {
        return this.getActivity().getApplicationContext();
    }

    private void setupRecyclerView() {
        //this.todoListAdapter.setOnItemClickListener(onItemClickListener);
        this.rv_todo_list.setLayoutManager(new TodoListLayoutManager(context()));
        this.rv_todo_list.setAdapter(todoListAdapter);
    }

    private void loadUserList() {
        this.todoListPresenter.initialize();
    }
}
