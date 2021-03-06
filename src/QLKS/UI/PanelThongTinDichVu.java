/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLKS.UI;

import QLKS.controller.DichVuDao;
import QLKS.model.DichVu;
import java.awt.CardLayout;

/**
 *
 * @author ADMIN
 */
public class PanelThongTinDichVu extends javax.swing.JPanel {

    /**
     * Creates new form PanelThongTinDichVu
     */
    public PanelThongTinDichVu() {
        initComponents();
    }
     DichVuDao dvd=new DichVuDao();
     public PanelThongTinDichVu(String MaDV) {
        initComponents();
         DichVu dv;
         txtMaDV.setEnabled(false);
         txtTenDV.setEnabled(false);
         txtPhiDV.setEnabled(false);
         txtMoTa.setEnabled(false);
         txtMoTa.setLineWrap(true);
        for (int i = 0; i < dvd.find(MaDV, "Mã dịch vụ").size(); i++) {
          dv=dvd.find(MaDV, "Mã dịch vụ").get(i);
           txtMaDV.setText(dv.getMaDV());
           txtTenDV.setText(dv.getTenDV());
           txtPhiDV.setText(dv.getPhiDV()+"");
           txtMoTa.setText(dv.getMoTaDichVu());
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

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtMaDV = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTenDV = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtPhiDV = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMoTa = new javax.swing.JTextArea();
        btnBack2 = new javax.swing.JButton();

        jPanel2.setBackground(new java.awt.Color(255, 204, 255));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("Mã dịch vụ");

        txtMaDV.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtMaDV.setDisabledTextColor(new java.awt.Color(51, 51, 51));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setText("Tên dịch vụ");

        txtTenDV.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtTenDV.setDisabledTextColor(new java.awt.Color(51, 51, 51));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setText("Phí dịch vụ");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setText("Mô tả dịch vụ");

        txtPhiDV.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtPhiDV.setDisabledTextColor(new java.awt.Color(51, 51, 51));

        txtMoTa.setColumns(20);
        txtMoTa.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtMoTa.setRows(5);
        txtMoTa.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jScrollPane1.setViewportView(txtMoTa);

        btnBack2.setBackground(new java.awt.Color(255, 0, 0));
        btnBack2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnBack2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QLKS/Image/baseline_clear_black_24dp.png"))); // NOI18N
        btnBack2.setText("Hủy bỏ");
        btnBack2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addGap(120, 120, 120)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPhiDV)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 745, Short.MAX_VALUE)
                    .addComponent(txtTenDV)
                    .addComponent(txtMaDV))
                .addGap(78, 78, 78))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBack2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(445, 445, 445))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaDV, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(80, 80, 80)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenDV, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(80, 80, 80)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPhiDV, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(80, 80, 80)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69)
                .addComponent(btnBack2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1184, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 989, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBack2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack2ActionPerformed
        this.removeAll();
        this.setLayout(new CardLayout());
        this.add(new DichVuMain());
        this.validate();
        this.repaint();
    }//GEN-LAST:event_btnBack2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBack1;
    private javax.swing.JButton btnBack2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextField txtMaDV;
    private javax.swing.JTextField txtMaDV4;
    private javax.swing.JTextField txtMaDV5;
    private javax.swing.JTextField txtMaDV6;
    private javax.swing.JTextField txtMaDV7;
    private javax.swing.JTextArea txtMoTa;
    private javax.swing.JTextArea txtMoTa4;
    private javax.swing.JTextArea txtMoTa5;
    private javax.swing.JTextArea txtMoTa6;
    private javax.swing.JTextArea txtMoTa7;
    private javax.swing.JTextField txtPhiDV;
    private javax.swing.JTextField txtPhiDV4;
    private javax.swing.JTextField txtPhiDV5;
    private javax.swing.JTextField txtPhiDV6;
    private javax.swing.JTextField txtPhiDV7;
    private javax.swing.JTextField txtTenDV;
    private javax.swing.JTextField txtTenDV5;
    private javax.swing.JTextField txtTenDV6;
    private javax.swing.JTextField txtTenDV7;
    private javax.swing.JTextField txtTenDV8;
    // End of variables declaration//GEN-END:variables
}
