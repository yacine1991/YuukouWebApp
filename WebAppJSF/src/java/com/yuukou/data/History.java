/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yuukou.data;

/**
 *
 * @author Yacine
 */
public class History {
    private String pcUsed;
    private String actualStatus;
    private String StartTimeSession;
    private String EndTimeSession;
    

    public History() {
    }

    public History(String pcUsed, String actualStatus, String StartTimeSession, String EndTimeSession) {
        this.pcUsed = pcUsed;
        this.actualStatus = actualStatus;
        this.StartTimeSession = StartTimeSession;
        this.EndTimeSession = EndTimeSession;
    }

    public String getEndTimeSession() {
        return EndTimeSession;
    }

    public void setEndTimeSession(String EndTimeSession) {
        this.EndTimeSession = EndTimeSession;
    }

    public String getStartTimeSession() {
        return StartTimeSession;
    }

    public void setStartTimeSession(String StartTimeSession) {
        this.StartTimeSession = StartTimeSession;
    }

    public String getActualStatus() {
        return actualStatus;
    }

    public void setActualStatus(String actualStatus) {
        this.actualStatus = actualStatus;
    }

    public String getPcUsed() {
        return pcUsed;
    }

    public void setPcUsed(String pcUsed) {
        this.pcUsed = pcUsed;
    }
    
    
    
}
