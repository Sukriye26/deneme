/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dersane.Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Sukriye
 */

public class Islemler {
    private  Connection conn =null;
    private Statement stmt = null;
    private PreparedStatement pstmt =null;
    
public void ogrenci_Ekle (String sube,String tc,String ad,String soyad,String telefon,String cinsiyet,String adres ){
        String sorgu = "INSERT INTO OGRENCI(SUBE_ADI,TC_NO,O_ADI,O_SOYAD,TELEFON,CINSIYET,ADRES)" + "VALUES (?,?,?,?,?,?,?)";
        try {
            pstmt=conn.prepareStatement(sorgu);
            pstmt.setString(1, sube);
            pstmt.setString(2, tc);
            pstmt.setString(3, ad);
            pstmt.setString(4, soyad);
            pstmt.setString(5, telefon);
            pstmt.setString(6, cinsiyet);
            pstmt.setString(7, adres);
            pstmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
    public void ogrenci_Sil(String tc){
        String sorgu = "DELETE FROM OGRENCI WHERE TC_NO = ?";
        
        try {
            pstmt=conn.prepareStatement(sorgu);
           
            pstmt.setString(1, tc);
            
           pstmt.executeQuery();
            
            JOptionPane.showMessageDialog(null, "Kayıt Silindi. ");
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Kayıt Silinemedi. " );
            
        }
    }
    
    public void ogrenci_Guncelle(String sube,String tc,String ad,String soyad,String telefon,String cinsiyet,String adres){
        String sorgu = "UPDATE  OGRENCI  SET SUBE_ADI = ? , TC_NO = ? ,O_ADI = ? , O_SOYAD = ? , TELEFON = ? , CINSIYET =? ,ADRES =?   WHERE TC_NO = ?";
        
        try {
            pstmt=conn.prepareStatement(sorgu);
            pstmt.setString(1, sube);
            pstmt.setString(2, tc);
            pstmt.setString(3, ad);
            pstmt.setString(4, soyad);
            pstmt.setString(5, telefon);
            pstmt.setString(6, cinsiyet);
            pstmt.setString(7, adres);
            pstmt.setString(8, tc);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Kayıt Güncellendi. ");
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Kayıt Güncellenemedi. ");
             
            
        }
    }
    public void ogrenci_Ara(String tc){
        String sorgu = "SELECT * FROM OGRENCI WHERE TC_NO = ?";
        
        try {
            pstmt=conn.prepareStatement(sorgu);
            //stmt =conn.createStatement();
            pstmt.setString(1, tc);
            
            ResultSet rs = pstmt.executeQuery();
        }
        catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    
    public boolean giris(String kullanici,String parola){
        
        String sorgu = "Select * From SIFRE where KULLANICI_ADI = ? and SIFRE = ?";
        try {
            pstmt = conn.prepareStatement(sorgu);
            pstmt.setString(1, kullanici);
            pstmt.setString(2, parola);
             ResultSet rs =pstmt.executeQuery();
            /* if(rs.next()== false){
                return false;
             }
             else{
                 return true;
             }*/
             return rs.next();
             
        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } 
        
    /**
     *
     * @return
     */
    
    }
    
    public Islemler() {
        try {
            Class.forName(OracleDbConnection.driverName);
            try {
            conn =DriverManager.getConnection(OracleDbConnection.URL,OracleDbConnection.userName,OracleDbConnection.password);
            stmt=conn.createStatement();
            
            System.out.println("Bağlantı Başarılı ");
            } 
            catch (SQLException ex) {
                 System.out.println("Bağlantı Başarısız ");
                 System.out.println(ex);
            }
        } 
        catch (ClassNotFoundException ex) {
          System.out.println("Driver Bulunamadı ");
          System.out.println(ex);
        }
            
    }
    
    public ArrayList<Ogrenciler> ogr_Getir(){
       ArrayList<Ogrenciler> cikti =new ArrayList<Ogrenciler>();
        try {
            stmt=conn.createStatement();
            String sorgu ="SELECT * FROM OGRENCI";
            ResultSet rs = stmt.executeQuery(sorgu);
            while(rs.next()){
               String sube =rs.getString("SUBE_ADI");
               String tc=rs.getString("TC_NO");
               String ad = rs.getString("O_ADI");
               String soyad =rs.getString("O_SOYAD");
               String telefon =rs.getString("TELEFON");
               String cinsiyet =rs.getString("CINSIYET");
               String adres =rs.getString("ADRES");
               cikti.add(new Ogrenciler(sube,tc, ad, soyad, adres,cinsiyet,telefon,adres));
            }
            return cikti;
            
        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
        }

            return null; 
        
    }
    public ArrayList<Sube> sube_Getir(){
            
     ArrayList<Sube> cikti =new ArrayList<Sube>();
        try {
            stmt=conn.createStatement();
            String sorgu ="SELECT SUBE_ADI FROM SUBE";
            ResultSet rs = stmt.executeQuery(sorgu);
            while(rs.next()){
               String sube =rs.getString("SUBE_ADI");
               cikti.add(new Sube(sube));
            }
            return cikti;
            
        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
        }

            return null;
    }
     
     public static void main(String[] args) throws SQLException {
        Islemler islem = new Islemler();
    }
     
}
