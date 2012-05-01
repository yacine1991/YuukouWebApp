/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yuukou.data;

/**
 *
 * @author Yacine
 */
public class TimeTable {
    private String StartTime;
    private String EndTime;
    private String EventType;
    private String EventDescription;

    public TimeTable(String StartTime, String EndTime, String EventType, String EventDescription) {
        this.StartTime = StartTime;
        this.EndTime = EndTime;
        this.EventType = EventType;
        this.EventDescription = EventDescription;
    }

    public String getEndTime() {
        return EndTime;
    }

    public void setEndTime(String EndTime) {
        this.EndTime = EndTime;
    }

    public String getEventDescription() {
        return EventDescription;
    }

    public void setEventDescription(String EventDescription) {
        this.EventDescription = EventDescription;
    }

    public String getEventType() {
        return EventType;
    }

    public void setEventType(String EventType) {
        this.EventType = EventType;
    }

    

    public String getStartTime() {
        return StartTime;
    }

    public void setStartTime(String StartTime) {
        this.StartTime = StartTime;
    }
    
    
    
    
    
}
