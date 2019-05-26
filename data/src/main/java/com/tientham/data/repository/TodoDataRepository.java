package com.tientham.data.repository;

import com.tientham.data.entity.mapper.TodoEntityDataMapper;
import com.tientham.data.repository.datasource.TodoDataStore;
import com.tientham.data.repository.datasource.TodoDataStoreFactory;
import com.tientham.domain.model.Todo;
import com.tientham.domain.repository.TodoRepository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * Created by tientham (tien.tominh@gmail.com) on 2019-05-26.
 */
@Singleton
public class TodoDataRepository implements TodoRepository {

    private final TodoDataStoreFactory todoDataStoreFactory;
    private final TodoEntityDataMapper todoEntityDataMaper;

    @Inject
    TodoDataRepository(TodoDataStoreFactory dataStoreFactory, TodoEntityDataMapper todoEntityDataMaper) {
        this.todoDataStoreFactory = dataStoreFactory;
        this.todoEntityDataMaper = todoEntityDataMaper;
    }

    @Override
    public Observable<List<Todo>> todos() {
        final TodoDataStore userDataStore = this.todoDataStoreFactory.createMockDataStore();
        return userDataStore.todoEntityList().map(this.todoEntityDataMaper::transform);
    }

    @Override
    public Observable<Todo> todo(int todoId) {
        final TodoDataStore userDataStore = this.todoDataStoreFactory.create(todoId);
        return userDataStore.todoEntityDetail(todoId).map(this.todoEntityDataMaper::transform);
    }
}
