/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dersane.Connection;

/**
 *
 * @author Sukriye
 */
public class Personeller {
    private String tc;
    private String ad;
     private String soyad;

    
     private String sube;
     private String sicil_no;
     
     private String telefon;
     private String cinsiyet;
     
     private String medeni_hal;
     private String adres;
     private String maas;
     private String meslek;

    public String getTc() {
        return tc;
    }

    public void setTc(String tc) {
        this.tc = tc;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getSube() {
        return sube;
    }

    public void setSube(String sube) {
        this.sube = sube;
    }

    public String getSicil_no() {
        return sicil_no;
    }

    public void setSicil_no(String sicil_no) {
        this.sicil_no = sicil_no;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public String getMedeni_hal() {
        return medeni_hal;
    }

    public void setMedeni_hal(String medeni_hal) {
        this.medeni_hal = medeni_hal;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getMaas() {
        return maas;
    }

    public void setMaas(String maas) {
        this.maas = maas;
    }

    public String getMeslek() {
        return meslek;
    }

    public void setMeslek(String meslek) {
        this.meslek = meslek;
    }
     
     public Personeller(String tc, String ad, String soyad, String sube, String sicil_no, String telefon, String cinsiyet, String medeni_hal, String adres, String maas, String meslek) {
        this.tc = tc;
        this.ad = ad;
        this.soyad = soyad;
        this.sube = sube;
        this.sicil_no = sicil_no;
        this.telefon = telefon;
        this.cinsiyet = cinsiyet;
        this.medeni_hal = medeni_hal;
        this.adres = adres;
        this.maas = maas;
        this.meslek = meslek;
    }
}
