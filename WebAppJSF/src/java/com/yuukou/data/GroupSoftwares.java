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
public class GroupSoftwares {
    
    private String idGroup;
    private String descriptionGroup;
    private ArrayList<Software> SoftwareContents;
   
    private String HasSoftwareContents;

    

    public String getHasSoftwareContents() {
        return HasSoftwareContents;
    }

    public void setHasSoftwareContents(String HasSoftwareContents) {
        this.HasSoftwareContents = HasSoftwareContents;
    }

    public ArrayList<Software> getSoftwareContents() {
        return SoftwareContents;
    }

    public void setSoftwareContents(ArrayList<Software> SoftwareContents) {
        this.SoftwareContents = SoftwareContents;
    }

   
    
    public String getDescriptionGroup() {
        return descriptionGroup;
    }

    public void setDescriptionGroup(String descriptionGroup) {
        this.descriptionGroup = descriptionGroup;
    }

    public String getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(String idGroup) {
        this.idGroup = idGroup;
    }

   
    
    
    
}
