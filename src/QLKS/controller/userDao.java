package QLKS.controller;


import QLKS.dao.Dao;
import QLKS.model.staff;
import QLKS.model.taikhoan;
import static QLKS.view.Staffview.df;
import QLKS.connect.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zzgia
 */
public class userDao implements Dao<taikhoan>{
    private static final String TABLE_NAME = "dangnhap";
    private static final String MANV_FIELD = "MaNV";
    private static final String USERNAME_FIELD = "taikhoan";
    private static final String PASSWORD_FIELD = "matkhau";
    private static final String TENNV_FIELD = "TenNV";
    private static final String EMAIL_FIELD = "Email";
    private static final String TENBOPHAN_FIELD = "TenBoPhan";
    private static final String PHANQUYEN_FIELD = "phanquyen";
    private static final String TRANGTHAI_FIELD = "trangthai";
    Connection conn = MyConnection.getInstance().getConnection();
    
    
    public boolean checkLogin(String username, String password){
        try {
            String sql_select = "SELECT * FROM "+TABLE_NAME+" WHERE "+USERNAME_FIELD+" = ? AND "+PASSWORD_FIELD+" = ?";
            PreparedStatement ps = conn.prepareStatement(sql_select);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {    
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

   
    
    public String doiPQ(String pq){
        if (pq.equals("1")) {
            return "Quản trị";
        } else if(pq.equals("2")){
            return "Quản lý";
        }else {
            return "Nhân viên";
        }
        
    }
    
    public String doiTT(String tt){
        if (tt.equals("0")) {
            return "Khóa";
        } else {
            return "mở";
        }
    }
    public int getCount(String tk) {
        int so = 0;
        try {
            String sql_select = "SELECT COUNT(PhanQuyen) AS dem FROM dangnhap WHERE PhanQuyen = '"+tk+"'";
            PreparedStatement ps = conn.prepareStatement(sql_select);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {     
                so = rs.getInt("dem");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return so;
    }
    public String getmaNV(String tk) {
        String so = "";
        try {
            String sql_select = "SELECT MaNV FROM dangnhap WHERE TaiKhoan = '"+tk+"'";
            PreparedStatement ps = conn.prepareStatement(sql_select);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {     
                so = rs.getString("MaNV");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return so;
    }
    public String getQuyen(String ma) {
        String so = "";
        try {
            String sql_select = "SELECT PhanQuyen FROM dangnhap WHERE PhanQuyen = '"+ma+"'";
            PreparedStatement ps = conn.prepareStatement(sql_select);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {     
                so = rs.getString("PhanQuyen");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        so=doiPQ(so)+" :";
        return so;
    }
    public int getTong() {
        int so = 0;
        try {
            String sql_select = "SELECT COUNT(PhanQuyen) AS dem FROM dangnhap ";
            PreparedStatement ps = conn.prepareStatement(sql_select);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {     
                so = rs.getInt("dem");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return so;
    }
    @Override
    public List<taikhoan> getAll() {
        List<taikhoan> list = new ArrayList<>();
        try {
            String sql_select = "SELECT nv.MaNV,dn.taikhoan,dn.matkhau,nv.TenNV,nv.Email,bp.TenBoPhan,dn.phanquyen,dn.trangthai FROM dangnhap AS dn INNER JOIN nhanvien AS nv ON dn.MaNV = nv.MaNV INNER JOIN bophan AS bp ON nv.MaBoPhan = bp.MaBoPhan";
            PreparedStatement ps = conn.prepareStatement(sql_select);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String maNV = rs.getString(MANV_FIELD);
                String tk = rs.getString(USERNAME_FIELD);
                String mk = rs.getString(PASSWORD_FIELD);
                String tennv = rs.getString(TENNV_FIELD);
                String email = rs.getString(EMAIL_FIELD);
                String tenbp = rs.getString(TENBOPHAN_FIELD);
                String pq = rs.getString(PHANQUYEN_FIELD);
                String tt = rs.getString(TRANGTHAI_FIELD);
                list.add(new taikhoan(maNV, tk, mk, tennv, email, tenbp,pq , tt));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<taikhoan> getAll(String key) {
        List<taikhoan> list = new ArrayList<>();
        try {
            String sql_select = "SELECT nv.MaNV,dn.taikhoan,dn.matkhau,nv.TenNV,nv.Email,bp.TenBoPhan,dn.phanquyen,dn.trangthai FROM dangnhap AS dn INNER JOIN nhanvien AS nv ON dn.MaNV = nv.MaNV INNER JOIN bophan AS bp ON nv.MaBoPhan = bp.MaBoPhan where "
                                +TENNV_FIELD+" like '%"+key+"%'";
            PreparedStatement ps = conn.prepareStatement(sql_select);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                    
                String maNV = rs.getString(MANV_FIELD);
                String tk = rs.getString(USERNAME_FIELD);
                String mk = rs.getString(PASSWORD_FIELD);
                String tennv = rs.getString(TENNV_FIELD);
                String email = rs.getString(EMAIL_FIELD);
                String tenbp = rs.getString(TENBOPHAN_FIELD);
                String pq = rs.getString(PHANQUYEN_FIELD);
                String tt = rs.getString(TRANGTHAI_FIELD);
                list.add(new taikhoan(maNV, tk, mk, tennv, email, tenbp,pq , tt));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    @Override
    public Optional<taikhoan> get(int id) {
        taikhoan st = new taikhoan();
        try {
            String sql_select_by_id = "SELECT nv.MaNV,dn.taikhoan,dn.matkhau,nv.TenNV,nv.Email,bp.TenBoPhan,dn.phanquyen,dn.trangthai FROM dangnhap AS dn INNER JOIN nhanvien AS nv ON dn.MaNV = nv.MaNV INNER JOIN bophan AS bp ON nv.MaBoPhan = bp.MaBoPhan where "+MANV_FIELD+" = ?";
            PreparedStatement ps = conn.prepareStatement(sql_select_by_id);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {    
                st.setMaNV(rs.getString(MANV_FIELD));
                st.setTaikhoan(rs.getString(USERNAME_FIELD));
                st.setMatkhau(rs.getString(PASSWORD_FIELD));
                st.setTenNV(rs.getString(TENNV_FIELD));
                st.setEmail(rs.getString(EMAIL_FIELD));
                st.setBophan(rs.getString(TENBOPHAN_FIELD));
                st.setQuyen(rs.getString(PHANQUYEN_FIELD));
                st.setTrangthai(rs.getString(TRANGTHAI_FIELD));
                
               
            }
        } catch (Exception e) {
        }
        return Optional.of(st);
    }

    @Override
    public Optional<taikhoan> get(String id) {
        taikhoan st = new taikhoan();
        try {
            String sql_select_by_id = "SELECT nv.MaNV,dn.taikhoan,dn.matkhau,nv.TenNV,nv.Email,bp.TenBoPhan,dn.phanquyen,dn.trangthai FROM dangnhap AS dn INNER JOIN nhanvien AS nv ON dn.MaNV = nv.MaNV INNER JOIN bophan AS bp ON nv.MaBoPhan = bp.MaBoPhan where "
                                        +USERNAME_FIELD+" = ?";
            PreparedStatement ps = conn.prepareStatement(sql_select_by_id);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {    
                st.setMaNV(rs.getString(MANV_FIELD));
                st.setTaikhoan(rs.getString(USERNAME_FIELD));
                st.setMatkhau(rs.getString(PASSWORD_FIELD));
                st.setTenNV(rs.getString(TENNV_FIELD));
                st.setEmail(rs.getString(EMAIL_FIELD));
                st.setBophan(rs.getString(TENBOPHAN_FIELD));
                st.setQuyen(rs.getString(PHANQUYEN_FIELD));
                st.setTrangthai(rs.getString(TRANGTHAI_FIELD));
                
            }
        } catch (Exception e) {
        }
        return Optional.of(st);
    }

    @Override
    public int insert(taikhoan t) {
        try {
            String sql_insert = "insert into "+TABLE_NAME+" values(?, ?, ?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql_insert, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, t.getTaikhoan());
            ps.setString(2, t.getMatkhau());
            ps.setString(3, t.getMaNV());
            ps.setString(4, t.getQuyen() );
            ps.setString(5, t.getTrangthai());
            int k = ps.executeUpdate();
            if (k > 0) {
                ResultSet rsKey = ps.getGeneratedKeys();  
                if (rsKey.next()) {
                    return rsKey.getInt(1);
                }else{
                    return 1;
                }                
            } else {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(taikhoan t) {
        try {
            String sql_update = "UPDATE "+TABLE_NAME+" SET  "+PASSWORD_FIELD+" = ?, "+MANV_FIELD+" = ?, "+PHANQUYEN_FIELD+" = ?, "+TRANGTHAI_FIELD+"  = ? WHERE "+USERNAME_FIELD+" = ? ";
            PreparedStatement ps = conn.prepareStatement(sql_update);
            
            ps.setString(1, t.getMatkhau());
            ps.setString(2, t.getMaNV());
            ps.setString(3, t.getQuyen());
            ps.setString(4, t.getTrangthai());
            ps.setString(5, t.getTaikhoan());
            int k = ps.executeUpdate();
            if (k > 0) {
                return 1;
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(taikhoan t) {
        try {
            String sql_delete = "DELETE FROM "+TABLE_NAME+" WHERE "+USERNAME_FIELD+" = ?";
            PreparedStatement ps = conn.prepareStatement(sql_delete);
            ps.setString(1, t.getTaikhoan());
            int k = ps.executeUpdate();
            if (k > 0) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(String t) {
        try {
            String sql_delete = "DELETE FROM "+TABLE_NAME+" WHERE "+USERNAME_FIELD+" = ?";
            PreparedStatement ps = conn.prepareStatement(sql_delete);
            ps.setString(1, t);
            int k = ps.executeUpdate();
            if (k > 0) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<taikhoan> find(String t) {
        List<taikhoan> list = new ArrayList<>();
        try {
            String sql_find = "SELECT nv.MaNV,dn.taikhoan,dn.matkhau,nv.TenNV,nv.Email,bp.TenBoPhan,dn.phanquyen,dn.trangthai FROM dangnhap AS dn INNER JOIN nhanvien AS nv ON dn.MaNV = nv.MaNV INNER JOIN bophan AS bp ON nv.MaBoPhan = bp.MaBoPhan where "
                                +" 1";
            if (!t.equals("")) {
                sql_find += " AND "+TENNV_FIELD+" like '%"+t+"%'";
            } 
            PreparedStatement ps = conn.prepareStatement(sql_find);
            System.out.println(ps.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                    
                String maNV = rs.getString(MANV_FIELD);
                String tk = rs.getString(USERNAME_FIELD);
                String mk = rs.getString(PASSWORD_FIELD);
                String tennv = rs.getString(TENNV_FIELD);
                String email = rs.getString(EMAIL_FIELD);
                String tenbp = rs.getString(TENBOPHAN_FIELD);
                String pq = rs.getString(PHANQUYEN_FIELD);
                String tt = rs.getString(TRANGTHAI_FIELD);
                list.add(new taikhoan(maNV, tk, mk, tennv, email, tenbp,pq , tt));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<taikhoan> find(taikhoan t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<taikhoan> getList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(String t, String x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int findT(String t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getData(String dataIn, String colIn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<taikhoan> find(String data, String colName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
