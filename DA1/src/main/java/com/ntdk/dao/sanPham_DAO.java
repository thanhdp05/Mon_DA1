/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntdk.dao;

import com.ntdk.entity.sanPham;
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
public class sanPham_DAO extends NTDK_DAO<sanPham, String> {

    String INSERT_SP = "insert into sanPham (maSP, tenSP, loaiSP, hangSP, soLuong, giaTien, size, hinh, ngayTao, ghiChu, maNV) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    String UPDATE_SP = "update sanPham set tenSP = ?, loaiSP = ?, hangSP = ?, soLuong = ?, giaTien = ?, size = ?, hinh = ?, ngayTao = ?, ghiChu = ?, maNV = ? where maSP = ?";
    String DELETE_SP = "delete sanPham where maSP = ?";
    String SELECT_SP_WHERE = "select * from sanPham where maSP = ?";
    String SELECT_ALL_SP = "select * from sanPham";

    String UPDATE_SOLUONG = "update sanPham set soLuong -= ? where maSP = ?";

    public void updateSoLuong(int sl, String ma) throws SQLException {
        JdbcHelper.update(UPDATE_SOLUONG, sl, ma);
    }

//    public void updateSoLuong(sanPham e) throws SQLException {
//        JdbcHelper.update(UPDATE_SOLUONG, e.getSoLuong(), e.getMaSP());
//    }
//    public List<sanPham> updateSoLuong(int soLuonngString, String ma){
//        String sql = "update sanPham set soLuong = soLuong - ? where maSP = ?";
//        return this.selectBySql(sql, soLuonngString, ma);
//    }
    public List<sanPham> selectByKeyWord(String keyWord) {
        String sql = "select * from sanPham where tenSP like ?";
        return this.selectBySql(sql, "%" + keyWord + "%");
    }

    @Override
    public void insert(sanPham e) {
        try {
            JdbcHelper.update(INSERT_SP, e.getMaSP(), e.getTenSP(), e.getLoaiSP(), e.getHangSP(), e.getSoLuong(), e.getGiaTien(), e.getSize(), e.getHinh(), e.getNgayTao(), e.getGhiChu(), e.getMaNV());
        } catch (SQLException ex) {
            Logger.getLogger(sanPham_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(sanPham e) {
        try {
            JdbcHelper.update(UPDATE_SP, e.getTenSP(), e.getLoaiSP(), e.getHangSP(), e.getSoLuong(), e.getGiaTien(), e.getSize(), e.getHinh(), e.getNgayTao(), e.getGhiChu(), e.getMaNV(), e.getMaSP());
        } catch (SQLException ex) {
            Logger.getLogger(sanPham_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String id) {
        try {
            JdbcHelper.update(DELETE_SP, id);
        } catch (SQLException ex) {
            Logger.getLogger(sanPham_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public sanPham selectById(String id) {
        List<sanPham> list_ao = this.selectBySql(SELECT_SP_WHERE, id);
        if (list_ao.isEmpty()) {
            return null;
        }
        return list_ao.get(0);
    }

    @Override
    public List<sanPham> selectAll() {
        return this.selectBySql(SELECT_ALL_SP);
    }

    @Override
    protected List<sanPham> selectBySql(String sql, Object... args) {
        List<sanPham> list_ao = new ArrayList<sanPham>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                sanPham sp = new sanPham();
                sp.setMaSP(rs.getString("maSP"));
                sp.setTenSP(rs.getString("tenSP"));
                sp.setLoaiSP(rs.getInt("loaiSP"));
                sp.setHangSP(rs.getString("hangSP"));
                sp.setSoLuong(rs.getInt("soLuong"));
                sp.setGiaTien(rs.getFloat("giaTien"));
                sp.setSize(rs.getString("size"));
                sp.setHinh(rs.getString("hinh"));
                sp.setNgayTao(rs.getDate("ngayTao"));
                sp.setGhiChu(rs.getString("ghiChu"));
                sp.setMaNV(rs.getString("maNV"));
                list_ao.add(sp);
            }
            rs.getStatement().getConnection().close();
            return list_ao;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<sanPham> selectByLoaiSP(String loaiSP) {
        String sql = "SELECT *\n"
                + "FROM sanPham sp\n"
                + "JOIN loaiSP lsp ON sp.loaiSP = lsp.maLoai\n"
                + "WHERE lsp.tenLoai like ?";
        return this.selectBySql(sql, loaiSP);
    }

}
