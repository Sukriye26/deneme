/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dersane;

import dersane.Connection.Islemler;
import dersane.Connection.OracleDbConnection;
import dersane.Connection.*;
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
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Sukriye
 */
public class Ogrenci extends javax.swing.JFrame {
    DefaultTableModel model;
    
    private  Connection conn =null;
    private Statement stmt = null;
    private PreparedStatement pstmt =null;

    Ogrenciler ogr = new Ogrenciler();
    /**
     * Creates new form Ogrenci
     */
    //Islemler islemler = new Islemler();
    
    public Ogrenci () {
        initComponents();
        model= (DefaultTableModel) yeni_Tablo.getModel();
        //model = (DefaultTableModel) table.getModel();
        //subeGetir();
        //ogr_Goruntule();
        try {
            Class.forName(OracleDbConnection.driverName);
            try {
            conn =DriverManager.getConnection(OracleDbConnection.URL,OracleDbConnection.userName,OracleDbConnection.password);
            stmt=conn.createStatement();
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
        
        try {
            ResultSet rs =stmt.executeQuery("SELECT SUBE_ID FROM SUBE");
            while(rs.next()){
               db_sube.addItem(rs.getString("SUBE_ID"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Ogrenci.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        tablo_Doldur();
        
    }
    public void tablo_Doldur(){
        try {
            ResultSet rs= stmt.executeQuery("SELECT * FROM OGRENCI");
            int a= rs.getMetaData().getColumnCount();
            DefaultTableModel table= new DefaultTableModel();
            for (int i=1; i<=a; i++)
                table.addColumn(rs.getMetaData().getColumnName(i));

            while(rs.next()){
                    Object[] row =new Object[a];
                    for(int x=1; x<=a;x++){
                        row[x-1]=rs.getObject(x);
                        
                    }
                    table.addRow(row);
                   // System.out.println("ne yapıyorsun sen acaba");
                        
                    yeni_Tablo.setModel(table);
                }
            
        } catch (SQLException ex) {
            Logger.getLogger(Ogrenci.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /*public void cgr_Goruntule(){
        model.setRowCount(0);
        ArrayList<Ogrenciler> ogrenciler = new ArrayList<Ogrenciler>();
        ogrenciler = islemler.ogr_Getir();
        if (ogrenciler != null){
            for (Ogrenciler ogr : ogrenciler){
                Object [] array ={ogr.getSube(),ogr.getTc(),ogr.getAd(),ogr.getSoyad().ogr.getTelefon(),ogr.getCinsiyet(),ogr.getAdres()};
                model.addRow(array);
            }
        }
        
    }*/
    /*public void subegetir(){
        ArrayList<Sube> subeler = new ArrayList<Sube>();
        subeler = islemler.Sube_Getir();
        if (subeler != null){
            for (Sube sube : subeler){
                Object [] array ={sube.getSube()};
                db_sube.addItem(array);
            }
        }
    }*/

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tc_alani = new javax.swing.JTextField();
        guncelle = new javax.swing.JButton();
        sil = new javax.swing.JButton();
        db_sube = new javax.swing.JComboBox();
        soyad_alani = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        ara = new javax.swing.JButton();
        cinsiyet_alani = new javax.swing.JComboBox();
        adres_alani = new javax.swing.JTextField();
        kaydet = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        telefon_alani = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        geri = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        ad_alani = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        yeni_Tablo = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(242, 255, 232));

        jLabel1.setText("T.C Kimlik Numarası:");

        guncelle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dersane/icons8-update-64.png"))); // NOI18N
        guncelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guncelleActionPerformed(evt);
            }
        });

        sil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dersane/icons8-delete-bin-64.png"))); // NOI18N
        sil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                silActionPerformed(evt);
            }
        });

        db_sube.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sube Kodu" }));

        jLabel6.setText("Cinsiyet");

        ara.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dersane/icons8-search-property-64.png"))); // NOI18N
        ara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                araActionPerformed(evt);
            }
        });

        cinsiyet_alani.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CİNSİYET", "E", "K" }));

        kaydet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dersane/icons8-save-close-64.png"))); // NOI18N
        kaydet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kaydetActionPerformed(evt);
            }
        });

        jLabel4.setText("Kayıt Olduğu Şube:");

        jLabel7.setText("Adres:");

        jLabel3.setText("Öğrenci Soyadı:");

        jLabel2.setText("Öğrenci Adı:");

        geri.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dersane/icons8-back-arrow-64.png"))); // NOI18N
        geri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                geriActionPerformed(evt);
            }
        });

        jLabel5.setText("Telefon:");

        yeni_Tablo.setBackground(new java.awt.Color(87, 192, 163));
        yeni_Tablo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Şube", "TC", "ADI", "SOYADI", "CİNSİYET", "TELEFON", "ADRES"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        yeni_Tablo.setEnabled(false);
        jScrollPane2.setViewportView(yeni_Tablo);
        if (yeni_Tablo.getColumnModel().getColumnCount() > 0) {
            yeni_Tablo.getColumnModel().getColumn(0).setResizable(false);
            yeni_Tablo.getColumnModel().getColumn(1).setResizable(false);
            yeni_Tablo.getColumnModel().getColumn(2).setResizable(false);
            yeni_Tablo.getColumnModel().getColumn(3).setResizable(false);
            yeni_Tablo.getColumnModel().getColumn(4).setResizable(false);
            yeni_Tablo.getColumnModel().getColumn(5).setResizable(false);
            yeni_Tablo.getColumnModel().getColumn(6).setResizable(false);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(64, 64, 64)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cinsiyet_alani, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(adres_alani)
                            .addComponent(db_sube, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(soyad_alani)
                            .addComponent(tc_alani)
                            .addComponent(ad_alani, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(telefon_alani, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(geri, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(kaydet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ara, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(guncelle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(39, 39, 39)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tc_alani, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1)))
                            .addComponent(ara, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(ad_alani, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(soyad_alani, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(db_sube, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(35, 35, 35)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(telefon_alani, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel2)
                                .addGap(30, 30, 30)
                                .addComponent(jLabel3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(kaydet, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(sil, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cinsiyet_alani, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(adres_alani, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addGap(21, 21, 21)
                                .addComponent(geri))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(guncelle)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kaydetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kaydetActionPerformed
        // TODO add your handling code here:
        String ad= ad_alani.getText();
        String soyad =soyad_alani.getText();
        String tc= tc_alani.getText();
        String sube = (String) db_sube.getSelectedItem();
        String adres =adres_alani.getText();
        String telefon=telefon_alani.getText();
        String cinsiyet=(String) cinsiyet_alani.getSelectedItem();
        String s ="SELECT TC_NO FROM OGRENCI WHERE TC_NO = ?";
        
        if (tc.length()==11){
           //islemler.ogrenci_Ekle(sube,tc,ad,soyad,telefon,cinsiyet,adres);
            String sorgu = "INSERT INTO OGRENCI(SUBE_ID,TC_NO,OGR_ADI,OGR_SOYADI,TELEFON,CINSIYET,ADRES)" + "VALUES (?,?,?,?,?,?,?)";
        try{
            pstmt=conn.prepareStatement(s);
            pstmt.setString(1, tc);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()== false ){
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
            JOptionPane.showMessageDialog(null,"Başarıyla Eklendi." ); 
            tablo_Doldur();
            
            //JOptionPane.showMessageDialog(null,"Veli Bilgi Giriş Ekranına Yönlendiriliyorsunuz." ); 
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Ogrenci.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
            }
            else{
              JOptionPane.showMessageDialog(null, "Kayıt Var");
            }
        }
        catch(SQLException ex) {
            Logger.getLogger(Ogrenci.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        }
       else if (tc.length()>11 || tc.length()<11){
           JOptionPane.showMessageDialog(null, "T.C Kimlik Numarası 11 Haneli Olmalıdır.");
           
       }
        ad_alani.setText("");
        soyad_alani.setText("");
        tc_alani.setText("");
        adres_alani.setText("");
        telefon_alani.setText("");
        cinsiyet_alani.setSelectedItem("");
        db_sube.setSelectedItem("");
         //BURDAN sonra da tabloda görüntüleme yap!
        
        //this.setVisible(false);
    }//GEN-LAST:event_kaydetActionPerformed

    private void araActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_araActionPerformed
        // TODO add your handling code here:
        String tc= tc_alani.getText();
        model.setRowCount(0);
        if (tc.length()==11){
           //islemler.ogrenci_Ara(tc);
            String sorgu = "SELECT * FROM OGRENCI WHERE TC_NO = ?";
        
        try {
            pstmt=conn.prepareStatement(sorgu);
            //stmt =conn.createStatement();
            pstmt.setString(1, tc);
            
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()== true ){
                JOptionPane.showMessageDialog(null, "Kayıt Bulundu. ");
                
                    //JOptionPane.showMessageDialog(null, "deneme");
                    /*System.out.print(rs.getString("SUBE_ID")+ " ");
                    System.out.print(rs.getString("TC_NO")+ " ");
                    System.out.print(rs.getString("OGR_ADI")+ " ");
                    System.out.print(rs.getString("OGR_SOYADI")+ " ");
                    System.out.print(rs.getString("CINSIYET")+ " ");
                    System.out.print(rs.getString("TELEFON")+ " ");
                    System.out.print(rs.getString("ADRES")+ " ");*/
                    ad_alani.setText(rs.getString("OGR_ADI"));
                    soyad_alani.setText(rs.getString("OGR_SOYADI"));
                    cinsiyet_alani.setSelectedItem(rs.getString("CINSIYET"));
                    telefon_alani.setText(rs.getString("TELEFON"));
                    adres_alani.setText(rs.getString("ADRES"));
                    db_sube.setSelectedItem(rs.getString("SUBE_ID"));
                    
            }      //kayıtları tabloya yazdırmak gerek sadece
            
            else{
                JOptionPane.showMessageDialog(null,"Kayıt Bulunamadı. " );
                tc_alani.setText("");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
            
        }
           
       }
       else if (tc.length()>11 || tc.length()<11){
           JOptionPane.showMessageDialog(null, "T.C Kimlik Numarası 11 Haneli Olmalıdır.");
       }
        
        //
        
    }//GEN-LAST:event_araActionPerformed

    private void silActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_silActionPerformed
        // TODO add your handling code here:
        String tc= tc_alani.getText();
        if (tc.length()==11){
           //islemler.ogrenci_Sil(tc);
            String sorgu = "DELETE FROM OGRENCI WHERE TC_NO = ?";
        
        try {
            pstmt=conn.prepareStatement(sorgu);
           
            pstmt.setString(1, tc);
            
           pstmt.executeQuery();
            
            JOptionPane.showMessageDialog(null, "Kayıt Silindi. ");
            tc_alani.setText("");
            tablo_Doldur();
            
        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Kayıt Silinemedi. " );
            
        }
           
       }
       else if (tc.length()>11 || tc.length()<11){
           JOptionPane.showMessageDialog(null, "T.C Kimlik Numarası 11 Haneli Olmalıdır.");
       }
    }//GEN-LAST:event_silActionPerformed

    private void guncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guncelleActionPerformed
        // TODO add your handling code here:
        String ad= ad_alani.getText();
        String soyad =soyad_alani.getText();
        String tc= tc_alani.getText();
        String sube = (String) db_sube.getSelectedItem();
        String adres =adres_alani.getText();
        String telefon=telefon_alani.getText();
        String cinsiyet=(String) cinsiyet_alani.getSelectedItem();
        if (tc.length()==11){
           //islemler.ogrenci_Guncelle(sube,tc,ad,soyad,telefon,cinsiyet,adres);
            String sorgu = "UPDATE  OGRENCI  SET SUBE_ID = ? , TC_NO = ? ,OGR_ADI = ? , OGR_SOYADI = ? , TELEFON = ? , CINSIYET =? ,ADRES =?   WHERE TC_NO = ?";
        
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
            tablo_Doldur();
            ad_alani.setText("");
            soyad_alani.setText("");
            tc_alani.setText("");
            adres_alani.setText("");
            telefon_alani.setText("");
            cinsiyet_alani.setSelectedItem("");
            db_sube.setSelectedItem("");
            
        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Kayıt Güncellenemedi. ");
             
            
        }
           
       }
       else if (tc.length()>11 || tc.length()<11){
           JOptionPane.showMessageDialog(null, "T.C Kimlik Numarası 11 Haneli Olmalıdır.");
       }
    }//GEN-LAST:event_guncelleActionPerformed

    private void geriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_geriActionPerformed
        // TODO add your handling code here:
        
        Menu form = new Menu();
        form.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_geriActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ogrenci.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ogrenci.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ogrenci.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ogrenci.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ogrenci().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ad_alani;
    private javax.swing.JTextField adres_alani;
    private javax.swing.JButton ara;
    private javax.swing.JComboBox cinsiyet_alani;
    private javax.swing.JComboBox db_sube;
    private javax.swing.JButton geri;
    private javax.swing.JButton guncelle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton kaydet;
    private javax.swing.JButton sil;
    private javax.swing.JTextField soyad_alani;
    private javax.swing.JTextField tc_alani;
    private javax.swing.JTextField telefon_alani;
    private javax.swing.JTable yeni_Tablo;
    // End of variables declaration//GEN-END:variables

    
}
