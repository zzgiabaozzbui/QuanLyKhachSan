/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLKS.view;

import QLKS.Chart.ChartTaiKhoan;
import QLKS.Home.Home;
import QLKS.Home.pnLeft;
import QLKS.Login.login;
import QLKS.controller.StaffDao;
import QLKS.controller.Xuatexcel;
import QLKS.controller.bophanDao;
import QLKS.controller.userDao;
import QLKS.model.bophan;
import QLKS.model.staff;
import QLKS.model.taikhoan;
import static QLKS.view.Staffview.df;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.util.Duration.millis;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author zzgia
 */
public class TaiKhoanview extends javax.swing.JFrame {
    String idUpdae ="";
    /**
     * Creates new form Menu
     */
    private void khoa(){
        txtTen.setEnabled(false);
        txtemail.setEnabled(false);
        txtbp.setEnabled(false);
        cboMaNV.setEnabled(false);
    }
    public TaiKhoanview()  {
        initComponents();
        txtTK.requestFocusInWindow();
        cboMaNV.setBackground(Color.white);
        cboQ.setBackground(Color.white);
        cboTT.setBackground(Color.white);
        tblTK.getTableHeader().setFont(new Font("Arial", Font.BOLD, 18));
        btnS.setEnabled(false);
        btnX.setEnabled(false);
        setExtendedState(MAXIMIZED_BOTH);
        khoa();
        loadStafflist();
        loadTable();
        //Sự kiện click vào 1 dong trong table
        tblTK.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                txtTK.setEnabled(false);
                btnT.setEnabled(false);
                btnS.setEnabled(true);
                btnX.setEnabled(true);
                int index = tblTK.getSelectedRow();
                String valueAt = (String) tblTK.getValueAt(index, 1);
                StaffDao staffdao = new StaffDao();
                userDao usd  = new userDao();
                taikhoan pUpdate = usd.get(valueAt+"").get();
                
                txtTK.setText(pUpdate.getTaikhoan());
                txtMK.setText(pUpdate.getMatkhau());
                txtemail.setText(pUpdate.getEmail());
                
                
                txtTen.setText(pUpdate.getTenNV());
                txtemail.setText(pUpdate.getEmail());
                txtbp.setText(pUpdate.getBophan());
                loadcboAllStaff();
                                
                cboMaNV.setSelectedItem(pUpdate.getMaNV());
                cboQ.setSelectedItem(userdao.doiPQ(pUpdate.getQuyen()));
                cboTT.setSelectedItem(userdao.doiTT(pUpdate.getTrangthai()));
                
                idUpdae = valueAt;

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
            public void mouseExited(MouseEvent e) {
               System.out.println("");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.println("");
            }

        });
//        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    void setlabel(){
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        pnBorder1 = new QLKS.Home.pnBorder();
        pnSearch = new javax.swing.JPanel();
        iconSearch = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        pnBorder2 = new QLKS.Home.pnBorder();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTK = new javax.swing.JTable();
        pnBorder3 = new QLKS.Home.pnBorder();
        btnT = new javax.swing.JButton();
        btnS = new javax.swing.JButton();
        btnX = new javax.swing.JButton();
        btnexit = new javax.swing.JButton();
        btnExcel = new javax.swing.JButton();
        lblerro = new javax.swing.JLabel();
        btnReset = new javax.swing.JButton();
        btnBieuDo = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        pnBorder5 = new QLKS.Home.pnBorder();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtTK = new javax.swing.JTextField();
        txtMK = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        txtbp = new javax.swing.JTextField();
        cboQ = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        cboTT = new javax.swing.JComboBox<>();
        cboMaNV = new javax.swing.JComboBox<>();
        pnBorder4 = new QLKS.Home.pnBorder();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstNhanVien = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý nhân viên");

        pnBorder1.setBackground(new java.awt.Color(255, 255, 255));

        pnSearch.setBackground(new java.awt.Color(255, 255, 255));
        pnSearch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        iconSearch.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search30.png"))); // NOI18N
        iconSearch.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        txtSearch.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        txtSearch.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtSearch.setText("Tìm kiếm...");
        txtSearch.setBorder(null);
        txtSearch.setName(""); // NOI18N
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnSearchLayout = new javax.swing.GroupLayout(pnSearch);
        pnSearch.setLayout(pnSearchLayout);
        pnSearchLayout.setHorizontalGroup(
            pnSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnSearchLayout.createSequentialGroup()
                .addComponent(iconSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1358, 1358, 1358))
        );
        pnSearchLayout.setVerticalGroup(
            pnSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnSearchLayout.createSequentialGroup()
                .addGroup(pnSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(iconSearch))
                .addGap(0, 3, Short.MAX_VALUE))
        );

        pnBorder2.setBackground(new java.awt.Color(255, 255, 255));
        pnBorder2.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách tài khoản"));

        tblTK.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblTK);

        javax.swing.GroupLayout pnBorder2Layout = new javax.swing.GroupLayout(pnBorder2);
        pnBorder2.setLayout(pnBorder2Layout);
        pnBorder2Layout.setHorizontalGroup(
            pnBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnBorder2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        pnBorder2Layout.setVerticalGroup(
            pnBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBorder2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnBorder3.setBackground(new java.awt.Color(255, 255, 255));
        pnBorder3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnT.setBackground(new java.awt.Color(255, 255, 255));
        btnT.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add_35_gradian.png"))); // NOI18N
        btnT.setText("Thêm");
        btnT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTActionPerformed(evt);
            }
        });

        btnS.setBackground(new java.awt.Color(255, 255, 255));
        btnS.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/update_35_gradian.png"))); // NOI18N
        btnS.setText("Sửa");
        btnS.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSActionPerformed(evt);
            }
        });

        btnX.setBackground(new java.awt.Color(255, 255, 255));
        btnX.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete_35_gradien.png"))); // NOI18N
        btnX.setText("Xóa");
        btnX.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnX.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXMouseClicked(evt);
            }
        });
        btnX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXActionPerformed(evt);
            }
        });

        btnexit.setBackground(new java.awt.Color(255, 255, 255));
        btnexit.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnexit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/thoat_35.png"))); // NOI18N
        btnexit.setText("Thoát");
        btnexit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexitActionPerformed(evt);
            }
        });

        btnExcel.setBackground(new java.awt.Color(255, 255, 255));
        btnExcel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/excel_35.png"))); // NOI18N
        btnExcel.setText("Xuất excel");
        btnExcel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcelActionPerformed(evt);
            }
        });

        lblerro.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        lblerro.setForeground(new java.awt.Color(255, 0, 0));
        lblerro.setText(" ");

        btnReset.setBackground(new java.awt.Color(255, 255, 255));
        btnReset.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/quay_lai_35.png"))); // NOI18N
        btnReset.setText("Nhập lại");
        btnReset.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnBieuDo.setBackground(new java.awt.Color(255, 255, 255));
        btnBieuDo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnBieuDo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/chart_35.png"))); // NOI18N
        btnBieuDo.setText("Thống kê");
        btnBieuDo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnBieuDo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBieuDoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnBorder3Layout = new javax.swing.GroupLayout(pnBorder3);
        pnBorder3.setLayout(pnBorder3Layout);
        pnBorder3Layout.setHorizontalGroup(
            pnBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBorder3Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(btnT, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(btnS, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79)
                .addComponent(btnX, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(btnExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(btnBieuDo, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(btnexit, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
            .addGroup(pnBorder3Layout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addComponent(lblerro, javax.swing.GroupLayout.PREFERRED_SIZE, 1105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(254, Short.MAX_VALUE))
        );
        pnBorder3Layout.setVerticalGroup(
            pnBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBorder3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBieuDo, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnX, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnS, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnT, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnexit, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblerro, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        btnSearch.setBackground(new java.awt.Color(51, 204, 255));
        btnSearch.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setText("Tìm kiếm");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("QUẢN LÝ TÀI KHOẢN");

        pnBorder5.setBackground(new java.awt.Color(255, 255, 255));
        pnBorder5.setBorder(javax.swing.BorderFactory.createTitledBorder("Chi tiết tài khoản"));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Mã nhân viên:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Bộ phận:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Họ và tên:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Mật khẩu:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Quyền:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Email:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Tài khoản:");

        txtTK.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtTK.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTKActionPerformed(evt);
            }
        });

        txtMK.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtMK.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtMK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMKActionPerformed(evt);
            }
        });

        txtTen.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtTen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtemail.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtemail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtbp.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtbp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cboQ.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nhân viên", "Quản trị", "Quản lý" }));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Trạng thái:");

        cboTT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mở", "Khóa" }));

        javax.swing.GroupLayout pnBorder5Layout = new javax.swing.GroupLayout(pnBorder5);
        pnBorder5.setLayout(pnBorder5Layout);
        pnBorder5Layout.setHorizontalGroup(
            pnBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBorder5Layout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addGroup(pnBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel2)
                    .addComponent(jLabel11)
                    .addComponent(jLabel8))
                .addGap(63, 63, 63)
                .addGroup(pnBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboQ, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboTT, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTK, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(pnBorder5Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel7))
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(44, 44, 44)
                .addGroup(pnBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtbp, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMK, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnBorder5Layout.setVerticalGroup(
            pnBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBorder5Layout.createSequentialGroup()
                .addGap(232, 232, 232)
                .addGroup(pnBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtbp, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboQ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(89, 89, 89))
            .addGroup(pnBorder5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtMK, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTK, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(46, 46, 46)
                .addGroup(pnBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(50, 50, 50)
                .addGroup(pnBorder5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(157, 157, 157))
        );

        pnBorder4.setBackground(new java.awt.Color(255, 255, 255));
        pnBorder4.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách nhân viên không có tài khoản"));

        jScrollPane2.setViewportView(lstNhanVien);

        javax.swing.GroupLayout pnBorder4Layout = new javax.swing.GroupLayout(pnBorder4);
        pnBorder4.setLayout(pnBorder4Layout);
        pnBorder4Layout.setHorizontalGroup(
            pnBorder4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBorder4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnBorder4Layout.setVerticalGroup(
            pnBorder4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBorder4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 779, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnBorder1Layout = new javax.swing.GroupLayout(pnBorder1);
        pnBorder1.setLayout(pnBorder1Layout);
        pnBorder1Layout.setHorizontalGroup(
            pnBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBorder1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(pnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnBorder4, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnBorder3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnBorder2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnBorder5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnBorder1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(559, 559, 559))
        );
        pnBorder1Layout.setVerticalGroup(
            pnBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBorder1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addGroup(pnBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(pnBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnBorder4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnBorder1Layout.createSequentialGroup()
                        .addComponent(pnBorder2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnBorder5, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnBorder3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        if (txtSearch.getText().equals("Tìm kiếm...")) {
            loadTable();
        } else {
            loadTable(txtSearch.getText());
        }
        
    }//GEN-LAST:event_btnSearchActionPerformed
        
    private Boolean checkMa(String ma){
        List<taikhoan> list = new ArrayList<>();
        list = userdao.getAll();
        for (taikhoan b : list) {
            if(ma.equals(b.getMaNV())){
                return true;
            }
        }
        return false;
    }
     public String doiPQ(String pq){
        if (pq.equals("Quản trị")) {
            return "1";
        } else if(pq.equals("Quản lý")){
            return "2";
        }else {
            return "3";
        }
        
    }
    
    public String doiTT(String tt){
        if (tt.equals("Khóa")) {
            return "0";
        } else {
            return "1";
        }
    }
    private void btnTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTActionPerformed
        lblerro.setText(" ");
        
        if (txtTK.getText().equals("")) {
            lblerro.setText("Hãy điền tên tài khoản");
        } else if(checkMa(txtTK.getText())==true){
            lblerro.setText("Tài khoản đã tồn tại");
        } else if(txtMK.getText().equals("")){
            lblerro.setText("Hãy điền mật khẩu");
        }else if(txtTen.getText().equals("") || txtbp.getText().equals("") || txtemail.getText().equals("")){
            lblerro.setText("Bạn chưa chọn chủ tài khoản");
        }else {
            int result = JOptionPane.showConfirmDialog(this,"Bạn có chắc muốn thêm mới tài khoản này không?","Xác nhận",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if(result == JOptionPane.YES_OPTION){
                
                
                String manv = (String) cboMaNV.getSelectedItem();
                String q = doiPQ((String) cboQ.getSelectedItem());
                String tt =doiTT((String) cboTT.getSelectedItem());
                taikhoan newtk = new taikhoan(manv, txtTK.getText(), txtMK.getText(), "", "", "", q, tt);
                
                int a = userdao.insert(newtk);
                if (a==1) {
                    JOptionPane.showMessageDialog(this,"Thêm mới một tài khoản thành công!","Thêm mới nhân viên.",JOptionPane.INFORMATION_MESSAGE);
                    lblerro.setText(" ");
                    loadTable();
                }else
                    JOptionPane.showMessageDialog(this,"Thêm mới một tài khoản thất bại!","Thêm mới nhân viên.",JOptionPane.INFORMATION_MESSAGE);
                
            }
        }
        
    }//GEN-LAST:event_btnTActionPerformed

    private void btnXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXActionPerformed
        
    }//GEN-LAST:event_btnXActionPerformed

    private void btnSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSActionPerformed
        lblerro.setText(" ");
        
        if (txtTK.getText().equals("")) {
            lblerro.setText("Hãy điền tên tài khoản");
        } else if(checkMa(txtTK.getText())==true){
            lblerro.setText("Tài khoản đã tồn tại");
        } else if(txtMK.getText().equals("")){
            lblerro.setText("Hãy điền mật khẩu");
        }else if(txtTen.getText().equals("") || txtbp.getText().equals("") || txtemail.getText().equals("")){
            lblerro.setText("Bạn chưa chọn chủ tài khoản");
        }else {
            int result = JOptionPane.showConfirmDialog(this,"Bạn có chắc muốn sửa nhân viên này không?","Xác nhận",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if(result == JOptionPane.YES_OPTION){
                bophanDao bo =  new bophanDao();
                taikhoan tk = new taikhoan();
                tk.setMaNV((String)cboMaNV.getSelectedItem());
                String q = doiPQ((String) cboQ.getSelectedItem());
                String tt =doiTT((String) cboTT.getSelectedItem());
                
                taikhoan newtk = new taikhoan((String)cboMaNV.getSelectedItem(), txtTK.getText(), txtMK.getText(), txtTen.getText(), txtemail.getText(),bo.getMabp(txtbp.getText()), q, tt);
                int a = userdao.update(newtk);
                if (a==1) {
                    JOptionPane.showMessageDialog(this,"Sửa mới một nhân viên thành công!","Thêm mới nhân viên.",JOptionPane.INFORMATION_MESSAGE);
                    lblerro.setText(" ");
                    this.dispose();
                    new TaiKhoanview().setVisible(true);
                }else
                    JOptionPane.showMessageDialog(this,"Sửa mới một nhân viên thất bại!","Thêm mới nhân viên.",JOptionPane.INFORMATION_MESSAGE);
                
                
            }

        }
    }//GEN-LAST:event_btnSActionPerformed

    private void btnexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexitActionPerformed
        this.dispose();
        login.h.setVisible(true);
    }//GEN-LAST:event_btnexitActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        loadTable();
        txtTK.setText("");
        txtTen.setText("");
        txtMK.setText("");
        txtemail.setText("");
        txtbp.setText("");
        cboMaNV.removeAllItems();
        cboTT.setSelectedIndex(0);
        cboQ.setSelectedIndex(0);
        btnT.setEnabled(true);
        btnS.setEnabled(false);
        btnX.setEnabled(false);
    }//GEN-LAST:event_btnResetActionPerformed
    public ChartTaiKhoan cs;
    private void btnBieuDoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBieuDoActionPerformed
        cs = new ChartTaiKhoan(this);
        cs.setVisible(true);
    }//GEN-LAST:event_btnBieuDoActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtMKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMKActionPerformed

    private void txtTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTKActionPerformed

    private void btnExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcelActionPerformed
        int result = JOptionPane.showConfirmDialog(this,"Bạn có chắc muốn xuất excel không?","Xác nhận",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if(result == JOptionPane.YES_OPTION){
                new Xuatexcel().excel(tblTK, "TÀI KHOẢN", "tk");
                JOptionPane.showMessageDialog(this,"Xuất excel thành công!","Excel.",JOptionPane.INFORMATION_MESSAGE);
                
            }
        
    }//GEN-LAST:event_btnExcelActionPerformed

    private void btnXMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXMouseClicked
        int result = JOptionPane.showConfirmDialog(this,"Bạn có chắc muốn xoá tài khoản này không?","Xác nhận",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if(result == JOptionPane.YES_OPTION){
                int a = userdao.delete(txtTK.getText());
                if (a==1) {
                    JOptionPane.showMessageDialog(this,"Xóa tài khoản thành công!","Xóa nhân viên.",JOptionPane.INFORMATION_MESSAGE);
                    lblerro.setText(" ");
                    loadTable();
                }else
                    JOptionPane.showMessageDialog(this,"Xóa tài khoản thất bại!","Xóa nhân viên.",JOptionPane.INFORMATION_MESSAGE);
                
            }
    }//GEN-LAST:event_btnXMouseClicked

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TaiKhoanview().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBieuDo;
    private javax.swing.JButton btnExcel;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnS;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnT;
    private javax.swing.JButton btnX;
    private javax.swing.JButton btnexit;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboMaNV;
    private javax.swing.JComboBox<String> cboQ;
    private javax.swing.JComboBox<String> cboTT;
    private javax.swing.JLabel iconSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblerro;
    private javax.swing.JList<staff> lstNhanVien;
    private QLKS.Home.pnBorder pnBorder1;
    private QLKS.Home.pnBorder pnBorder2;
    private QLKS.Home.pnBorder pnBorder3;
    private QLKS.Home.pnBorder pnBorder4;
    private QLKS.Home.pnBorder pnBorder5;
    private javax.swing.JPanel pnSearch;
    private javax.swing.JTable tblTK;
    private javax.swing.JTextField txtMK;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTK;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtbp;
    private javax.swing.JTextField txtemail;
    // End of variables declaration//GEN-END:variables
    
    
    
    
    
    //Nhớ thêm hàm add selecteditem mã của nhân viên chưa có tài khoản cho cbo và 1 hàm của tất cả mã nhân viên
    private DefaultListModel<staff> dlmnv;
    public static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    private StaffDao std = new StaffDao();
    public void loadcboStaff(){
        cboMaNV.removeAllItems();
        for (staff st : std.getNV()) {
            cboMaNV.addItem(st.getMaNV());
        }
    }
    public void loadcboAllStaff(){
        cboMaNV.removeAllItems();
        for (staff st : std.getAllNV()){
            cboMaNV.addItem(st.getMaNV());
        }
    }
    
    
    
    
    //Load dư liêu vao list
    
    public void loadStafflist(){        
        dlmnv=new DefaultListModel<>();
        for (staff st : std.getNV()) {
            dlmnv.addElement(st);
        }
        lstNhanVien.setModel(dlmnv);
    }
    //Load dữ liệu vào bảng
    DefaultTableModel dtmDanhSach;
    userDao userdao = new userDao();
    private void loadTable(){
        dtmDanhSach = new DefaultTableModel();
        
        String[] columnTitle = {"Mã nhân viên", "Tên tài khoản","Mật khẩu", "Tên nhân viên", "Email","Tên bộ phận","Quyền","Trạng thái"};
        dtmDanhSach.setColumnIdentifiers(columnTitle);
        Object[] dataRow;
        List<taikhoan> lisstaff = userdao.getAll();
        for (taikhoan p : lisstaff) {

            dataRow = new Object[]{p.getMaNV(),p.getTaikhoan(),p.getMatkhau(),p.getTenNV(),p.getEmail(),p.getBophan(),userdao.doiPQ(p.getQuyen()),userdao.doiTT(p.getTrangthai())};
            dtmDanhSach.addRow(dataRow);
        }

        tblTK.setModel(dtmDanhSach);
        
        
        tblTK.getColumnModel().getColumn(0).setPreferredWidth(15);
        tblTK.getColumnModel().getColumn(1).setPreferredWidth(15);
        tblTK.getColumnModel().getColumn(2).setPreferredWidth(50);
        tblTK.getColumnModel().getColumn(3).setPreferredWidth(25);
        tblTK.getColumnModel().getColumn(4).setPreferredWidth(5);
        tblTK.getColumnModel().getColumn(5).setPreferredWidth(50);
        tblTK.getColumnModel().getColumn(6).setPreferredWidth(50);
        tblTK.getColumnModel().getColumn(7).setPreferredWidth(90);
        lstNhanVien.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                if (!e.getValueIsAdjusting()) {
                    loadcboStaff();
                    
                    Object[] dataRow;
                    staff selectedValues = lstNhanVien.getSelectedValue();
                    if(selectedValues.getMaBP().equals("-1000")){
                            
                    }else{
                        cboMaNV.setSelectedItem(selectedValues.getMaNV());
                        cboQ.setSelectedItem(selectedValues.getMaNV());
                        txtTen.setText(selectedValues.getTenNV());
                        txtemail.setText(selectedValues.getEmail());
                        txtbp.setText(selectedValues.getDiachi());

                    }
                    
                }
            }
        });
        
    }
    private void loadTable(String key){
        dtmDanhSach = new DefaultTableModel();
        
        String[] columnTitle = {"Mã nhân viên", "Tên tài khoản","Mật khẩu", "Tên nhân viên", "Email","Tên bộ phận","Quyền","Trạng thái"};
        dtmDanhSach.setColumnIdentifiers(columnTitle);
        Object[] dataRow;
        List<taikhoan> lisstaff = userdao.getAll(key);
        for (taikhoan p : lisstaff) {

            dataRow = new Object[]{p.getMaNV(),p.getTaikhoan(),p.getMatkhau(),p.getTenNV(),p.getEmail(),p.getBophan(),userdao.doiPQ(p.getQuyen()),userdao.doiTT(p.getTrangthai())};
            dtmDanhSach.addRow(dataRow);
        }

        tblTK.setModel(dtmDanhSach);
        
        
        tblTK.getColumnModel().getColumn(0).setPreferredWidth(15);
        tblTK.getColumnModel().getColumn(1).setPreferredWidth(15);
        tblTK.getColumnModel().getColumn(2).setPreferredWidth(50);
        tblTK.getColumnModel().getColumn(3).setPreferredWidth(25);
        tblTK.getColumnModel().getColumn(4).setPreferredWidth(5);
        tblTK.getColumnModel().getColumn(5).setPreferredWidth(50);
        tblTK.getColumnModel().getColumn(6).setPreferredWidth(50);
        tblTK.getColumnModel().getColumn(7).setPreferredWidth(90);
        lstNhanVien.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                if (!e.getValueIsAdjusting()) {
                    loadcboStaff();
                    
                    Object[] dataRow;
                    staff selectedValues = lstNhanVien.getSelectedValue();
                    if(selectedValues.getMaBP().equals("-1000")){
                            
                    }else{
                        cboMaNV.setSelectedItem(selectedValues.getMaNV());
                        cboQ.setSelectedItem(selectedValues.getMaNV());
                        txtTen.setText(selectedValues.getTenNV());
                        txtemail.setText(selectedValues.getEmail());
                        txtbp.setText(selectedValues.getDiachi());

                    }
                    
                }
            }
        });
        
    }
}
