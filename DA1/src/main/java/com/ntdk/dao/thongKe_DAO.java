/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntdk.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */

public class thongKe_DAO {

    private int getSingleValue(String sql, String[] cols, Object... args) {
        try {
            int result = 0;
            ResultSet rs = JdbcHelper.query(sql, args);
            if (rs.next()) {
                result = rs.getInt(cols[0]);
            }
            rs.getStatement().getConnection().close();
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public int getSlKhachHang(Integer thang) {
        String sql = "{CALL SP_slkh(?)}";
        String[] cols = {"SoLuong"};
        return this.getSingleValue(sql, cols, thang);
    }
    
       public int getSlsanPham(Integer thang) {
        String sql = "{CALL SP_slsp(?)}";
        String[] cols = {"slBan"};
        return this.getSingleValue(sql, cols, thang);
    }
       
}
