package model;

import java.time.LocalDate;

public class NhanVien {
    private int ID;
    private String tenNV;
    private LocalDate ngaysinh;
    private   String diachi;
    private  String soDienThoai;
    private  String Email;
    private  PhongBan Phongban;

    public NhanVien(int ID, String tenNV, LocalDate ngaysinh, String diachi, String soDienThoai, String email, PhongBan phongban) {
        this.ID = ID;
        this.tenNV = tenNV;
        this.ngaysinh = ngaysinh;
        this.diachi = diachi;
        this.soDienThoai = soDienThoai;
        Email = email;
        Phongban = phongban;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public LocalDate getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(LocalDate ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public PhongBan getPhongban() {
        return Phongban;
    }

    public void setPhongban(PhongBan phongban) {
        Phongban = phongban;
    }
}


