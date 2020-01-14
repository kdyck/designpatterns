package com.qarepo.observer;

import java.io.Serializable;
import java.util.Objects;

public class MessageBoard extends Observer implements Serializable {
    private String message;

    public MessageBoard() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
        setChangeFlag(true);
        notifyObservers(message);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MessageBoard that = (MessageBoard) o;
        return message.equals(that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), message);
    }

    @Override
    public String toString() {
        return "MessageBoard{" +
                "message='" + message + '\'' +
                ", obsvrList=" + observables +
                ", changeFlag=" + changeFlag +
                '}';
    }
}
