/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yuukou.data;

import java.util.ArrayList;

/**
 *
 * @author Yacine
 */
public class Computer {

    private String RessourceName;
    private String RessouceRoom;
    private String LastTimeSeen;
    private String RessourceStatus;
    private String JSONstate;
    private String JSONlastCycle;
    private String JSONmaintenance;
    private String JSONReason;
    private boolean HasContents;
    private boolean HasPreviousUser;
    private ArrayList<User> PreviousUsers;

    public ArrayList<User> getPreviousUsers() {
        return PreviousUsers;
    }

    public boolean isHasPreviousUser() {
        return HasPreviousUser;
    }

    public void setHasPreviousUser(boolean HasPreviousUser) {
        this.HasPreviousUser = HasPreviousUser;
    }

    public void setPreviousUsers(ArrayList<User> PreviousUsers) {
        this.PreviousUsers = PreviousUsers;
    }
    

    public Computer() {
    }

    public Computer(String RessourceRoom, String RessourceName, String LastTimeSeen, String RessourceStatus) {
        this.RessourceName = RessourceName;
        this.LastTimeSeen = LastTimeSeen;
        this.RessourceStatus = RessourceStatus;
        this.RessouceRoom = RessourceRoom;
    }

    public String getRessouceRoom() {
        return RessouceRoom;
    }

    public void setRessouceRoom(String RessouceRoom) {
        this.RessouceRoom = RessouceRoom;
    }

    public String getLastTimeSeen() {
        return LastTimeSeen;
    }

    public void setLastTimeSeen(String LastTimeSeen) {
        this.LastTimeSeen = LastTimeSeen;
    }

    public String getRessourceName() {
        return RessourceName;
    }

    public void setRessourceName(String RessourceName) {
        this.RessourceName = RessourceName;
    }

    public String getRessourceStatus() {
        return RessourceStatus;
    }

    public void setRessourceStatus(String RessourceStatus) {
        this.RessourceStatus = RessourceStatus;
    }

    public String getJSONReason() {
        return JSONReason;
    }

    public void setJSONReason(String JSONReason) {
        this.JSONReason = JSONReason;
    }

    public String getJSONlastCycle() {
        return JSONlastCycle;
    }

    public void setJSONlastCycle(String JSONlastCycle) {
        this.JSONlastCycle = JSONlastCycle;
    }

    public String getJSONmaintenance() {
        return JSONmaintenance;
    }

    public void setJSONmaintenance(String JSONmaintenance) {
        this.JSONmaintenance = JSONmaintenance;
    }

    public String getJSONstate() {
        return JSONstate;
    }

    public void setJSONstate(String JSONstate) {
        this.JSONstate = JSONstate;
    }

    public Boolean getHasContents() {
        return HasContents;
    }

    public void setHasContents(Boolean HasContents) {
        this.HasContents = HasContents;
    }
}
