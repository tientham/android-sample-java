package com.tientham.androidsample.ui.todos;

import com.tientham.androidsample.model.TodoModel;
import com.tientham.androidsample.ui.BaseView;

import java.util.Collection;

/**
 * Created by tientham (tien.tominh@gmail.com) on 2019-05-26.
 */
public interface TodoListView extends BaseView {

    void renderTodoList(Collection<TodoModel> todoModelCollection);

    void viewTodo(TodoModel todoModel);
}
