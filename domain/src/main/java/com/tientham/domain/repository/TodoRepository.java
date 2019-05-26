package com.tientham.domain.repository;

import com.tientham.domain.model.Todo;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by tientham (tien.tominh@gmail.com) on 2019-05-26.
 * Interface that represents a Repository for getting {@link Todo} related data
 */
public interface TodoRepository {

    Observable<List<Todo>> todos();

    Observable<Todo> todo(final int todoId);
}
