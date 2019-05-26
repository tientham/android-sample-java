package com.tientham.domain.interactor;

import com.tientham.domain.executor.PostExecutionThread;
import com.tientham.domain.executor.ThreadExecutor;
import com.tientham.domain.model.Todo;
import com.tientham.domain.repository.TodoRepository;

import java.util.List;
import javax.inject.Inject;
import io.reactivex.Observable;

/**
 * Created by tientham (tien.tominh@gmail.com) on 2019-05-26.
 */
public class GetTodoList extends UseCase<List<Todo>, Void> {

    private final TodoRepository todoRepository;

    @Inject
    GetTodoList(TodoRepository todoRepository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.todoRepository = todoRepository;
    }

    @Override
    Observable<List<Todo>> buildUseCaseObservable(Void unused) {
        return this.todoRepository.todos();
    }
}
