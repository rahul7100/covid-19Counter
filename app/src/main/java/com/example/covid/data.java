package com.example.covid;

public class data {
    String state;
    String confirmed;
    String active;
    String recovered;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(String confirmed) {
        this.confirmed = confirmed;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public String getDeaths() {
        return deaths;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }

    public String getNewcases() {
        return newcases;
    }

    public void setNewcases(String newcases) {
        this.newcases = newcases;
    }

    public String getNrecovered() {
        return nrecovered;
    }

    public void setNrecovered(String nrecovered) {
        this.nrecovered = nrecovered;
    }

    public String getNdeath() {
        return ndeath;
    }

    public void setNdeath(String ndeath) {
        this.ndeath = ndeath;
    }

    String deaths;
    String newcases;
    String nrecovered;
    String ndeath;
}
