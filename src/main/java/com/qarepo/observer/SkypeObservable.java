package com.qarepo.observer;


import com.qarepo.view.MessageTrayIcon;

public class SkypeObservable implements Observable {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void update(Observer observer, Object obj) {
        MessageTrayIcon tray = new MessageTrayIcon();
        tray.displayTray("SKYPE ALERT", obj.toString());
    }
}
