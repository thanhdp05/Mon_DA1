/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntdk.dao;

import com.ntdk.entity.KhachHang;
import com.ntdk.entity.hoaDon;
import com.ntdk.entity.loaiSP;
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
public class hoaDon_DAO extends NTDK_DAO<hoaDon, Integer> {

    String INSERT_HOADON = "insert hoaDon (maKH, tongTien, ngayTao, maNV) values (?, ?, ?, ?)";
    String SELECT_HOADON = "select A.maHD, B.soLuong, B.maSP, B.donGia, A.tongTien, A.maKH, A.ngayTao, A.maNV from hoaDon A, hoaDonChiTiet B where A.maHD = B.maHD";
    String SELECT_ALL_HOADON = "select * from hoaDon";
    String SELECT_HOADON_WHERE = "select * from hoaDon where maHD = ?";

    public List<hoaDon> selectMax(){
        String sql = "select maHD, maKH, tongTien, ngayTao, maNV from hoaDon where maHD = (select MAX(maHD) from hoaDon) group by maHD, maKH, tongTien, ngayTao, maNV";
        return this.selectBySql(sql);
    }
    
    @Override
    public void insert(hoaDon entity) {
        try {
            JdbcHelper.update(INSERT_HOADON, entity.getMaKH(), entity.getTongTien(), entity.getNgayTao(), entity.getMaNV());
        } catch (SQLException ex) {
            Logger.getLogger(loaiSP_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(hoaDon entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public hoaDon selectById(Integer id) {
        List<hoaDon> list_hd = this.selectBySql(SELECT_HOADON_WHERE, id);
        if (list_hd.isEmpty()) {
            return null;
        }
        return list_hd.get(0);
    }

    @Override
    public List<hoaDon> selectAll() {
        return this.selectBySql(SELECT_ALL_HOADON);
    }

    @Override
    protected List<hoaDon> selectBySql(String sql, Object... args) {
        List<hoaDon> list_hd = new ArrayList<hoaDon>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                hoaDon hd = new hoaDon();
                hd.setMaHD(rs.getInt("maHD"));
                hd.setMaKH(rs.getInt("maKH"));
                hd.setTongTien(rs.getFloat("tongTien"));
                hd.setNgayTao(rs.getDate("ngayTao"));
                hd.setMaNV(rs.getString("maNV"));
                list_hd.add(hd);
            }
            rs.getStatement().getConnection().close();
            return list_hd;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

}
