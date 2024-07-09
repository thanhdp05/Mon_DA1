/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tndk.utils;

import com.ntdk.entity.nhanVien;

/**
 *
 * @author ASUS
 */
public class Auth {
    public static nhanVien user = null;
    public static void clear(){
        Auth.user = null;
    }
    
    public static boolean isLogin(){
        return Auth.user != null;
    }
    
    public static boolean isManager(){
        return Auth.isLogin()&&user.isVaiTro();
    }
}
