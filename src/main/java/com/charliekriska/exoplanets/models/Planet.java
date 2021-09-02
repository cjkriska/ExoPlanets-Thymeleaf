package com.charliekriska.exoplanets.models;

public class Planet {

    private String pl_name;
    private String hostname;
    private String pl_bmasse;
    private String pl_rade;
    private String pl_eqt;
    private String discoverymethod;
    private String disc_year;
    private String sy_dist;

    // Constructors
    public Planet () {}
    public Planet(String pl_name, String hostname, String pl_bmasse, String pl_rade, String pl_eqt,
                  String discoverymethod, String disc_year, String sy_dist) {
        this.pl_name = pl_name;
        this.hostname = hostname;
        this.pl_bmasse = pl_bmasse;
        this.pl_rade = pl_rade;
        this.pl_eqt = pl_eqt;
        this.discoverymethod = discoverymethod;
        this.disc_year = disc_year;
        this.sy_dist = sy_dist;
    }

    // Getters & Setters
    public String getPl_name() {
        return pl_name;
    }
    public void setPl_name(String pl_name) {
        this.pl_name = pl_name;
    }
    public String getHostname() {
        return hostname;
    }
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }
    public String getPl_bmasse() {
        return pl_bmasse;
    }
    public void setPl_bmasse(String pl_bmasse) {
        this.pl_bmasse = pl_bmasse;
    }
    public String getPl_rade() {
        return pl_rade;
    }
    public void setPl_rade(String pl_rade) {
        this.pl_rade = pl_rade;
    }
    public String getPl_eqt() {
        return pl_eqt;
    }
    public void setPl_eqt(String pl_eqt) {
        this.pl_eqt = pl_eqt;
    }
    public String getDiscoverymethod() {
        return discoverymethod;
    }
    public void setDiscoverymethod(String discoverymethod) {
        this.discoverymethod = discoverymethod;
    }
    public String getDisc_year() {
        return disc_year;
    }
    public void setDisc_year(String disc_year) {
        this.disc_year = disc_year;
    }
    public String getSy_dist() {
        return sy_dist;
    }
    public void setSy_dist(String sy_dist) {
        this.sy_dist = sy_dist;
    }
}
