package com.tientham.androidsample.mapper;

import com.tientham.androidsample.di.PerActivity;
import com.tientham.androidsample.model.TodoModel;
import com.tientham.domain.model.Todo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.inject.Inject;

/**
 * Created by tientham (tien.tominh@gmail.com) on 2019-05-26.
 * Mapping between domain layer and app layer
 */
@PerActivity
public class TodoModelDataManager {

    @Inject
    public TodoModelDataManager() {}

    public TodoModel transform(Todo todo) {
        if (todo == null) {
            throw new IllegalArgumentException("Cannot transform a null value");
        }

        final TodoModel todoModel = new TodoModel(todo.getTodoId());
        todoModel.setCompleted(todo.isCompleted());
        todoModel.setNote(todo.getNote());
        todoModel.setTitle(todo.getTitle());

        return todoModel;
    }

    public Collection<TodoModel> transform(Collection<Todo> todoCollection) {
        Collection<TodoModel> todoModelCollection;

        if (todoCollection != null && !todoCollection.isEmpty()) {
            todoModelCollection = new ArrayList<>();
            for (Todo todo : todoCollection) {
                todoModelCollection.add(transform(todo));
            }
        } else {
            todoModelCollection = Collections.emptyList();
        }

        return todoModelCollection;
    }
}
