/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntdk.dao;

import com.ntdk.entity.nguoiDung;
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
public class nguoiDung_DAO extends NTDK_DAO<nguoiDung , Integer>{

    String INSERT_NGUOIDUNG = "insert nguoiDung (hoTen, sdt, email, ngayDK, vip) values (?, ?, ?, ?, ?)";
    String UPDATE_NGUOIDUNG = "update nguoiDung set hoTen = ?, sdt = ?, email = ?, ngayDK = ?, vip = ? where maND = ?";
    String DELETE_NGUOIDUNG = "delete nguoiDung where maND = ?";
    String SELECT_NGUOIDUNG_ALL = "select * from nguoiDung";
    String SELECT_NGUOIDUNG_WHERE = "select * from nguoiDung where maND = ?"; 
    
    
    @Override
    public void insert(nguoiDung entity) {
        try {
            JdbcHelper.update(INSERT_NGUOIDUNG, entity.getHoTen(), entity.getSdt(), entity.getEmail(), entity.getNgayDK(), entity.isVip());
        } catch (SQLException ex) {
            Logger.getLogger(nguoiDung_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(nguoiDung entity) {
        try {
            JdbcHelper.update(UPDATE_NGUOIDUNG, entity.getHoTen(), entity.getSdt(), entity.getEmail(), entity.getNgayDK(), entity.isVip(), entity.getMaND());
        } catch (SQLException ex) {
            Logger.getLogger(nguoiDung_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String id) {
        try {
            JdbcHelper.update(DELETE_NGUOIDUNG, id);
        } catch (SQLException ex) {
            Logger.getLogger(nguoiDung_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public nguoiDung selectById(Integer id) {
        List<nguoiDung> list_nd = this.selectBySql(SELECT_NGUOIDUNG_WHERE, id);
        if(list_nd.isEmpty()){
            return null;
        }
        return list_nd.get(0);
    }

    @Override
    public List<nguoiDung> selectAll() {
        return this.selectBySql(SELECT_NGUOIDUNG_ALL);  
    }

    @Override
    protected List<nguoiDung> selectBySql(String sql, Object... args) {
        List<nguoiDung> list_nd = new ArrayList<nguoiDung>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {                
                nguoiDung nd = new nguoiDung();
                nd.setMaND(rs.getInt("maND"));
                nd.setHoTen(rs.getString("hoTen"));
                nd.setSdt(rs.getString("sdt"));
                nd.setEmail(rs.getString("email"));
                nd.setNgayDK(rs.getDate("ngayDK"));
                nd.setVip(rs.getBoolean("vip"));
                list_nd.add(nd);
            }
            rs.getStatement().getConnection().close();
            return list_nd;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        
    }
    
}
