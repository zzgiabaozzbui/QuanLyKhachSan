/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLKS.view;

import QLKS.Login.login;
import QLKS.connect.MyConnection;
import QLKS.controller.HoaDon_PT;
import QLKS.controller.PhuThuDao;
import QLKS.controller.SanPhamDao;
import QLKS.model.HoaDon;
import QLKS.model.PhuThu;
import QLKS.model.SanPham;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/**
 *
 * @author Pham Thang <Thangyb2706@gmail.com>
 */
public class ChiTietHoaDon extends javax.swing.JFrame {

    /**
     * Creates new form ChiTietHoaDon
     */
    public ChiTietHoaDon() throws SQLException {
        initComponents();
        LoadJTable();
        tblHoaDon.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e)  {
                ((DefaultTableModel)tblPhuThu.getModel()).setNumRows(0);
                int index = tblHoaDon.getSelectedRow();
                String valueAt =  (String) tblHoaDon.getValueAt(index, 0);
                Optional<HoaDon> pUpdate = hdDao.get(valueAt);
                System.out.println(pUpdate.get().getMaKH());
                Object[] dataRow;
                double tongPhuThu=0;
                //PhuThu pt= new PhuThu(pUpdate.get().getMaKH(), pUpdate.get().getMaKH(),pUpdate.get().getMaKH(), 0, 0);
                List<PhuThu> listPhuThu = phuThuDao.findPT_onHD(pUpdate.get().getMaHD());
                String nameKH="";
                for (PhuThu p : listPhuThu) {
                  
                    try {
                        nameKH = phuThuDao.findNameKH(new PhuThu("",p.getMaKH(),"",0,0));
                    } catch (SQLException ex) {
                        Logger.getLogger(ChiTietHoaDon.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Optional<SanPham> nameSP= spdao.get(p.getMaSP());    
                    dataRow = new Object[]{p.getMaPT(), nameKH, nameSP.get().getTenSP(), p.getSoLuong(), p.getNgayBan(), p.getThanhTien()};
                    dtmDanhSachPT.addRow(dataRow);
                    tongPhuThu+=p.getThanhTien();
                }
                Double TongTienPhong= hdDao.getPhiPhong(pUpdate.get().getMaDatPhong());
                txtTongTienPhong.setText(format.format(TongTienPhong)+" ");
                txtTongTienPT.setText(format.format(tongPhuThu)+" ");
                tblPhuThu.setModel(dtmDanhSachPT);
                Double ThanhTien=TongTienPhong+tongPhuThu;
                txtThanhTien.setText(format.format(ThanhTien)+" ");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.println("");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                System.out.println("");
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPhuThu = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        txtTimKiemKiTu = new javax.swing.JTextField();
        btnTKKiTu = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        txtThoiGianDen = new javax.swing.JSpinner();
        txtThoiGianTu = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnTKThoiGian = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtThanhTien = new javax.swing.JTextField();
        txtTongTienPT = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTongTienPhong = new javax.swing.JTextField();
        btnChartPT = new javax.swing.JButton();
        btnChartHD = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin các hóa đơn"));

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblHoaDon);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin phụ thu"));

        tblPhuThu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblPhuThu);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 727, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm theo kí tự"));

        btnTKKiTu.setText("Tìm kiếm");
        btnTKKiTu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTKKiTuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(txtTimKiemKiTu, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTKKiTu, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(245, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiemKiTu, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTKKiTu, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm theo ngày "));

        txtThoiGianDen.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtThoiGianDen.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.DAY_OF_WEEK));

        txtThoiGianTu.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtThoiGianTu.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.DAY_OF_WEEK));

        jLabel1.setText("Từ");

        jLabel2.setText("Đến");

        btnTKThoiGian.setText("Tìm kiếm");
        btnTKThoiGian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTKThoiGianActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(51, 51, 51)
                .addComponent(txtThoiGianTu, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(61, 61, 61)
                .addComponent(txtThoiGianDen, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnTKThoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtThoiGianDen, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtThoiGianTu, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(btnTKThoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        jLabel3.setText("Thành Tiền");

        jLabel4.setText("Phụ Thu");

        jLabel5.setText("Tổng tiền phòng");

        btnChartPT.setText("Biểu đồ phụ thu");
        btnChartPT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChartPTActionPerformed(evt);
            }
        });

        btnChartHD.setText("Biểu đồ hóa đơn");
        btnChartHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChartHDActionPerformed(evt);
            }
        });

        btnThoat.setBackground(new java.awt.Color(0, 153, 255));
        btnThoat.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnThoat.setForeground(new java.awt.Color(255, 255, 255));
        btnThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QLKS/Image/Windows-Close-Program-icon.png"))); // NOI18N
        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(239, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(46, 46, 46)
                                        .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtTongTienPT, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txtTongTienPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnChartHD)
                                .addGap(18, 18, 18)
                                .addComponent(btnChartPT)
                                .addGap(25, 25, 25))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtTongTienPhong, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtTongTienPT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnChartPT)
                                .addComponent(btnChartHD))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3)))
                        .addContainerGap(55, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(26, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTKKiTuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTKKiTuActionPerformed
        // TODO add your handling code here:
        ((DefaultTableModel)tblHoaDon.getModel()).setNumRows(0); // clear bảng
        String search=txtTimKiemKiTu.getText();
        if(search.equals(""))
        {
            System.out.println("abc");
            try {
                LoadJTable();
            } catch (SQLException ex) {
                Logger.getLogger(frPhuThu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            
            Object[] dataRow;
            String nameKH="";
            String trangThai="";
            List<HoaDon> listHoaDon = null;
            listHoaDon = hdDao.find(new HoaDon(search,search,0,0));
        for (HoaDon hd : listHoaDon) {
            
                try {
                    nameKH = hdDao.findNameKH(hd.getMaKH());
                } catch (SQLException ex) {
                    Logger.getLogger(frNgayLapHoaDon.class.getName()).log(Level.SEVERE, null, ex);
                }
            if(hd.getTrangThai()==1)
            {
                trangThai="Đã thanh toán";
            }
            else
                trangThai="Chưa thanh toán";
            dataRow = new Object[]{hd.getMaHD(), nameKH,hd.getMaDatPhong(), hd.getNgayLapHD(), hd.getThanhTien(), trangThai};
            dtmDanhSachHD.addRow(dataRow);
        }

        tblHoaDon.setModel(dtmDanhSachHD);
        }
    }//GEN-LAST:event_btnTKKiTuActionPerformed

    private void btnTKThoiGianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTKThoiGianActionPerformed
        // TODO add your handling code here:
        ((DefaultTableModel)tblHoaDon.getModel()).setNumRows(0);
        Date thoiGianTu=(Date) txtThoiGianTu.getValue();
        Timestamp Tu=new Timestamp(thoiGianTu.getTime());
        Date thoiGianDen=(Date) txtThoiGianDen.getValue();
        Timestamp Den=new Timestamp(thoiGianDen.getTime());
        List<HoaDon> listHoaDon =hdDao.findbyNgay(Tu, Den);
        Object[] dataRow;
            String nameKH="";
            String trangThai="";                   
        for (HoaDon hd : listHoaDon) {
            
                try {
                    nameKH = hdDao.findNameKH(hd.getMaKH());
                } catch (SQLException ex) {
                    Logger.getLogger(frNgayLapHoaDon.class.getName()).log(Level.SEVERE, null, ex);
                }
            if(hd.getTrangThai()==1)
            {
                trangThai="Đã thanh toán";
            }
            else
                trangThai="Chưa thanh toán";
            dataRow = new Object[]{hd.getMaHD(), nameKH, hd.getNgayLapHD(), hd.getThanhTien(), trangThai};
            dtmDanhSachHD.addRow(dataRow);
        }

        tblHoaDon.setModel(dtmDanhSachHD);
        
    }//GEN-LAST:event_btnTKThoiGianActionPerformed
     public static JFreeChart createChartPT() throws SQLException {
        JFreeChart barChart = ChartFactory.createBarChart(
                "Thông tin phụ thu",
                "Tên sản phẩm", "Số tiền",
                createDatasetPT(), PlotOrientation.VERTICAL, false, false, false);
        return barChart;
    }

    private static CategoryDataset createDatasetPT() throws SQLException {
        Connection conn=  MyConnection.getInstance().getConnection();
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        List<Object> list= new ArrayList<>();
        String queryChart="select TenSP,sum(pt.ThanhTien) as thanhTien from phuthu pt inner join loaisanpham sp on pt.masp=sp.masp group by TenSP";
        PreparedStatement ps= conn.prepareStatement(queryChart);            
        ResultSet rs= ps.executeQuery();
        while (rs.next()) {                
                String TenSP= rs.getString("TenSP");        
                double thanhTien= rs.getDouble("thanhTien");           
                dataset.addValue(thanhTien, "Số tiền", TenSP);    
            }
          
        return dataset;
    }
    private void btnChartPTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChartPTActionPerformed
        // TODO add your handling code here:
        ChartPanel chartPanel = null;
        try {
            chartPanel = new ChartPanel(createChartPT());
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
        JFrame frame = new JFrame();
        frame.add(chartPanel);
        frame.setTitle("Biểu đồ JFreeChart trong Java Swing");
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }//GEN-LAST:event_btnChartPTActionPerformed
//    ============================================Biểu đồ hóa đơn==============================================================
    public static JFreeChart createChartHD() throws SQLException {
        JFreeChart barChart = ChartFactory.createBarChart(
                "Thông tin phụ thu",
                "Tháng", "Số tiền",
                createDatasetHD(), PlotOrientation.VERTICAL, false, false, false);
        return barChart;
    }

    private static CategoryDataset createDatasetHD() throws SQLException {
        Connection conn=  MyConnection.getInstance().getConnection();
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        List<Object> list= new ArrayList<>();
        String queryChart=" SELECT  month(hd.NgayLapHD) as thang,sum(hd.ThanhTien) as thanhTien from hoadon hd GROUP by month(hd.NgayLapHD)";
        PreparedStatement ps= conn.prepareStatement(queryChart);            
        ResultSet rs= ps.executeQuery();
        while (rs.next()) {                
                Double thanhTien= rs.getDouble("thanhTien");        
                int month= rs.getInt("thang");            
                dataset.addValue(thanhTien, "Số tiền",""+month);    
            }
          
        return dataset;
    }
    private void btnChartHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChartHDActionPerformed
        // TODO add your handling code here:
        ChartPanel chartPanel = null;
        try {
            chartPanel = new ChartPanel(createChartHD());
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
        JFrame frame = new JFrame();
        frame.add(chartPanel);
        frame.setTitle("Biểu đồ JFreeChart trong Java Swing");
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }//GEN-LAST:event_btnChartHDActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed

        this.dispose();
        login.h.setVisible(true);
    }//GEN-LAST:event_btnThoatActionPerformed

    /**
     * @param args the command line arguments
     */
    public static  DecimalFormat format = new DecimalFormat("###,###");//0.#
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
            java.util.logging.Logger.getLogger(ChiTietHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChiTietHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChiTietHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChiTietHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ChiTietHoaDon().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(ChiTietHoaDon.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChartHD;
    private javax.swing.JButton btnChartPT;
    private javax.swing.JButton btnTKKiTu;
    private javax.swing.JButton btnTKThoiGian;
    private javax.swing.JButton btnThoat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblPhuThu;
    private javax.swing.JTextField txtThanhTien;
    private javax.swing.JSpinner txtThoiGianDen;
    private javax.swing.JSpinner txtThoiGianTu;
    private javax.swing.JTextField txtTimKiemKiTu;
    private javax.swing.JTextField txtTongTienPT;
    private javax.swing.JTextField txtTongTienPhong;
    // End of variables declaration//GEN-END:variables
DefaultTableModel dtmDanhSachHD;
    HoaDon_PT hdDao= new HoaDon_PT();
    private void LoadJTable() throws SQLException {
        dtmDanhSachHD = new DefaultTableModel();
        String[] columnTitle = {"Mã hóa đơn", "Tên khách hàng","Mã đặt phòng", "Ngày lập hóa đơn","Thành Tiền","Trạng Thái"};
        dtmDanhSachHD.setColumnIdentifiers(columnTitle);
        Object[] dataRow;
        String trangThai="";
        List<HoaDon> listHD = hdDao.getAll();
        double tongTienPhong=0;
        for (HoaDon hd : listHD) {
            String nameKH=hdDao.findNameKH(hd.getMaKH());   
                  tongTienPhong+=hdDao.getPhiPhong(hd.getMaDatPhong());
                 
            if(hd.getTrangThai()==1)
            {
                trangThai="Đã thanh toán";
            }
            else
                trangThai="Chưa thanh toán";
            dataRow = new Object[]{hd.getMaHD(), nameKH,hd.getMaDatPhong(), hd.getNgayLapHD(), hd.getThanhTien(), trangThai};
            dtmDanhSachHD.addRow(dataRow);
        }
        txtTongTienPhong.setText(format.format(tongTienPhong)+" ");

        tblHoaDon.setModel(dtmDanhSachHD);
        tblHoaDon.getColumnModel().getColumn(0).setMaxWidth(100);
        tblHoaDon.getColumnModel().getColumn(1).setPreferredWidth(15);
        tblHoaDon.getColumnModel().getColumn(2).setPreferredWidth(50);
        tblHoaDon.getColumnModel().getColumn(3).setPreferredWidth(50);
        tblHoaDon.getColumnModel().getColumn(4).setPreferredWidth(10);
        tblHoaDon.getColumnModel().getColumn(5).setPreferredWidth(5);
//        tblHoaDon.getColumnModel().getColumn(5).setPreferredWidth(100);

 dtmDanhSachPT = new DefaultTableModel();
        String[] columnTitlePT = {"Mã Phụ Thu", "Tên Khách Hàng", "Tên Sản Phẩm", "Số Lượng", "Ngày Bán", "Thành Tiền"};
        dtmDanhSachPT.setColumnIdentifiers(columnTitlePT);
        Object[] dataRowPT;
        double tongPhuThu=0;
       
        List<PhuThu> listPhuThu = phuThuDao.getAll();
        for (PhuThu p : listPhuThu) {
            String nameKH=phuThuDao.findNameKH(new PhuThu("",p.getMaKH(),"",0,0));
            Optional<SanPham> nameSP= spdao.get(p.getMaSP());    
            dataRowPT = new Object[]{p.getMaPT(), nameKH, nameSP.get().getTenSP(), p.getSoLuong(), p.getNgayBan(), p.getThanhTien()};
            dtmDanhSachPT.addRow(dataRowPT);
            
            tongPhuThu+=p.getThanhTien();
        }
        txtTongTienPT.setText(format.format(tongPhuThu)+" vnđ");
        tblPhuThu.setModel(dtmDanhSachPT);
        tblPhuThu.getColumnModel().getColumn(0).setMaxWidth(0);
        tblPhuThu.getColumnModel().getColumn(1).setPreferredWidth(0);
        tblPhuThu.getColumnModel().getColumn(2).setPreferredWidth(50);
        tblPhuThu.getColumnModel().getColumn(3).setPreferredWidth(10);
        tblPhuThu.getColumnModel().getColumn(4).setPreferredWidth(5);
        tblPhuThu.getColumnModel().getColumn(5).setPreferredWidth(100);
        Double TongTien=tongPhuThu+ tongTienPhong;
        txtThanhTien.setText(format.format(TongTien)+" ");
        
    }
    DefaultTableModel dtmDanhSachPT;
    PhuThuDao phuThuDao= new PhuThuDao();
    SanPhamDao spdao= new SanPhamDao();
    private void LoadJTablePhuThu() throws SQLException {
       
    }
}
