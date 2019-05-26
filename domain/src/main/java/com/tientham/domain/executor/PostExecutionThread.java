package com.tientham.domain.executor;

import io.reactivex.Scheduler;

/**
 * Created by tientham (tien.tominh@gmail.com) on 2019-05-26.
 */
public interface PostExecutionThread {
    Scheduler getScheduler();
}
