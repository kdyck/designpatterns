package com.qarepo.observer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Observer implements Serializable {
    ArrayList<Observable> observables = new ArrayList<>();
    boolean changeFlag = false;

    public Observer() {
    }

    public void notifyObservers(Object obj) {
        if (isChangeFlag()) {
            for (Observable observable : observables) {
                observable.update(this, obj);
            }
            setChangeFlag(false);
        }
    }

    public void addObserver(Observable observable) {
        observables.add(observable);
    }

    public void removeObserver(Observable observable) {
        System.out.println("Removing ----> " + observable);
        observables.remove(observable);
    }

    public ArrayList<Observable> getObservables() {
        return observables;
    }

    public void setObservables(ArrayList<Observable> observables) {
        this.observables = observables;
    }

    public boolean isChangeFlag() {
        return changeFlag;
    }

    public void setChangeFlag(boolean changeFlag) {
        this.changeFlag = changeFlag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Observer that = (Observer) o;
        return changeFlag == that.changeFlag &&
                observables.equals(that.observables);
    }

    @Override
    public int hashCode() {
        return Objects.hash(observables, changeFlag);
    }
}
