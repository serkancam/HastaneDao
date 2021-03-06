/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hastatakip.gui;

import com.hastatakip.dao.*;
import com.hastatakip.entity.*;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import java.util.List;
/**
 *
 * @author serkancam
 */
public class MuayeneIslemleri extends javax.swing.JFrame {

    /**
     * Creates new form HastaIslemleri
     */
    public HastaIslemleri ataPencere;
   
    public MuayeneIslemleri() {
        
        initComponents();
        
        
    }
    void IlaclarCBDoldur()
    {
        List<Ilac> ilaclar =null;
       IlacDao islem=new IlacDao();
       ilaclar=islem.TumListeyiGetir();
      
        for (Ilac ilac : ilaclar) 
        {
            cbIlaclar.addItem(ilac.toString());            
            
        }
    }
    void MuayenelerCBDoldur()
    {
       List<Muayene> muayeneler =null;
       Muayene m=new Muayene();
       m.setDoktorTC(seciliDoktorTC);
       m.setHastaTC(seciliHastaTC);
       MuayeneDao islem=new MuayeneDao();
       muayeneler=islem.HastaAdinaGoreGetir(m);
      
        for (Muayene muayene : muayeneler) 
        {
            cbMuayeneler.addItem(muayene.toString());            
            
        }
        
    }
    public String seciliDoktorTC,seciliHastaTC;
    public int seciliMuayeneId=0;
    void EkraniTemizle()
    {
        txtTeshis.setText("");
        cbIlaclar.setSelectedIndex(0);
        DefaultTableModel modelIlac= (DefaultTableModel) tblIlaclar.getModel();
        DefaultTableModel modelTeshis= (DefaultTableModel) tblTeshisler.getModel();
        int rowCount = modelIlac.getRowCount();
//Remove rows one by one from the end of the table
        for (int i = rowCount - 1; i >= 0; i--)
        {
             modelIlac.removeRow(i);
        }
        rowCount = modelTeshis.getRowCount();
//Remove rows one by one from the end of the table
        for (int i = rowCount - 1; i >= 0; i--)
        {
             modelTeshis.removeRow(i);
        }
    }
   
   
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtHastaAdi = new javax.swing.JTextField();
        txtDoktorAdi = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        dtpMuayeneTarihi = new org.jdesktop.swingx.JXDatePicker();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblIlaclar = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTeshisler = new javax.swing.JTable();
        cbIlaclar = new javax.swing.JComboBox<>();
        btnIlacEkle = new javax.swing.JButton();
        btnTeshisEkle = new javax.swing.JButton();
        btnMuayenIslemleriBitir = new javax.swing.JButton();
        txtTeshis = new javax.swing.JTextField();
        lblBilgi = new javax.swing.JLabel();
        cbMuayeneler = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        btnEkraniTemizle = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setText("Doktor:");

        jLabel2.setText("Hasta Adı:");

        txtHastaAdi.setEditable(false);

        txtDoktorAdi.setEditable(false);

        jLabel3.setText("Muayene Tarihi");

        tblIlaclar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ilaç"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblIlaclar);

        tblTeshisler.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Teşhis"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblTeshisler);

        btnIlacEkle.setText("İlaç Ekle");
        btnIlacEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIlacEkleActionPerformed(evt);
            }
        });

        btnTeshisEkle.setText("Teşhis Ekle");
        btnTeshisEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTeshisEkleActionPerformed(evt);
            }
        });

        btnMuayenIslemleriBitir.setText("Muayene İşlemleri Bitir");
        btnMuayenIslemleriBitir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMuayenIslemleriBitirActionPerformed(evt);
            }
        });

        cbMuayeneler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMuayenelerActionPerformed(evt);
            }
        });

        jLabel4.setText("Muayeneler");

        btnEkraniTemizle.setText("Ekranı Temizle");
        btnEkraniTemizle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEkraniTemizleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbIlaclar, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIlacEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnTeshisEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtTeshis)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtHastaAdi, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtDoktorAdi, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(dtpMuayeneTarihi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnMuayenIslemleriBitir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEkraniTemizle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(cbMuayeneler, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(lblBilgi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbMuayeneler, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtHastaAdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnEkraniTemizle)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtDoktorAdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dtpMuayeneTarihi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addComponent(btnMuayenIslemleriBitir, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(lblBilgi, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbIlaclar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTeshis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIlacEkle)
                    .addComponent(btnTeshisEkle))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        ataPencere.setVisible(true);
        
    }//GEN-LAST:event_formWindowClosed

    private void btnMuayenIslemleriBitirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMuayenIslemleriBitirActionPerformed
        // TODO add your handling code here:
        Muayene m=new Muayene();
        DefaultTableModel modelIlac= (DefaultTableModel) tblIlaclar.getModel();
        DefaultTableModel modelTeshis= (DefaultTableModel) tblTeshisler.getModel();
      //  List<VerilenIlac> verilenIlaclar=new ArrayList<VerilenIlac>();
        
        
        m.setDoktorTC(seciliDoktorTC);
        m.setHastaTC(seciliHastaTC);
        m.setMuayeneTarihi(dtpMuayeneTarihi.getDate());
        MuayeneDao islem=new MuayeneDao();
        VerilenIlacDao ilacIslem=new VerilenIlacDao();
        
        
        int muayeneId=islem.Ekle(m);
        lblBilgi.setText(String.valueOf(muayeneId));
        if(muayeneId>0)
        {
            lblBilgi.setText(String.valueOf(muayeneId)+" muayene eklendi");
            
            for (int i = 0; i < tblIlaclar.getRowCount(); i++) 
             {
                VerilenIlac verilen=new VerilenIlac();
                verilen.setIlacId(Integer.parseInt(modelIlac.getValueAt(i, 0).toString().split("-")[0]));
                verilen.setMuayeneId(muayeneId);
                // verilenIlaclar.add(verilen);
                if(ilacIslem.Ekle(verilen)>0)
                {
                    //Ekleme işlemi başarılı ise yapılacakalr.
                }
                else
                {
                    lblBilgi.setText(lblBilgi.getText()+"  ilaç eklenemdi");
                    return;
                    
                }
               
            
            }
            for (int i = 0; i < tblTeshisler.getRowCount(); i++) 
             {
                Teshis teshis=new Teshis();
                TeshisDao teshisIslem=new TeshisDao();
                teshis.setTeshisAciklama(modelTeshis.getValueAt(i, 0).toString());
                teshis.setMuayeneId(muayeneId);
                // verilenIlaclar.add(verilen);
                if(teshisIslem.Ekle(teshis)>0)
                {
                    //Ekleme işlemi başarılı ise yapılacakalr.
                }
                else
                {
                    lblBilgi.setText(lblBilgi.getText()+"  teşhis eklenemdi");
                    return;
                    
                }
               
            
            }
            
        }
        else
        {
            return;
            
        }
        
        
        
    }//GEN-LAST:event_btnMuayenIslemleriBitirActionPerformed

    private void btnIlacEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIlacEkleActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model= (DefaultTableModel) tblIlaclar.getModel();  
        model.addRow(new Object[]{cbIlaclar.getSelectedItem().toString()});
        
    }//GEN-LAST:event_btnIlacEkleActionPerformed

    private void btnTeshisEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTeshisEkleActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model= (DefaultTableModel) tblTeshisler.getModel();  
        model.addRow(new Object[]{txtTeshis.getText()});
        
    }//GEN-LAST:event_btnTeshisEkleActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        IlaclarCBDoldur();
        MuayenelerCBDoldur();
        
        txtDoktorAdi.setText(seciliDoktorTC);
        txtHastaAdi.setText(seciliHastaTC);
    }//GEN-LAST:event_formWindowOpened

    private void cbMuayenelerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMuayenelerActionPerformed
        // TODO add your handling code here:
        EkraniTemizle();
        seciliMuayeneId=Integer.parseInt(cbMuayeneler.getItemAt(cbMuayeneler.getSelectedIndex()).split("-")[0]);
        //lblBilgi.setText(seciliMuayeneId+"");
        DefaultTableModel model= (DefaultTableModel) tblTeshisler.getModel();  
        
        TeshisDao tIslem=new TeshisDao();
        List<Teshis> teshisler=tIslem.MuayeneIdyeGoreGetir(seciliMuayeneId);
        for(Teshis teshis: teshisler)
        {
            model.addRow(new Object[]{teshis.getTeshisAciklama()});
        }
        
        DefaultTableModel modelIlac= (DefaultTableModel) tblIlaclar.getModel();  
        
        IlacDao Iislem=new IlacDao();
        List<Ilac> verilenIlaclar=Iislem.MuayeneIdyeGoreGetir(seciliMuayeneId);
        for(Ilac ilac: verilenIlaclar)
        {
            modelIlac.addRow(new Object[]{ilac.toString()});
        }
        
         
    }//GEN-LAST:event_cbMuayenelerActionPerformed

    private void btnEkraniTemizleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEkraniTemizleActionPerformed
        // TODO add your handling code here:
        EkraniTemizle();
        
    }//GEN-LAST:event_btnEkraniTemizleActionPerformed

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
            java.util.logging.Logger.getLogger(MuayeneIslemleri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MuayeneIslemleri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MuayeneIslemleri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MuayeneIslemleri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
                new MuayeneIslemleri().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEkraniTemizle;
    private javax.swing.JButton btnIlacEkle;
    private javax.swing.JButton btnMuayenIslemleriBitir;
    private javax.swing.JButton btnTeshisEkle;
    private javax.swing.JComboBox<String> cbIlaclar;
    private javax.swing.JComboBox<String> cbMuayeneler;
    private org.jdesktop.swingx.JXDatePicker dtpMuayeneTarihi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblBilgi;
    private javax.swing.JTable tblIlaclar;
    private javax.swing.JTable tblTeshisler;
    private javax.swing.JTextField txtDoktorAdi;
    private javax.swing.JTextField txtHastaAdi;
    private javax.swing.JTextField txtTeshis;
    // End of variables declaration//GEN-END:variables
}
