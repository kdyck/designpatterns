package com.qarepo.observer.pcl;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PCLObserver implements PropertyChangeListener {
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void propertyChange(PropertyChangeEvent evt) {
        this.setMessage((String) evt.getNewValue());
    }
}
