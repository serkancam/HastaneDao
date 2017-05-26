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
public class Ilac {
    private int ilacId;
    private String ilacAdi;

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
     * @return the ilacAdi
     */
    public String getIlacAdi() {
        return ilacAdi;
    }

    /**
     * @param ilacAdi the ilacAdi to set
     */
    public void setIlacAdi(String ilacAdi) {
        this.ilacAdi = ilacAdi;
    }

    @Override
    public String toString() {
        return this.ilacId+"-"+this.ilacAdi; //To change body of generated methods, choose Tools | Templates.
    }
    
        
}
