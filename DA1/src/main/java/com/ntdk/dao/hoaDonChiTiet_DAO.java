/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntdk.dao;

import com.ntdk.entity.hoaDon;
import com.ntdk.entity.hoaDonChiTiet;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class hoaDonChiTiet_DAO extends NTDK_DAO<hoaDonChiTiet, Integer> {

    String INSERT_HOADONCT = "insert hoaDonChiTiet (maHD, maSP, soLuong, donGia) values (?, ?, ?, ?)";
    String SELECT_HOADONCT = "select * from hoaDonChiTiet";
    String SELECT_HOADONCT_WHERE = "select * from hoaDonChiTiet where maHD = ?";

    @Override
    public void insert(hoaDonChiTiet entity) {
        try {
            JdbcHelper.update(INSERT_HOADONCT, entity.getMaSP(), entity.getSoLuong(), entity.getDonGia());
        } catch (SQLException ex) {
            Logger.getLogger(loaiSP_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(hoaDonChiTiet entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public hoaDonChiTiet selectById(Integer id) {
        List<hoaDonChiTiet> list_hdct = this.selectBySql(SELECT_HOADONCT_WHERE, id);
        if (list_hdct.isEmpty()) {
            return null;
        }
        return list_hdct.get(0);
    }

    @Override
    public List<hoaDonChiTiet> selectAll() {
        return this.selectBySql(SELECT_HOADONCT);
    }

    @Override
    protected List<hoaDonChiTiet> selectBySql(String sql, Object... args) {
        List<hoaDonChiTiet> list_hdct = new ArrayList<hoaDonChiTiet>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                hoaDonChiTiet hd = new hoaDonChiTiet();
                hd.setMaHD(rs.getInt("maHD"));
                hd.setMaSP(rs.getString("maSP"));
                hd.setSoLuong(rs.getInt("soLuong"));
                hd.setDonGia(rs.getFloat("donGia"));
                list_hdct.add(hd);
            }
            rs.getStatement().getConnection().close();
            return list_hdct;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

}
