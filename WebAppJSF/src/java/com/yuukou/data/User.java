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
public class User {

    private String idUser;
    private String nameUser;
    private String resourceUsedByUser;
    private String StartTimeSession;
    private String roomFromResource;
    private String idPicture;
    private ArrayList<History> AllHistoryUser;
    private boolean hasHistory;
    private boolean online;
    private String JSONState;
    private String actualState;
    private String actualSession;

    public User(String idUser, String nameUser) {
        this.idUser = idUser;
        this.nameUser = nameUser;
    }
    

    public User() {
    }

    public User(String idUser, String resourceUsedByUser, String StartTimeSession) {
        this.idUser = idUser;
        this.resourceUsedByUser = resourceUsedByUser;

        if (resourceUsedByUser != null && resourceUsedByUser.split("-").length == 4) {
            String []tab = resourceUsedByUser.split("-");
            this.roomFromResource = tab[0] + "-" + tab[1];
        }
        this.StartTimeSession = StartTimeSession;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public String getStartTimeSession() {
        return StartTimeSession;
    }

    public String getIdPicture() {
        return idPicture;
    }

    public void setIdPicture(String idPicture) {
        this.idPicture = idPicture;
    }

    public void setStartTimeSession(String StartTimeSession) {
        this.StartTimeSession = StartTimeSession;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getResourceUsedByUser() {
        return resourceUsedByUser;
    }

    public void setResourceUsedByUser(String resourceUsedByUser) {
        this.resourceUsedByUser = resourceUsedByUser;
        if (resourceUsedByUser != null && resourceUsedByUser.split("-").length == 4) {
            String []tab = resourceUsedByUser.split("-");
            this.roomFromResource = tab[0] + "-" + tab[1];
        }
    }

    public String getRoomFromResource() {
        return roomFromResource;
    }

    public ArrayList<History> getAllHistoryUser() {
        return AllHistoryUser;
    }

    public void setAllHistoryUser(ArrayList<History> AllHistoryUser) {
        this.AllHistoryUser = AllHistoryUser;
    }

  

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public boolean isHasHistory() {
        return hasHistory;
    }

    public void setHasHistory(boolean hasHistory) {
        this.hasHistory = hasHistory;
    }

    public String getJSONState() {
        return JSONState;
    }

    public void setJSONState(String JSONState) {
        this.JSONState = JSONState;
    }

    public String getActualState() {
        return actualState;
    }

    public void setActualState(String actualState) {
        this.actualState = actualState;
    }

    public String getActualSession() {
        return actualSession;
    }

    public void setActualSession(String actualSession) {
        this.actualSession = actualSession;
    }
    
}
