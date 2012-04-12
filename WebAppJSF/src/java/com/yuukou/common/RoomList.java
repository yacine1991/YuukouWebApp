package com.yuukou.common;

import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class RoomList implements Serializable {

    private static final long serialVersionUID = 1L;
   
    private String JSONstate;
    private String JSONmaintenance;
    private String JSONlastCycle;
    private String JSONReason;
    private ArrayList<Room> JSONcontent;
    private int nbMac;
    private int nbPc;

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

   
    public void addRoom(Room room){
        JSONcontent.add(room);
    }

   public Room getRoom(String idRoom){
       for (int i = 0; i < JSONcontent.size(); i++) {
           if(JSONcontent.get(i).getIdRoom().equals(idRoom)){
               return JSONcontent.get(i);
           }
       }
       
       return null;
   }
   public Room getRoom2(int i){
      return JSONcontent.get(i); 
   }
   
   public Room get(int id){
      if(id < 0 || id > JSONcontent.size()){
          return null;
      }
      
      return JSONcontent.get(id);
   }
   
   public int getSize(){
       return JSONcontent.size();
   }
   public int getNumberMac(){
        for (int i = 0; i < JSONcontent.size(); i++) {
           if(JSONcontent.get(i).getIdRoom().startsWith("en")){
               nbMac = nbMac +1;
              
           }
       }
         return nbMac;
   }
   
      public int getNumberPc(){
        for (int i = 0; i < JSONcontent.size(); i++) {
           if(!JSONcontent.get(i).getIdRoom().startsWith("en")){
               nbPc = nbPc +1;
              
           }
       }
         return nbPc;
   }
    
    
}