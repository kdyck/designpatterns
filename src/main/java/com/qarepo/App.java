package com.qarepo;

import com.qarepo.observer.*;
import com.qarepo.observer.MessageBoard;
import com.qarepo.observer.pcl.PCLObservable;
import com.qarepo.observer.pcl.PCLObserver;
import org.testng.Assert;

public class App {
    public static void main(String[] args) {

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
