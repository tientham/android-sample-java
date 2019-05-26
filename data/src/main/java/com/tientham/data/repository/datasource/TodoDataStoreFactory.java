package com.tientham.data.repository.datasource;

import android.content.Context;
import android.support.annotation.NonNull;

import com.tientham.data.entity.TodoEntity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by tientham (tien.tominh@gmail.com) on 2019-05-26.
 */
@Singleton
public class TodoDataStoreFactory {

    private final Context context;

    @Inject
    TodoDataStoreFactory(@NonNull Context context) {
        this.context = context.getApplicationContext();
    }

    public TodoDataStore create(int userId) {
        TodoDataStore userDataStore;
        userDataStore = createMockDataStore();

        return userDataStore;
    }

    public TodoDataStore createMockDataStore() {
        TodoEntity td1 = new TodoEntity();
        td1.setTodoId(1);
        td1.setTitle("Title 1");
        td1.setNote("Note 1");
        td1.setCompleted(true);

        TodoEntity td2 = new TodoEntity();
        td1.setTodoId(2);
        td2.setTitle("Title 2");
        td2.setNote("Note 2");
        td2.setCompleted(false);

        List<TodoEntity> list = new ArrayList<>();
        list.add(td1);
        list.add(td2);

        return new MockTodoDataStore(list);
    }
}
