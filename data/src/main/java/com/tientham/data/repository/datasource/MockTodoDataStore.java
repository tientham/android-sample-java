package com.tientham.data.repository.datasource;

import com.tientham.data.entity.TodoEntity;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;

/**
 * Created by tientham (tien.tominh@gmail.com) on 2019-05-26.
 */
@SuppressWarnings("unchecked")
public class MockTodoDataStore implements TodoDataStore {

    private Observable<List<TodoEntity>> observable;

    MockTodoDataStore(List<TodoEntity> list) {
        this.observable = Observable.fromArray(list);
    }

    @Override
    public Observable<List<TodoEntity>> todoEntityList() {
        return observable;
    }

    @Override
    public Observable<TodoEntity> todoEntityDetail(int todoId) {
        TodoEntity td1 = new TodoEntity();
        td1.setTodoId(1);
        td1.setTitle("Test 1");
        td1.setNote("Note 1");
        td1.setCompleted(true);

        return null;

    }
}
