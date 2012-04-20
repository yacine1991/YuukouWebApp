/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yuukou.common;

import java.io.File;

/**
 *
 * @author Yacine
 */
public class Room {

    private String idRoom;
    private String healthRoom;
    private String availability;
    private String pcDown;
    private String pcAvailable;
    private String status;
    private String resources;
    private String typeResource;
    private String startTime;
    private String endTime;
    private String eventType;
    private String busy;
    private String ShortDescription;
    private String LongDescription;
    private String Description;
    private boolean HasImage;
    private File Image;
    private String JSONstate;
    private String JSONlastCycle;
    private String JSONmaintenance;
    private String JSONReason;

    public String getJSONlastCycle() {
        return JSONlastCycle;
    }

    public String getJSONReason() {
        return JSONReason;
    }

    public void setJSONReason(String JSONReason) {
        this.JSONReason = JSONReason;
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

    public File getImage() {
        return Image;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getLongDescription() {
        return LongDescription;
    }

    public void setLongDescription(String LongDescription) {
        this.LongDescription = LongDescription;
    }

    public String getShortDescription() {
        return ShortDescription;
    }

    public void setShortDescription(String ShortDescription) {
        this.ShortDescription = ShortDescription;
    }

    public String getBusy() {
        return busy;
    }

    public void setBusy(String busy) {
        this.busy = busy;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getHealthRoom() {
        return healthRoom;
    }

    public void setHealthRoom(String healthRoom) {
        this.healthRoom = healthRoom;
    }

    public String getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(String idRoom) {
        this.idRoom = idRoom;
    }

    public String getPcAvailable() {
        return pcAvailable;
    }

    public void setPcAvailable(String pcAvailable) {
        this.pcAvailable = pcAvailable;
    }

    public String getPcDown() {
        return pcDown;
    }

    public void setPcDown(String pcDown) {
        this.pcDown = pcDown;
    }

    public String getResources() {
        return resources;
    }

    public void setResources(String resources) {
        this.resources = resources;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTypeResource() {
        return typeResource;
    }

    public void setTypeResource(String typeResource) {
        this.typeResource = typeResource;
    }

    public boolean getHasImage() {
        return HasImage;
    }

    public void setHasImage(boolean HasImage) {
        this.HasImage = HasImage;
    }

    public void setImage(File Image) {
        this.Image = Image;
    }

    public String getImagePath() {
        return this.Image.getPath();
    }

    public void toDoIfHasImage() {
        if (this.getHasImage() == true) {
        }
    }

    public String getJSONstate() {
        return JSONstate;
    }

    public void setJSONstate(String JSONstate) {
        this.JSONstate = JSONstate;
    }
}
