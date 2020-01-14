package com.qarepo.reactive;


import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Flow;

public class CustomSubscriber<T> implements Flow.Subscriber<T> {

    private Flow.Subscription subscription;
    public List<T> consumerElements = new LinkedList<>();

    /**
     * Called before message processing starts.
     *
     * @param subscription instance is passed as an argument and is used
     *                     to control the flow of messages between Subscriber and Publisher
     */
    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1);
    }

    /**
     * Called whenever the Publisher publishes a new message.
     *
     * @param item
     */
    @Override
    public void onNext(T item) {
        System.out.println("Got : " + item);
        subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onComplete() {

    }
}
