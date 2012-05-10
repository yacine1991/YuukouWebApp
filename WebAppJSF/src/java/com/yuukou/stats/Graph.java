package com.yuukou.stats;

import java.io.File;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yacine
 */

public class Graph{

  private String JSONstate;
    private String JSONlastCycle;
    private String JSONmaintenance;
    private String JSONReason;
    private String HasData;
    private String ImageType;
    private String [] ContentsValues;
    private String [] ContentsDates;
    private String [] Image;
    private File ImageFile;

    public File getImageFile() {
        return ImageFile;
    }

    public void setImageFile(File ImageFile) {
        this.ImageFile = ImageFile;
    }

    public String[] getContentsDates() {
        return ContentsDates;
    }

    public void setContentsDates(String[] ContentsDates) {
        this.ContentsDates = ContentsDates;
    }

    public String[] getContentsValues() {
        return ContentsValues;
    }

    public void setContentsValues(String[] ContentsValues) {
        this.ContentsValues = ContentsValues;
    }

    public String[] getImage() {
        return Image;
    }

    public void setImage(String[] Image) {
        this.Image = Image;
    }



    public String getHasData() {
        return HasData;
    }

    public void setHasData(String HasData) {
        this.HasData = HasData;
    }



    public String getImageType() {
        return ImageType;
    }

    public void setImageType(String ImageType) {
        this.ImageType = ImageType;
    }

    public String getJSONReason() {
        return JSONReason;
    }

    public void setJSONReason(String JSONReason) {
        this.JSONReason = JSONReason;
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
    
 
    
}
