package com.namlh.bookstore.main.config;

import io.reactivex.Observable;
import org.springframework.core.MethodParameter;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.context.request.async.WebAsyncUtils;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * Created by app on 7/13/18.
 */
public class ObservableReturnValueHandler implements HandlerMethodReturnValueHandler {

    @Override
    public boolean supportsReturnType(MethodParameter returnType) {
        Class parameterType = returnType.getParameterType();
        return Observable.class.isAssignableFrom(parameterType);
    }

    @Override
    public void handleReturnValue(Object returnValue,
                                  MethodParameter returnType,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest) throws Exception {
        if(returnValue == null) {
            mavContainer.setRequestHandled(true);
            return;
        }

        final DeferredResult<Object> deferredResult = new DeferredResult<>();
        Observable observable = (Observable) returnValue;
        observable.subscribe(
                result -> deferredResult.setResult(result),
                errors -> deferredResult.setErrorResult(errors)
        );
        WebAsyncUtils.getAsyncManager(webRequest).startDeferredResultProcessing(deferredResult, mavContainer);
    }
}
