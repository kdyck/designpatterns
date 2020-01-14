package com.qarepo.observer.pcl;

import com.qarepo.view.MessageTrayIcon;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class PCLObservable {
    private String message;
    private PropertyChangeSupport support;
    private MessageTrayIcon tray = new MessageTrayIcon();

    public PCLObservable() {
        support = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

    public void setMessage(String message) {
        support.firePropertyChange("message", this.message, message);
        tray.displayTray("PCL ALERT", message);
        this.message = message;
    }
}
