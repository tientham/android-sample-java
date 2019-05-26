package com.tientham.androidsample.ui.todo;

import com.tientham.androidsample.model.TodoModel;
import com.tientham.androidsample.ui.BaseView;

/**
 * Created by tientham (tien.tominh@gmail.com) on 2019-05-26.
 */
public interface TodoItemDetailView extends BaseView {

    void renderTodo(TodoModel todo);
}
