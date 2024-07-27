/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.da1;

import com.ntdk.entity.nhanVien;
import com.tndk.utils.Auth;
import com.tndk.utils.MsgBox;
import com.tndk.utils.XImage;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.Timer;

/**
 *
 * @author Asus
 */
public class frm_GiaoDienChinh extends javax.swing.JFrame {

    /**
     * Creates new form frm_GiaoDienChinh
     */
    Color cl_btn = new Color(0, 0, 0, 0);

    public frm_GiaoDienChinh() {
        initComponents();
        init();
        setBtn();
        //btn_CCgido.setBackground(mauBtn);

    }

    public void setBtn() {
        btn_QL_NV.setBackground(cl_btn);
        btn_QL_SP.setBackground(cl_btn);
        btn_QL_LSP.setBackground(cl_btn);
        btn_QL_KH.setBackground(cl_btn);
        btn_QL_DT.setBackground(cl_btn);
        btn_doiMatKhau.setBackground(cl_btn);
        btn_dangXuat.setBackground(cl_btn);

    }

    public void init() {
        setLocationRelativeTo(null);
        new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Date now = new Date();
                SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss a");
                //lbl_DongHo.setText(format.format(now));
            }
        }).start();

        if (!Auth.isLogin()) {
            new frm_ManHinhChao(this, true).setVisible(true);
            new frm_DangNhapJdialog(this, true).setVisible(true);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_QL_SP = new javax.swing.JButton();
        btn_QL_NV = new javax.swing.JButton();
        btn_QL_LSP = new javax.swing.JButton();
        btn_QL_DT = new javax.swing.JButton();
        btn_QL_KH = new javax.swing.JButton();
        btn_dangXuat = new javax.swing.JButton();
        btn_doiMatKhau = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setForeground(new java.awt.Color(0, 102, 102));

        btn_QL_SP.setBackground(new java.awt.Color(204, 204, 255));
        btn_QL_SP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_QL_SP.setForeground(new java.awt.Color(255, 255, 255));
        btn_QL_SP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconNhe/sanPham.png"))); // NOI18N
        btn_QL_SP.setText("Quản lý sản phẩm");
        btn_QL_SP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_QL_SPActionPerformed(evt);
            }
        });

        btn_QL_NV.setBackground(new java.awt.Color(204, 204, 255));
        btn_QL_NV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_QL_NV.setForeground(new java.awt.Color(255, 255, 255));
        btn_QL_NV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconNhe/nhanVien.png"))); // NOI18N
        btn_QL_NV.setText("Quản lý nhân viên");
        btn_QL_NV.setBorder(null);
        btn_QL_NV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_QL_NVActionPerformed(evt);
            }
        });

        btn_QL_LSP.setBackground(new java.awt.Color(204, 204, 255));
        btn_QL_LSP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_QL_LSP.setForeground(new java.awt.Color(255, 255, 255));
        btn_QL_LSP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconNhe/listClothes.png"))); // NOI18N
        btn_QL_LSP.setText("Thanh toán");
        btn_QL_LSP.setBorder(null);
        btn_QL_LSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_QL_LSPActionPerformed(evt);
            }
        });

        btn_QL_DT.setBackground(new java.awt.Color(204, 204, 255));
        btn_QL_DT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_QL_DT.setForeground(new java.awt.Color(255, 255, 255));
        btn_QL_DT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconNhe/thongke.png"))); // NOI18N
        btn_QL_DT.setText("Doanh thu");
        btn_QL_DT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_QL_DTActionPerformed(evt);
            }
        });

        btn_QL_KH.setBackground(new java.awt.Color(204, 204, 255));
        btn_QL_KH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_QL_KH.setForeground(new java.awt.Color(255, 255, 255));
        btn_QL_KH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Background/bill.png"))); // NOI18N
        btn_QL_KH.setText("Quản lý Khách hàng");
        btn_QL_KH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_QL_KHActionPerformed(evt);
            }
        });

        btn_dangXuat.setBackground(new java.awt.Color(204, 204, 255));
        btn_dangXuat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_dangXuat.setForeground(new java.awt.Color(255, 255, 255));
        btn_dangXuat.setText("Đăng xuất");
        btn_dangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dangXuatActionPerformed(evt);
            }
        });

        btn_doiMatKhau.setBackground(new java.awt.Color(204, 204, 255));
        btn_doiMatKhau.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_doiMatKhau.setForeground(new java.awt.Color(255, 255, 255));
        btn_doiMatKhau.setText("Đổi mật khẩu");
        btn_doiMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_doiMatKhauActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/anh/snapedit_con4.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_QL_NV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_QL_SP, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
            .addComponent(btn_QL_DT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_dangXuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_doiMatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_QL_LSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_QL_KH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_QL_NV, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_QL_SP, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_QL_LSP, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_QL_KH, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_QL_DT, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_doiMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_dangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/anh/snapedit_con3.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_QL_NVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_QL_NVActionPerformed
        this.OpenNhanVien();
    }//GEN-LAST:event_btn_QL_NVActionPerformed

    private void btn_QL_LSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_QL_LSPActionPerformed
        this.OpenThanhToan();
    }//GEN-LAST:event_btn_QL_LSPActionPerformed

    private void btn_QL_SPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_QL_SPActionPerformed
        this.OpenSanPham();
    }//GEN-LAST:event_btn_QL_SPActionPerformed

    private void btn_QL_KHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_QL_KHActionPerformed
        this.OpenKhachHang();
    }//GEN-LAST:event_btn_QL_KHActionPerformed

    private void btn_doiMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_doiMatKhauActionPerformed

    }//GEN-LAST:event_btn_doiMatKhauActionPerformed

    private void btn_dangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dangXuatActionPerformed
        this.DangXuat();
    }//GEN-LAST:event_btn_dangXuatActionPerformed

    private void btn_QL_DTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_QL_DTActionPerformed
        
    }//GEN-LAST:event_btn_QL_DTActionPerformed

    public void DangXuat() {
        Auth.clear();
        new frm_DangNhapJdialog(this, true).setVisible(true);
    }

    public void KetThuc() {
        if (MsgBox.confirm(this, "Bạn muốn kết thúc làm việc")) {
            System.exit(0);
        }
    }

    public void OpenNhanVien() {
        if (Auth.isLogin()) {
            this.dispose();
            new frm_QL_NhanVIen().setVisible(true);
        } else {
            MsgBox.alert(this, "Vui lòng đăng nhập");
        }
    }

    public void OpenThanhToan() {
        if (Auth.isLogin()) {
            this.dispose();
            new frm_QL_ThanhToan().setVisible(true);
        } else {
            MsgBox.alert(this, "Vui lòng đăng nhập");
        }
    }

    public void OpenKhachHang() {
        if (Auth.isLogin()) {
            this.dispose();
            new frm_QL_KhachHang().setVisible(true);
        } else {
            MsgBox.alert(this, "Vui lòng đăng nhập");
        }
    }

    public void OpenSanPham() {
        if (Auth.isLogin()) {
            this.dispose();
            new frm_QL_SanPham().setVisible(true);
        } else {
            MsgBox.alert(this, "Vui lòng đăng nhập");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frm_GiaoDienChinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_GiaoDienChinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_GiaoDienChinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_GiaoDienChinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_GiaoDienChinh().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_QL_DT;
    private javax.swing.JButton btn_QL_KH;
    private javax.swing.JButton btn_QL_LSP;
    private javax.swing.JButton btn_QL_NV;
    private javax.swing.JButton btn_QL_SP;
    private javax.swing.JButton btn_dangXuat;
    private javax.swing.JButton btn_doiMatKhau;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
