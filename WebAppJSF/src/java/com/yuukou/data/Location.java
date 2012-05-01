/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yuukou.data;

/**
 *
 * @author Yacine
 */
public class Location {

    private String id;
    private String shortLocation;
    private String longLocation;

    public Location(String id, String shortLocation, String longLocation) {
        this.id = id;
        this.shortLocation = shortLocation;
        this.longLocation = longLocation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLongLocation() {
        return longLocation;
    }

    public void setLongLocation(String longLocation) {
        this.longLocation = longLocation;
    }

    public String getShortLocation() {
        return shortLocation;
    }

    public void setShortLocation(String shortLocation) {
        this.shortLocation = shortLocation;
    }
}
