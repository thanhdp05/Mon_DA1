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
    int maND ;
    float tongTien ;
    Date ngayTao ;

    public hoaDon() {
    }

    public hoaDon(int maHD, int maND, float tongTien, Date ngayTao) {
        this.maHD = maHD;
        this.maND = maND;
        this.tongTien = tongTien;
        this.ngayTao = ngayTao;
    }

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public int getMaND() {
        return maND;
    }

    public void setMaND(int maND) {
        this.maND = maND;
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
    
}
