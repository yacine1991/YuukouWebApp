package com.yuukou.common;

import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class RoomList implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;
    private String JSONstate;
    private String JSONmaintenance;
    private String JSONlastCycle;
    private String JSONReason;
    private ArrayList<Room> JSONcontent;

    public RoomList() {
        JSONcontent = new ArrayList<Room>();
        
    }

    public String getJSONReason() {
        return JSONReason;
    }

    public void setJSONReason(String JSONReason) {
        this.JSONReason = JSONReason;
    }

    public ArrayList<Room> getJSONcontent() {
        return JSONcontent;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void addRoom(Room room){
        JSONcontent.add(room);
    }

   
    
    
}