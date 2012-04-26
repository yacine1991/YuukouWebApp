package com.yuukou.common;

import java.io.Serializable;
import java.util.ArrayList;

public class RoomList implements Serializable {

    private static final long serialVersionUID = 1L;
    private String JSONstate;
    private String JSONmaintenance;
    private String JSONlastCycle;
    private String JSONReason;
    private ArrayList<Room> JSONcontent;
    private int nbMac;
    private int nbPc;
    private int nbPcCavendish;
    private int nbPcLittleTich;
    private int nbPcRegent;
    private int nbPcHarrow;
    private int nbPcMarylebone;
    private int nbPcECS;
    private int nbPcAvailable;
    private int nbPcDown;
    private int nbRoomAvailable;
    private int nbRoomBusy;

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

    public void addRoom(Room room) {
        JSONcontent.add(room);
    }

    public Room getRoom(String idRoom) {
        for (int i = 0; i < JSONcontent.size(); i++) {
            if (JSONcontent.get(i).getIdRoom().equals(idRoom)) {
                return JSONcontent.get(i);
            }
        }

        return null;
    }

    public Room getRoom2(int i) {
        return JSONcontent.get(i);
    }

    public Room get(int id) {
        if (id < 0 || id > JSONcontent.size()) {
            return null;
        }

        return JSONcontent.get(id);
    }

    public int getSize() {
        return JSONcontent.size();
    }

    public int getNumberMac() {
        nbMac = 0;
        for (int i = 0; i < JSONcontent.size(); i++) {
            if (JSONcontent.get(i).getTypeResource().equals("mc")) {
                nbMac = nbMac + 1;
            }
        }

        return nbMac;
    }

    public int getNumberPc() {
        nbPc = 0;
        for (int i = 0; i < JSONcontent.size(); i++) {
            if (JSONcontent.get(i).getTypeResource().equals("pc")) {
                nbPc = nbPc + 1;

            }

        }

        return nbPc;
    }

    public int getNbComputerRoomsRegent() {
        nbPcRegent = 0;
        for (int i = 0; i < JSONcontent.size(); i++) {
            if (JSONcontent.get(i).getLongLocation().equals("Regent")) {
                nbPcRegent = nbPcRegent + 1;
            }
        }
        return nbPcRegent;
    }

    public int getNbComputerRoomsCavendish() {
        nbPcCavendish = 0;
        for (int i = 0; i < JSONcontent.size(); i++) {
            if (JSONcontent.get(i).getLongLocation().equals("New Cavendish Street")) {
                nbPcCavendish = nbPcCavendish + 1;
            }
        }
        return nbPcCavendish;
    }

    public int getNbComputerRoomsLittleTich() {
        nbPcLittleTich = 0;
        for (int i = 0; i < JSONcontent.size(); i++) {
            if (JSONcontent.get(i).getLongLocation().equals("Little Titchfield Street")) {
                nbPcLittleTich = nbPcLittleTich + 1;
            }
        }
        return nbPcLittleTich;
    }

    public int getNbComputerRoomsHarrow() {
        nbPcHarrow = 0;
        for (int i = 0; i < JSONcontent.size(); i++) {
            if (JSONcontent.get(i).getLongLocation().equals("Harrow")) {
                nbPcHarrow = nbPcHarrow + 1;
            }
        }
        return nbPcHarrow;
    }

    public int getNbComputerRoomsMarylebone() {
        nbPcMarylebone = 0;
        for (int i = 0; i < JSONcontent.size(); i++) {
            if (JSONcontent.get(i).getLongLocation().equals("Marylebone")) {
                nbPcMarylebone = nbPcMarylebone + 1;
            }
        }
        return nbPcMarylebone;
    }

    public int getNbComputerRoomsECS() {
        nbPcECS = 0;
        for (int i = 0; i < JSONcontent.size(); i++) {
            if (JSONcontent.get(i).getLongLocation().equals("Electronics and Computer Science")) {
                nbPcECS = nbPcECS + 1;
            }
        }
        return nbPcECS;
    }

    public int getNumberComputerAvailableForAllCampus() {
        nbPcAvailable = 0;
        int swap;
        for (int i = 0; i < JSONcontent.size(); i++) {
            swap = Integer.parseInt(JSONcontent.get(i).getPcAvailable());
            nbPcAvailable = nbPcAvailable + swap;

        }
        return nbPcAvailable;
    }

    public int getNumberComputerDownForAllCampus() {
        nbPcDown = 0;
        int swap;
        for (int i = 0; i < JSONcontent.size(); i++) {
            swap = Integer.parseInt(JSONcontent.get(i).getPcDown());
            nbPcDown = nbPcDown + swap;

        }
        return nbPcDown;
    }

    public int getNumberComputerBusyForAllCampus() {
        int nbPcBusy = 0;
        int swap;
        for (int i = 0; i < JSONcontent.size(); i++) {
            swap = Integer.parseInt(JSONcontent.get(i).getBusy());
            nbPcBusy = nbPcBusy + swap;

        }
        return nbPcBusy;
    }

    public int getNumberRoomAvailableForAllCampus() {
        nbRoomAvailable = 0;
        for (int i = 0; i < JSONcontent.size(); i++) {
            if (JSONcontent.get(i).getStatus().equals("Available")) {
                nbRoomAvailable = nbRoomAvailable + 1;
            }
        }

        return nbRoomAvailable;

    }

    public int getNumberRoomBusyForAllCampus() {
        nbRoomBusy = 0;
        for (int i = 0; i < JSONcontent.size(); i++) {
            if (!JSONcontent.get(i).getStatus().equals("Available")) {
                nbRoomBusy = nbRoomBusy + 1;
            }
        }

        return nbRoomBusy;
    }

    public int getNumberRoomBusyPerCampus(String campus) {
        int nbRoomBusyPerCampus = 0;
        for (int i = 0; i < JSONcontent.size(); i++) {
            if (JSONcontent.get(i).getLongLocation().equals(campus) && !JSONcontent.get(i).getStatus().equals("Available")) {
                nbRoomBusyPerCampus = nbRoomBusyPerCampus + 1;
            }
        }

        return nbRoomBusyPerCampus;
    }

    public int getNumberRoomAvailablePerCampus(String campus) {
        int nbRoomAvailablePerCampus = 0;
        for (int i = 0; i < JSONcontent.size(); i++) {
            if (JSONcontent.get(i).getLongLocation().equals(campus) && JSONcontent.get(i).getStatus().equals("Available")) {
                nbRoomAvailablePerCampus = nbRoomAvailablePerCampus + 1;
            }
        }

        return nbRoomAvailablePerCampus;
    }

    public int getNumberComputerAvailablePerCampus(String campus) {
        int nbPcAvailablePerCampus = 0;
        int swap;
        for (int i = 0; i < JSONcontent.size(); i++) {
            if (JSONcontent.get(i).getLongLocation().equals(campus)) {
                swap = Integer.parseInt(JSONcontent.get(i).getPcAvailable());
                nbPcAvailablePerCampus = nbPcAvailablePerCampus + swap;
            }

        }
        return nbPcAvailablePerCampus;
    }

    public int getNumberComputerDownPerCampus(String campus) {
        int nbPcDownPerCampus = 0;
        int swap;
        for (int i = 0; i < JSONcontent.size(); i++) {
            if (JSONcontent.get(i).getLongLocation().equals(campus)) {
                swap = Integer.parseInt(JSONcontent.get(i).getPcDown());
                nbPcDownPerCampus = nbPcDownPerCampus + swap;
            }

        }
        return nbPcDownPerCampus;
    }

    public int getNumberComputerBusyPerCampus(String campus) {
        int nbPcBusyPerCampus = 0;
        int swap;
        for (int i = 0; i < JSONcontent.size(); i++) {
            if (JSONcontent.get(i).getLongLocation().equals(campus)) {
                swap = Integer.parseInt(JSONcontent.get(i).getBusy());
                nbPcBusyPerCampus = nbPcBusyPerCampus + swap;
            }

        }
        return nbPcBusyPerCampus;
    }

    public ArrayList<String> getCampus() {

        ArrayList<String> listCampus = new ArrayList<String>();
        String campus;
        for (int i = 0; i < JSONcontent.size(); i++) {
            campus = JSONcontent.get(i).getLongLocation();
            if (!listCampus.contains(campus)) {
                listCampus.add(campus);
            }
        }
        return listCampus;
    }

    public ArrayList<String> getCampusShort() {

        ArrayList<String> listCampus = new ArrayList<String>();
        String campus;
        for (int i = 0; i < JSONcontent.size(); i++) {
            campus = JSONcontent.get(i).getShortDescription();
            if (!listCampus.contains(campus)) {
                listCampus.add(campus);
            }
        }
        return listCampus;
    }
}