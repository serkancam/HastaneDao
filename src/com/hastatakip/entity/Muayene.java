/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hastatakip.entity;

import java.util.Date;

/**
 *
 * @author serkancam
 */
public class Muayene {
    private int muayeneId;
    private Date muayeneTarihi;
    private String hastaTC;
    private String doktorTC;

    /**
     * @return the muayeneId
     */
    public int getMuayeneId() {
        return muayeneId;
    }

    /**
     * @param muayeneId the muayeneId to set
     */
    public void setMuayeneId(int muayeneId) {
        this.muayeneId = muayeneId;
    }

    /**
     * @return the muayeneTarihi
     */
    public Date getMuayeneTarihi() {
        return muayeneTarihi;
    }

    /**
     * @param muayeneTarihi the muayeneTarihi to set
     */
    public void setMuayeneTarihi(Date muayeneTarihi) {
        this.muayeneTarihi = muayeneTarihi;
    }

    /**
     * @return the hastaTC
     */
    public String getHastaTC() {
        return hastaTC;
    }

    /**
     * @param hastaTC the hastaTC to set
     */
    public void setHastaTC(String hastaTC) {
        this.hastaTC = hastaTC;
    }

    /**
     * @return the doktorTC
     */
    public String getDoktorTC() {
        return doktorTC;
    }

    /**
     * @param doktorTC the doktorTC to set
     */
    public void setDoktorTC(String doktorTC) {
        this.doktorTC = doktorTC;
    }

    @Override
    public String toString() {
        return this.muayeneId+"-"+this.getMuayeneTarihi().toString();
    }
    
    
    
}
