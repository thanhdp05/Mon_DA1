/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntdk.dao;

import com.ntdk.entity.KhachHang;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class khachHang_DAO extends NTDK_DAO<KhachHang, Integer> {

    String INSERT_KHACHHANG = "insert khachHang (hoTen, sdt, email, ngayDK, vip) values (?, ?, ?, ?, ?)";
    String UPDATE_KHACHHANG = "update khachHang set hoTen = ?, sdt = ?, email = ?, ngayDK = ?, vip = ? where maKH = ?";
    String DELETE_KHACHHANG = "delete khachHang where maKH = ?";
    String SELECT_KHACHHANG_ALL = "select * from khachHang";
    String SELECT_KHACHHANG_WHERE = "select * from khachHang where maKH = ?";

    public List<KhachHang> selectByKeyWord(String keyWord) {
        String sql = "select * from khachHang where hoTen like ? or sdt = ?";
        return this.selectBySql(sql, "%" + keyWord + "%", keyWord);
    }

    @Override
    public void insert(KhachHang entity) {
        try {
            JdbcHelper.update(INSERT_KHACHHANG, entity.getHoTen(), entity.getSdt(), entity.getEmail(), entity.getNgayDK(), entity.isVip());
        } catch (SQLException ex) {
            Logger.getLogger(khachHang_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(KhachHang entity) {
        try {
            JdbcHelper.update(UPDATE_KHACHHANG, entity.getHoTen(), entity.getSdt(), entity.getEmail(), entity.getNgayDK(), entity.isVip(), entity.getMaKH());
        } catch (SQLException ex) {
            Logger.getLogger(khachHang_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            JdbcHelper.update(DELETE_KHACHHANG, id);
        } catch (SQLException ex) {
            Logger.getLogger(khachHang_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public KhachHang selectById(Integer id) {
        List<KhachHang> list_kh = this.selectBySql(SELECT_KHACHHANG_WHERE, id);
        if (list_kh.isEmpty()) {
            return null;
        }
        return list_kh.get(0);
    }

    @Override
    public List<KhachHang> selectAll() {
        return this.selectBySql(SELECT_KHACHHANG_ALL);
    }

    @Override
    protected List<KhachHang> selectBySql(String sql, Object... args) {
        List<KhachHang> list_kh = new ArrayList<KhachHang>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                KhachHang nd = new KhachHang();
                nd.setMaKH(rs.getInt("maKH"));
                nd.setHoTen(rs.getString("hoTen"));
                nd.setSdt(rs.getString("sdt"));
                nd.setEmail(rs.getString("email"));
                nd.setNgayDK(rs.getDate("ngayDK"));
                nd.setVip(rs.getBoolean("vip"));
                list_kh.add(nd);
            }
            rs.getStatement().getConnection().close();
            return list_kh;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

}
