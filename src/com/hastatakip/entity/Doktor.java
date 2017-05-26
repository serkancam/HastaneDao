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
public class Doktor {
    private String doktorTC;
    private String doktorAdi;
    private String doktorSoyadi;
    private Date doktorDogumTarihi;
    private byte doktorUzmanlik;

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

    /**
     * @return the doktorAdi
     */
    public String getDoktorAdi() {
        return doktorAdi;
    }

    /**
     * @param doktorAdi the doktorAdi to set
     */
    public void setDoktorAdi(String doktorAdi) {
        this.doktorAdi = doktorAdi;
    }

    /**
     * @return the doktorSoyadi
     */
    public String getDoktorSoyadi() {
        return doktorSoyadi;
    }

    /**
     * @param doktorSoyadi the doktorSoyadi to set
     */
    public void setDoktorSoyadi(String doktorSoyadi) {
        this.doktorSoyadi = doktorSoyadi;
    }

    /**
     * @return the doktorDogumTarihi
     */
    public Date getDoktorDogumTarihi() {
        return doktorDogumTarihi;
    }

    /**
     * @param doktorDogumTarihi the doktorDogumTarihi to set
     */
    public void setDoktorDogumTarihi(Date doktorDogumTarihi) {
        this.doktorDogumTarihi = doktorDogumTarihi;
    }

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

    @Override
    public String toString() {
        return this.doktorTC+"-"+this.doktorAdi+" "+this.doktorSoyadi;
    }

   
    
    
    
    
}
