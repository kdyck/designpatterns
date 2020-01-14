package com.qarepo.observer;

import java.io.Serializable;


public interface Observable extends Serializable {
    public void update(Observer observer, Object obj);
}
