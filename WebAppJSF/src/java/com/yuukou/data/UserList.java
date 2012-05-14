package com.yuukou.data;

import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yacine
 */
public class UserList {
    private String JSONstate;
    private String JSONmaintenance;
    private String JSONlastCycle;
    private String JSONReason;
    private ArrayList<User> JSONcontent;

    public UserList() {
        this.JSONcontent = new ArrayList<User>();
    }

    public UserList(ArrayList<User> JSONcontent) {
        this.JSONcontent = JSONcontent;
    }

    public String getJSONReason() {
        return JSONReason;
    }

    public void setJSONReason(String JSONReason) {
        this.JSONReason = JSONReason;
    }

    public ArrayList<User> getJSONcontent() {
        return JSONcontent;
    }

    public void setJSONcontent(ArrayList<User> JSONcontent) {
        this.JSONcontent = JSONcontent;
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
    
    public void addUser(User user) {
        JSONcontent.add(user);
    }
    
    public ArrayList<User> getUsersForRoom(String room) {
        int nbRoomBusyPerCampus = 0;
        ArrayList<User>UserforRoom = null;
        for (int i = 0; i < JSONcontent.size(); i++) {
            if (JSONcontent.get(i).getIdUser().startsWith(room)) {
                UserforRoom.add((User) JSONcontent.get(i));
            }
        }

        return UserforRoom;
    }
    
    public int size(){
        return this.JSONcontent.size();
    }
}
