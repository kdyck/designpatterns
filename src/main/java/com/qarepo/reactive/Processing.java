package com.qarepo.reactive;

import java.util.concurrent.Flow;

/**
 * This Processing class transforms an incoming message and
 * passes it to the next Subscriber by implementing the Processor interface methods.
 * Processing acts both as a Subscriber because it receives messages,
 * and as the Publisher because it processes those messages and sends them for further processing.
 */
public class Processing implements Flow.Processor {
    @Override
    public void subscribe(Flow.Subscriber subscriber) {

    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {

    }

    @Override
    public void onNext(Object item) {

    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onComplete() {

    }
}
