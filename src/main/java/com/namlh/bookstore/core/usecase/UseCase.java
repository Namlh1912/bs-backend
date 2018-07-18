package com.namlh.bookstore.core.usecase;

import io.reactivex.Observable;

/**
 * Created by app on 7/13/18.
 */
public interface UseCase<IN, OUT> {

    Observable<OUT> execute(IN in);
}
