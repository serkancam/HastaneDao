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
public class DoktorUzmanlik 
{
    private byte doktorUzmanlik;
    private String doktorUzmanlikAdi;

    /**
     * @return the doktorUzmanlik
     */
    public byte getDoktorUzmanlik() {
        return doktorUzmanlik;
    }

    /**
     * @param doktorUzmanlik the doktorUzmanlik to set
     */
    public void setDoktorUzmanlik(byte doktorUzmanlik) {
        this.doktorUzmanlik = doktorUzmanlik;
    }

    /**
     * @return the doktorUzmanlikAdi
     */
    public String getDoktorUzmanlikAdi() {
        return doktorUzmanlikAdi;
    }

    /**
     * @param doktorUzmanlikAdi the doktorUzmanlikAdi to set
     */
    public void setDoktorUzmanlikAdi(String doktorUzmanlikAdi) {
        this.doktorUzmanlikAdi = doktorUzmanlikAdi;
    }

    @Override
    public String toString() {
        return this.doktorUzmanlik+"-"+this.doktorUzmanlikAdi; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
