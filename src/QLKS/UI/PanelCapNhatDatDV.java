/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLKS.UI;

import QLKS.controller.DatDichVuDao;
import QLKS.controller.DichVuDao;
import QLKS.model.DatDichVu;
import QLKS.model.DichVu;
import java.awt.CardLayout;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class PanelCapNhatDatDV extends javax.swing.JPanel {

    /**
     * Creates new form PanelCapNhatDatDV
     */
    public PanelCapNhatDatDV() {
        initComponents();
    }
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
     DatDichVu ddv=new DatDichVu();
     DatDichVuDao ddvd=new DatDichVuDao();
    public PanelCapNhatDatDV(String MaHDDV) {
        try {
            initComponents();
         addCbo();
        txtMaHDDV.setText(MaHDDV);
        txtMaHDDV.setEnabled(false);
        ddv.setMaHDDV(MaHDDV);
        setUp();
        } catch (Exception e) {
            System.out.println("Lỗi");
        }
        
    }
    public void setUp()
    {
        
            DatDichVu dvdx=ddvd.find(ddv.getMaHDDV(),"Mã hóa đơn dịch vụ").get(0);
            txtGhiChu.setText(dvdx.getGhiChu());
            spinTime.setValue(dvdx.getThoiGianBatDauSDDV());
            spinSL.setValue(dvdx.getSoLuong());
            DichVu dvx;
            dvx=dvdao.getDichVu(dvdx.getMaDV());
            cboTenDV.getModel().setSelectedItem(dvx);
      
         
    }
     DichVuDao dvdao=new DichVuDao();
    private void addCbo() {
        
        
        
         DichVu dv;
        
        for (int i = 0; i < dvdao.getList().size(); i++) {
             dv=dvdao.getList().get(i);
             model.addElement(dv);
        }
        cboTenDV.setModel(model);
        
        
    }
    DefaultComboBoxModel model=new DefaultComboBoxModel();

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
        txtMaHDDV = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtGhiChu = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        spinSL = new javax.swing.JSpinner();
        cboTenDV = new javax.swing.JComboBox<>();
        spinTime = new javax.swing.JSpinner();
        btnAdd = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        jPanel2.setBackground(new java.awt.Color(255, 204, 255));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("Mã hóa đơn dịch vụ");

        txtMaHDDV.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtMaHDDV.setDisabledTextColor(new java.awt.Color(51, 51, 51));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setText("Số lượng dịch vụ ");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setText("Ghi chú");

        txtGhiChu.setColumns(20);
        txtGhiChu.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtGhiChu.setRows(5);
        txtGhiChu.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jScrollPane1.setViewportView(txtGhiChu);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel6.setText("Chọn dịch vụ");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel10.setText("Thời gian bắt đầu dịch vụ");

        spinSL.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        spinSL.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        cboTenDV.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        cboTenDV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTenDVActionPerformed(evt);
            }
        });

        spinTime.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        spinTime.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.DAY_OF_WEEK));

        btnAdd.setBackground(new java.awt.Color(255, 255, 0));
        btnAdd.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QLKS/Image/baseline_save_black_24dp.png"))); // NOI18N
        btnAdd.setText("Cập nhật");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(255, 0, 0));
        btnBack.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QLKS/Image/baseline_clear_black_24dp.png"))); // NOI18N
        btnBack.setText("Hủy bỏ");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMaHDDV)
                    .addComponent(cboTenDV, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(spinSL)
                    .addComponent(spinTime)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE))
                .addGap(228, 228, 228))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(660, 660, 660)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(191, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaHDDV, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(80, 80, 80)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboTenDV, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(80, 80, 80)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinSL, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(80, 80, 80)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinTime, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(80, 80, 80)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1286, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1051, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cboTenDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTenDVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboTenDVActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
       DichVu dv=(DichVu) cboTenDV.getSelectedItem();
        
        try {
             String GhiChu=txtGhiChu.getText();
             int SoLuong=(int) spinSL.getValue();
             float DonGia=dv.getPhiDV();
             Date time=(Date) spinTime.getValue();
             Timestamp times=new Timestamp(time.getTime());
            
             String MaDV=dv.getMaDV();
           
             
             ddv.setMaDV(MaDV);
             ddv.setGhiChu(GhiChu);
             ddv.setSoLuong(SoLuong);
             ddv.setThoiGianBatDauSDDV(times);
             ddv.setThanhTien(DonGia*SoLuong);
             ddvd.update(ddv);
          
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Nhập đúng định dạng !!");
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.removeAll();
        this.setLayout(new CardLayout());
        this.add(new DatDichVuMain());
        this.validate();
        this.repaint();
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JComboBox<String> cboTenDV;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner spinSL;
    private javax.swing.JSpinner spinTime;
    private javax.swing.JTextArea txtGhiChu;
    private javax.swing.JTextField txtMaHDDV;
    // End of variables declaration//GEN-END:variables
}
