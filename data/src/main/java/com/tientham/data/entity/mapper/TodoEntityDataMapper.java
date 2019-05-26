package com.tientham.data.entity.mapper;

import com.tientham.data.entity.TodoEntity;
import com.tientham.domain.model.Todo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by tientham (tien.tominh@gmail.com) on 2019-05-26.
 * Transform {@link com.tientham.data.entity.TodoEntity} in data layer to {@link com.tientham.domain.model.Todo}
 * in domain layer
 */
@Singleton
public class TodoEntityDataMapper {

    private final int MAX_TODO_ITEMS = 10;

    @Inject
    TodoEntityDataMapper() {}

    public Todo transform(TodoEntity todoEntity) {
        Todo todo = null;
        if (todoEntity != null) {
            todo = new Todo(todoEntity.getTodoId());
            todo.setTitle(todoEntity.getTitle());
            todo.setNote(todoEntity.getNote());
            todo.setCompleted(todoEntity.isCompleted());
        }

        return todo;
    }

    public List<Todo> transform(Collection<TodoEntity> todoEntityCollection) {
        final List<Todo> todoList = new ArrayList<>(MAX_TODO_ITEMS);
        for (TodoEntity todoEntity : todoEntityCollection) {
            final Todo todo = transform(todoEntity);
            if (todo != null) {
                todoList.add(todo);
            }
        }

        return todoList;
    }
}
