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
public class nguoiDung {
    int maND ;
    String hoTen ;
    String sdt ;
    String email ;
    boolean vip ;
    Date ngayDK ;

    public nguoiDung() {
    }

    public nguoiDung(int maND, String hoTen, String sdt, String email, boolean vip, Date ngayDK) {
        this.maND = maND;
        this.hoTen = hoTen;
        this.sdt = sdt;
        this.email = email;
        this.vip = vip;
        this.ngayDK = ngayDK;
    }

    public int getMaND() {
        return maND;
    }

    public void setMaND(int maND) {
        this.maND = maND;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    public Date getNgayDK() {
        return ngayDK;
    }

    public void setNgayDK(Date ngayDK) {
        this.ngayDK = ngayDK;
    }
    
    
}
