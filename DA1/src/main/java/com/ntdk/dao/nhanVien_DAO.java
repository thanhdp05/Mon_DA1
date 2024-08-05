/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntdk.dao;

import com.ntdk.entity.nhanVien;
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
public class nhanVien_DAO extends NTDK_DAO<nhanVien , String>{

    String INSERT_NHANVIEN = "insert nhanVien (maNV, hoTen, matKhau, vaiTro, hinh, email) values (?,?,?,?,?,?)";
    String UPDATE_NHANVIEN = "update nhanVien set hoTen = ?, matKhau = ?, vaiTro = ?, hinh = ?, email = ? where maNV = ?";
    String DELETE_NHANVIEN = "delete nhanVien where maNV = ?";
    String SELECT_NHANVIEN_ALL = "select * from nhanVien";
    String SELECT_NHANVIEN_WHERE = "select * from nhanVien where maNV = ?";
     String UPDATE_MkMoi_NHANVIEN = "update nhanVien set  matKhau = ? where maNV = ?";
    
    
    
    @Override
    public void insert(nhanVien entity) {
        try {
            JdbcHelper.update(INSERT_NHANVIEN, entity.getMaNV(), entity.getHoTen(), entity.getMatKhau(), entity.isVaiTro(), entity.getHinh(), entity.getEmail());
        } catch (SQLException ex) {
            Logger.getLogger(nhanVien_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(nhanVien entity) {
        try {
            JdbcHelper.update(UPDATE_NHANVIEN, entity.getHoTen(), entity.getMatKhau(), entity.isVaiTro(), entity.getHinh(), entity.getEmail() , entity.getMaNV());
        } catch (SQLException ex) {
            Logger.getLogger(nhanVien_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String id) {
        try {
            JdbcHelper.update(DELETE_NHANVIEN, id);
        } catch (SQLException ex) {
            Logger.getLogger(nhanVien_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public nhanVien selectById(String id) {
        List<nhanVien> list_nv = this.selectBySql(SELECT_NHANVIEN_WHERE, id);
        if(list_nv.isEmpty()){
            return null;
        }
        return list_nv.get(0);
    }

    @Override
    public List<nhanVien> selectAll() {
        return this.selectBySql(SELECT_NHANVIEN_ALL);
    }

    @Override
    protected List<nhanVien> selectBySql(String sql, Object... args) {
        List<nhanVien> list_nv = new ArrayList<nhanVien>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {                
                nhanVien nv = new nhanVien();
                nv.setMaNV(rs.getString("maNV"));
                nv.setHoTen(rs.getString("hoTen"));
                nv.setMatKhau(rs.getString("matKhau"));
                nv.setVaiTro(rs.getBoolean("vaiTro"));
                nv.setHinh(rs.getString("hinh"));
                nv.setEmail(rs.getString("email"));
                list_nv.add(nv);
            }
            rs.getStatement().getConnection().close();
            return list_nv;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    
     public List<nhanVien> selectByKeyWord(String keyword) {
        String sql = "SELECT * FROM nhanVien WHERE HOTEN LIKE ?";
        return this.selectBySql(sql, "%" + keyword + "%");
    }
     
     public void updateMk(nhanVien entity){
           try {
            JdbcHelper.update(UPDATE_MkMoi_NHANVIEN,  entity.getMatKhau(),entity.getMaNV());
        } catch (SQLException ex) {
            Logger.getLogger(nhanVien_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
         
}
