/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yuukou.data;

/**
 *
 * @author Yacine
 */
public class Software {
    private String idSoftware;
    private String descriptionSoftware;

    public Software(String idSoftware, String descriptionSoftware) {
        this.idSoftware = idSoftware;
        this.descriptionSoftware = descriptionSoftware;
    }

    public Software(String idSoftware) {
        this.idSoftware = idSoftware;
    }

    public String getDescriptionSoftware() {
        return descriptionSoftware;
    }

    public void setDescriptionSoftware(String descriptionSoftware) {
        this.descriptionSoftware = descriptionSoftware;
    }

    public String getIdSoftware() {
        return idSoftware;
    }

    public void setIdSoftware(String idSoftware) {
        this.idSoftware = idSoftware;
    }
    
    
}
