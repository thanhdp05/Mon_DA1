/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntdk.dao;

import com.ntdk.entity.loaiSP;
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
public class loaiSP_DAO extends NTDK_DAO<loaiSP , Integer>{

    String INSERT_LOAISP = "insert loaiSP (tenLoai) values (?)";
    String UPDATE_LOAISP = "update loaiSP set tenLoai = ? where maLoai = ?";
    String DELETE_LOAISP = "delete loaiSP where maLoai = ?";
    String SELECT_LOAISP_ALL = "select * from loaiSP";
    String SELECT_LOAI_WHERE = "select * from loaiSP where maLoai = ?";
    
    
    @Override
    public void insert(loaiSP entity) {
        try {
            JdbcHelper.update(INSERT_LOAISP, entity.getTenLoai());
        } catch (SQLException ex) {
            Logger.getLogger(loaiSP_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(loaiSP entity) {
        try {
            JdbcHelper.update(UPDATE_LOAISP, entity.getTenLoai(), entity.getMaLoai());
        } catch (SQLException ex) {
            Logger.getLogger(loaiSP_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            JdbcHelper.update(DELETE_LOAISP, id);
        } catch (SQLException ex) {
            Logger.getLogger(loaiSP_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public loaiSP selectById(Integer id) {
        List<loaiSP> list_lsp = this.selectBySql(SELECT_LOAI_WHERE, id);
        if(list_lsp.isEmpty()){
            return null;
        }
        return list_lsp.get(0);
    }

    @Override
    public List<loaiSP> selectAll() {
        return this.selectBySql(SELECT_LOAISP_ALL);
    }

    @Override
    protected List<loaiSP> selectBySql(String sql, Object... args) {
        List<loaiSP> list_lsp = new ArrayList<loaiSP>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {                
                loaiSP lsp = new loaiSP();
                lsp.setMaLoai(rs.getInt("maLoai"));
                lsp.setTenLoai(rs.getString("tenLoai"));
                list_lsp.add(lsp);
            }
            rs.getStatement().getConnection().close();
            return list_lsp;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
          
}
