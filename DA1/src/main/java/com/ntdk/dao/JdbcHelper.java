/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntdk.dao;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class JdbcHelper {
    // java database connectivity
    static String driver = "com.microsoft.sqlserver.SQLServerDriver";
    static String username = "sa";
    static String password = "123456";
    static String database = "TDVCT_test";
    static String url = "jdbc:sqlserver://localhost:1433;database="+database+";encrypt=false";

    static{
        // là một khối khởi tạo tĩnh, đc sử dụng để tải lớp điều khiển SQL khi lớp chứa khối tính này dc nạp vào bộ nhớ
        try {
            Class .forName(SQLServerDriver.class.getName());// dùng phương thức forName của lớp class để tải lớp trình điều khiển SQL
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static PreparedStatement getStmt(String sql, Object... args)throws  SQLException{
        Connection conn = DriverManager.getConnection(url, username, password);
        PreparedStatement stmt;
        if(sql.trim().startsWith("{")){
            stmt = conn.prepareCall(sql); // để gọi Stored procedure
        }else{
            stmt = conn.prepareStatement(sql);// thực thi các câu lệnh với tham số đầu vào, nó giúp cải thiện hiệu suất, bảo mật và cho phép tái sử dụng câ lệnh SQL đã được biên dịch 
        }
        
        for(int i = 0; i<args.length; i++){
            stmt.setObject(i+1, args[i]);
        }
        return stmt;
    }
//    Khác biệt giữa size và length
//size là một phương thức của các lớp tập hợp (collections) trong Java để lấy số lượng phần tử, dùng chủ yếu cho ArrayList, HashSet, HashMap và các lớp tương tự.
//
//length là một thuộc tính (property) của mảng (array) và là một phương thức của chuỗi (String) để lấy độ dài của mảng hoặc chuỗi.

    public static int update(String sql , Object... args)throws SQLException{
        try {
            PreparedStatement stmt = JdbcHelper.getStmt(sql, args);
            try {
                return stmt.executeUpdate();
            } finally {
                stmt.getConnection().close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static ResultSet query (String sql , Object... args)throws SQLException{
        PreparedStatement stmt = JdbcHelper.getStmt(sql, args);
        return stmt.executeQuery();
    }
    
    public static Object value (String sql , Object... args){
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            if (rs.next()) {
                return rs.getObject(0);
            }
            rs.getStatement().getConnection().close();
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
}
