package com.qarepo;

import com.qarepo.observer.*;
import com.qarepo.observer.MessageBoard;
import com.qarepo.observer.pcl.PCLObservable;
import com.qarepo.observer.pcl.PCLObserver;
import com.qarepo.pubsub.config.AMQPConfig;
import com.qarepo.pubsub.message.MessageReceiver;
import com.rabbitmq.client.Channel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.testng.Assert;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

// @SpringBootApplication
public class App {
    static final String QUEUE_NAME = "banners_rpc_queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        /*
         * Pub-Sub & RPC Pattern Implementation
         */
        // SpringApplication.run(App.class, args);
        Channel channel = AMQPConfig.connect();
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        // QUEUE Consumer
        MessageReceiver receiver = new MessageReceiver();
        receiver.receive(QUEUE_NAME);

        /*
         * Observer Pattern Implementation
         */
        MessageBoard boardObservable = new MessageBoard();
        SkypeObservable skypeObserver = new SkypeObservable();
        OutlookObservable outlookObserver = new OutlookObservable();

        boardObservable.addObserver(skypeObserver);
        boardObservable.addObserver(outlookObserver);
        boardObservable.setMessage("New 'Message Board' Alerts Available!");
        Assert.assertEquals(boardObservable.getMessage(), "New 'Message Board' Alerts Available!");

        boardObservable.removeObserver(skypeObserver);
        boardObservable.addObserver(outlookObserver);

        outlookObserver.setMessage("Test");
        boardObservable.setMessage(outlookObserver.getMessage());
        Assert.assertEquals(boardObservable.getMessage(), "Test");

        /*
         * Observer Pattern Implementation with PropertyChangeListener
         */
        PCLObservable pclObservable = new PCLObservable();
        PCLObserver pclObserver = new PCLObserver();

        pclObservable.addPropertyChangeListener(pclObserver);
        pclObservable.setMessage("New 'PCL' Alerts Available!");

        Assert.assertEquals(pclObserver.getMessage(), "New 'PCL' Alerts Available!");

        /*
         * Java 9 Reactive Streams
         * https://www.baeldung.com/java-9-reactive-streams
         */

    }
}
