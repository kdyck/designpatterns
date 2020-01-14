package com.qarepo.observer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @JavaBean Agency POJO
 */
public class Agency implements Serializable {

    private String alert;
    private List<Observable> observables = new ArrayList<>();

    public Agency() {
    }

    public String getAlert() {
        return alert;
    }

    public void setAlert(String alert) {
        this.alert = alert;
        for (Observable observable : this.observables) {
            // observer.update();
        }
    }

    public List<Observable> getObservables() {
        return observables;
    }

    public void setObservables(List<Observable> observables) {
        this.observables = observables;
    }

    public void addObserver(Observable observable) {
        this.observables.add(observable);
    }

    public void removeObserver(Observable observable) {
        this.observables.remove(observable);
    }

    public void notifyAllObservers() {
        for (Observable observable : observables) {
            // observer.update();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agency agency = (Agency) o;
        return getAlert().equals(agency.getAlert()) &&
                Objects.equals(getObservables(), agency.getObservables());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAlert(), getObservables());
    }

    @Override
    public String toString() {
        return "Agency{" +
                "alert='" + alert + '\'' +
                ", channels=" + observables +
                '}';
    }
}
