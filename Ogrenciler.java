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
public class Ogrenciler {
     private String tc;
     private String ad;
     private String soyad;
     private String sube;
     private String telefon;
     private String cinsiyet;
     private String adres;
     public Ogrenciler(){
         
     }

    public Ogrenciler(String tc, String ad, String soyad, String sube, String telefon, String cinsiyet, String adres) {
        this.tc = tc;
        this.ad = ad;
        this.soyad = soyad;
        this.sube = sube;
        this.telefon = telefon;
        this.cinsiyet = cinsiyet;
        this.adres = adres;
    }

    Ogrenciler(String sube, String tc, String ad, String soyad, String adres, String cinsiyet, String telefon, String adres0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

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

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }
}
