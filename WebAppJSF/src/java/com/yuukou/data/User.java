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
    private String resourceUsedByUser;
    private String StartTimeSession;
    private String roomFromResource;
    private String idPicture;
    

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
}
