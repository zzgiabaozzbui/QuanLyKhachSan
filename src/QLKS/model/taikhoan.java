/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLKS.model;

/**
 *
 * @author zzgia
 */
public class taikhoan {
    private String maNV;
    private String taikhoan;
    private String matkhau;
    private String tenNV;
    private String email;
    private String bophan;
    private String quyen;
    private String trangthai;

    public taikhoan() {
    }

    public taikhoan(String maNV, String taikhoan, String matkhau, String tenNV, String email, String bophan, String quyen, String trangthai) {
        this.maNV = maNV;
        this.taikhoan = taikhoan;
        this.matkhau = matkhau;
        this.tenNV = tenNV;
        this.email = email;
        this.bophan = bophan;
        this.quyen = quyen;
        this.trangthai = trangthai;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTaikhoan() {
        return taikhoan;
    }

    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBophan() {
        return bophan;
    }

    public void setBophan(String bophan) {
        this.bophan = bophan;
    }

    public String getQuyen() {
        return quyen;
    }

    public void setQuyen(String quyen) {
        this.quyen = quyen;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    @Override
    public String toString() {
        return "taikhoan{" + "maNV=" + maNV + ", taikhoan=" + taikhoan + ", matkhau=" + matkhau + ", tenNV=" + tenNV + ", email=" + email + ", bophan=" + bophan + ", quyen=" + quyen + ", trangthai=" + trangthai + '}';
    }

    
    
}
