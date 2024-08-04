/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntdk.entity;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class hoaDon {
    int maHD ;
    int maKH ;
    float tongTien ;
    Date ngayTao ;
    String maNV ;

    public hoaDon() {
    }

    public hoaDon(int maHD, int maKH, float tongTien, Date ngayTao, String maNV) {
        this.maHD = maHD;
        this.maKH = maKH;
        this.tongTien = tongTien;
        this.ngayTao = ngayTao;
        this.maNV = maNV;
    }

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    
}
