package com.tientham.data.repository.datasource;

import com.tientham.data.entity.TodoEntity;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by tientham (tien.tominh@gmail.com) on 2019-05-26.
 * Interface that represents a to-do data store from where to-do data is retrieved
 */
public interface TodoDataStore {

    Observable<List<TodoEntity>> todoEntityList();

    Observable<TodoEntity> todoEntityDetail(final int todoId);
}
