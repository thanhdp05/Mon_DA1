/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntdk.dao;

import java.util.List;

/**
 *
 * @author ASUS
 */
abstract public class NTDK_DAO <EntityType,KeyType>{
    // định nghĩa 1 lớp trừu tượng 
    //lớp này sử dụng genenic để làm việc với các kiểu dữ liệu không xác định trước (là EntityType và KeyType)
    //EntityType đại diện cho kiểu của thực thể (entity)
    //KeyType đại diện cho kiểu của khóa chính (primary key)
    abstract  public void insert(EntityType entity);
    abstract  public void update(EntityType entity);
    abstract public void delete(String id);
    abstract public EntityType selectById(KeyType id);
    abstract public List<EntityType> selectAll();
    abstract protected List<EntityType> selectBySql (String sql, Object... args);
    //lấy các thực thể bằng câu sql tùy ý và các tham số truyền vào
}
