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
public class Hasta{
        private String hastaTC;
        private String HastaAdi;
        private String hastaSoyadi;
        private Date hastaDogumTarihi;

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
     * @return the HastaAdi
     */
    public String getHastaAdi() {
        return HastaAdi;
    }

    /**
     * @param HastaAdi the HastaAdi to set
     */
    public void setHastaAdi(String HastaAdi) {
        this.HastaAdi = HastaAdi;
    }

    /**
     * @return the hastaSoyadi
     */
    public String getHastaSoyadi() {
        return hastaSoyadi;
    }

    /**
     * @param hastaSoyadi the hastaSoyadi to set
     */
    public void setHastaSoyadi(String hastaSoyadi) {
        this.hastaSoyadi = hastaSoyadi;
    }

    /**
     * @return the hastaDogumTarihi
     */
    public Date getHastaDogumTarihi() {
        return hastaDogumTarihi;
    }

    /**
     * @param hastaDogumTarihi the hastaDogumTarihi to set
     */
    public void setHastaDogumTarihi(Date hastaDogumTarihi) {
        this.hastaDogumTarihi = hastaDogumTarihi;
    }

    @Override
    public String toString() {
        return this.hastaTC+"-"+this.HastaAdi+" "+this.hastaSoyadi;
    }
    
        
    
}
