/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yuukou.data;

import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Yacine
 */
public class LocationList {

    private Map<String, Location> mapList;

    public LocationList() {
        mapList = new TreeMap<String, Location>();
    }

    public void add(String id, Location location) {
        mapList.put(id, location);
    }

    public Location get(String id) {
        return mapList.get(id);
    }

    public int size() {
        return mapList.size();
    }

    public boolean contains(String id) {
        return mapList.containsKey(id);
    }
}
