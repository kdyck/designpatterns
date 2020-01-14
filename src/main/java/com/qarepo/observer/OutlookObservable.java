package com.qarepo.observer;

public class OutlookObservable implements Observable {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void update(Observer observer, Object obj) {
        System.out.println("OUTLOOK ALERT: " + obj);
    }
}
