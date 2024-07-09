/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tndk.utils;

import java.awt.Image;
import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;

/**
 *
 * @author ASUS
 */
public class XImage {
    public static Image getAppIcon() {
        URL url = XImage.class.getResource("/Bộ_Icon/fpt.png");
        return new ImageIcon(url).getImage();
    }

    public static void save(File src) {
        File dst = new File("logos", src.getName());//tạo một đối tượng File cho tệp đích trong thư mục "logos" với tên tệp giống như tên của tệp nguồn (src).
        //Kiểm tra xem thư mục cha của tệp đích (dst.getParentFile()) có tồn tại không.
        //Nếu không tồn tại, phương thức mkdirs() được gọi để tạo tất cả các thư mục cha cần thiết.
        if (!dst.getParentFile().exists()) {
            dst.getParentFile().mkdirs();
        }
        try {
            Path from = Paths.get(src.getAbsolutePath());//tạo một đối tượng Path từ đường dẫn tuyệt đối của tệp nguồn (src).
            Path to = Paths.get(dst.getAbsolutePath());// tạo một đối tượng Path từ đường dẫn tuyệt đối của tệp đích (dst).
            //sao chép nội dung từ from (tệp nguồn) đến to (tệp đích).
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);//được sử dụng để ghi đè lên tệp đích nếu nó đã tồn tại.
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
    
    //đọc tệp hình ảnh từ thư mục cụ thể và trả về 1 đối tượng ImageIcon
    public static ImageIcon read (String fileName){
        File path = new File("logos", fileName); 
        // tạo một File từ thư mục logos và tên là fileName
        return new ImageIcon(path.getAbsolutePath());//trả về đường dẫn tuyệt đối của tệp hình ảnh
        //tạo một đối tượng ImageIcon từ đường dẫn tuyệt đối của tệp hình ảnh.
    }
}
