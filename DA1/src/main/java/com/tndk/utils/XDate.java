/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tndk.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ASUS
 */
public class XDate {
    static SimpleDateFormat formater = new SimpleDateFormat(); //là một lớp trong Java thuộc gói java.text được sử dụng để định dạng và phân tích các định dạng ngày tháng trong chuỗi. 
    //chuyển chuỗi thành date theo định dạng pattern
    public static Date toDate(String date, String pattern ){
        try {
            formater.applyPattern(pattern);
            return (Date) formater.parseObject(date);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
    //chuyển date thành chuỗi theo định dạng pattern
    public static String toString (Date date, String pattern){
        formater.applyPattern(pattern);
        return formater.format(date);
    }
    
    public static Date addDays (Date date, long days){
        date.setTime(date.getTime() + days*24*60*60*1000);
        return date;
    }
//  date.getTime() trả về số lượng milliseconds từ Epoch (00:00:00 UTC, 1 tháng 1 năm 1970) đến thời điểm của đối tượng date.
//  days * 24 * 60 * 60 * 1000 tính toán số lượng milliseconds tương ứng với số ngày (days).
//  date.setTime(...) thiết lập thời gian mới cho đối tượng date bằng cách cộng thêm số lượng milliseconds đã tính toán.
//  Do đối tượng date truyền vào là tham chiếu, việc thay đổi thời gian trên đối tượng này sẽ ảnh hưởng trực tiếp đến nó.
}
