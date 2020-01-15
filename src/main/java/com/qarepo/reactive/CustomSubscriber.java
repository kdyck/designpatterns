package com.qarepo.reactive;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.atomic.AtomicInteger;

public class CustomSubscriber<T> implements Subscriber<T> {
    private static final Logger LOGGER = LogManager.getLogger(CustomSubscriber.class);
    private StringWriter sw = new StringWriter();

    private final AtomicInteger howMuchMessagesToConsume;
    private Subscription subscription;
    public List<T> consumedElements = new LinkedList<>();

    public CustomSubscriber(Integer howMuchMessagesToConsume) {
        this.howMuchMessagesToConsume = new AtomicInteger(howMuchMessagesToConsume);;
    }

    /**
     * Needs to be invoked before calling any message processing or
     * other subscribers methods. Enables receiving items.
     *
     * @param subscription an instance used to control the flow of messages.
     */
    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1);
    }

    /**
     * Invokes subscriptions new item.
     *
     * @param item the item.
     */
    @Override
    public void onNext(T item) {
        howMuchMessagesToConsume.decrementAndGet();
        LOGGER.info("Received : " + item);
        consumedElements.add(item);
        if (howMuchMessagesToConsume.get() > 0) {
            subscription.request(1);
        }
    }

    /**
     * Invoked upon an unrecoverable error encountered by Publisher or Subscription.
     * No other subscription is invoked after this is thrown.
     *
     * @param throwable exception
     */
    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace(new PrintWriter(sw));
        LOGGER.error("Exception: " + sw.toString());
    }

    /**
     * Invoked when no other subscriber method
     * invocations will occur for a Subscription.
     */
    @Override
    public void onComplete() {
        LOGGER.info(" Done");
    }
}
