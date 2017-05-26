/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hastatakip.entity;

/**
 *
 * @author serkancam
 */
public class VerilenIlac {
    private int verilenIlacId;
    private int ilacId;
    private int muayeneId;
    
     /**
     * @return the verilenIlacId
     */
    public int getVerilenIlacId() {
        return verilenIlacId;
    }

    /**
     * @param verilenIlacId the ilacId to set
     */
    public void setVerilenIlacId(int verilenIlacId) {
        this.verilenIlacId = verilenIlacId;
    }
    

    /**
     * @return the ilacId
     */
    public int getIlacId() {
        return ilacId;
    }

    /**
     * @param ilacId the ilacId to set
     */
    public void setIlacId(int ilacId) {
        this.ilacId = ilacId;
    }

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
        
}
