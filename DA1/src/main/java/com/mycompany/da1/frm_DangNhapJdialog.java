/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.mycompany.da1;

import com.ntdk.dao.nhanVien_DAO;
import com.ntdk.entity.nhanVien;
import com.tndk.utils.Auth;
import com.tndk.utils.MsgBox;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Asus
 */
public class frm_DangNhapJdialog extends javax.swing.JDialog {

    /**
     * Creates new form frm_DangNhapJdialog
     */
    Color anNen = new Color(0, 0, 0, 0);
    nhanVien_DAO dao = new nhanVien_DAO();

    public frm_DangNhapJdialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setbackground();
        txtMaNv.setBackground(anNen);
        txtMatKhau.setBackground(anNen);
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
        cboShow = new javax.swing.JCheckBox();
        lblQuenMk = new javax.swing.JLabel();
        btnDangNhap = new javax.swing.JButton();
        lbl_IconKey = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbl_IconUser = new javax.swing.JLabel();
        txtMatKhau = new javax.swing.JPasswordField();
        txtMaNv = new javax.swing.JTextField();
        lblClose = new javax.swing.JLabel();
        lbl_Hinh = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cboShow.setText("Show");
        cboShow.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cboShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboShowActionPerformed(evt);
            }
        });
        jPanel1.add(cboShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 340, -1, -1));

        lblQuenMk.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblQuenMk.setText("Quên mật khẩu?");
        lblQuenMk.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblQuenMk.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                lblQuenMkAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        lblQuenMk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblQuenMkMouseClicked(evt);
            }
        });
        jPanel1.add(lblQuenMk, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 370, -1, -1));

        btnDangNhap.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnDangNhap.setText("Đăng  Nhập");
        btnDangNhap.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangNhapActionPerformed(evt);
            }
        });
        jPanel1.add(btnDangNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 399, 280, 40));

        lbl_IconKey.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_IconKey.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconNhe/matKhau.png"))); // NOI18N
        lbl_IconKey.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.add(lbl_IconKey, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 290, 40, 40));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Đ Ă N G   N H Ậ P");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, 200, 40));

        lbl_IconUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_IconUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconNhe/icons8_user_20px_1.png"))); // NOI18N
        lbl_IconUser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.add(lbl_IconUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 190, 40, 40));

        txtMatKhau.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMatKhau.setText("Showlamcaichogi");
        txtMatKhau.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        txtMatKhau.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMatKhauFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMatKhauFocusLost(evt);
            }
        });
        jPanel1.add(txtMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 290, 230, 40));

        txtMaNv.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMaNv.setText("TenDangNhap");
        txtMaNv.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        txtMaNv.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMaNvFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMaNvFocusLost(evt);
            }
        });
        txtMaNv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaNvActionPerformed(evt);
            }
        });
        jPanel1.add(txtMaNv, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 190, 230, 40));

        lblClose.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lblClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblClose.setText("x");
        lblClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCloseMouseClicked(evt);
            }
        });
        jPanel1.add(lblClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, -10, 40, 50));
        jPanel1.add(lbl_Hinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 570));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cboShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboShowActionPerformed
        if (cboShow.isSelected()) {
            txtMatKhau.setEchoChar((char) 0);
        } else {
            txtMatKhau.setEchoChar('*');
        }
    }//GEN-LAST:event_cboShowActionPerformed

    private void lblQuenMkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuenMkMouseClicked

    }//GEN-LAST:event_lblQuenMkMouseClicked

    private void btnDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangNhapActionPerformed
        DangNhap();
    }//GEN-LAST:event_btnDangNhapActionPerformed

    private void txtMaNvFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMaNvFocusGained
        if (txtMaNv.getText().equals("TenDangNhap")) {
            txtMaNv.setText("");
            txtMaNv.setForeground(new Color(255, 255, 255));
        }
    }//GEN-LAST:event_txtMaNvFocusGained

    private void txtMaNvFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMaNvFocusLost
        if (txtMaNv.getText().equals("")) {
            txtMaNv.setText("TenDangNhap");
            txtMaNv.setForeground(new Color(255, 255, 255));
        }
    }//GEN-LAST:event_txtMaNvFocusLost

    private void txtMatKhauFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMatKhauFocusGained
        if (txtMatKhau.getText().equals("Showlamcaichogi")) {
            txtMatKhau.setText("");
            txtMatKhau.setForeground(new Color(255, 255, 255));
        }
    }//GEN-LAST:event_txtMatKhauFocusGained

    private void txtMatKhauFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMatKhauFocusLost
        if (txtMatKhau.getText().equals("")) {
            txtMatKhau.setText("Showlamcaichogi");
            txtMatKhau.setForeground(new Color(255, 255, 255));
        }
    }//GEN-LAST:event_txtMatKhauFocusLost

    private void lblCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseClicked
        Kethuc();
    }//GEN-LAST:event_lblCloseMouseClicked

    private void txtMaNvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaNvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaNvActionPerformed

    private void lblQuenMkAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_lblQuenMkAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_lblQuenMkAncestorAdded

    public void setbackground() {
        ImageIcon icon2 = new ImageIcon(getClass().getResource("/background/login-bg.png"));
        Image img = icon2.getImage().getScaledInstance(lbl_Hinh.getWidth(), lbl_Hinh.getHeight(), Image.SCALE_SMOOTH);
        lbl_Hinh.setIcon(new ImageIcon(img));
    }

    public void DangNhap() {
        String maNv = txtMaNv.getText();
        String matKhau = new String(txtMatKhau.getPassword());
        nhanVien nhanVien = dao.selectById(maNv);
        if (nhanVien == null) {
            MsgBox.alert(this, "Sai tên đăng nhập");
        } else if (!matKhau.equals(nhanVien.getMatKhau())) {
            MsgBox.alert(this, "Nhập sai mật khẩu");
        } else {
            Auth.user = nhanVien;
            this.dispose();
        }
    }

    public void Kethuc() {
        if (MsgBox.confirm(this, "Bạn có muốn thoát ứng dụng")) {
            System.exit(0);
        }
    }

    //  lblHinh.setIcon(new ImageIcon(img));
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
            java.util.logging.Logger.getLogger(frm_DangNhapJdialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_DangNhapJdialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_DangNhapJdialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_DangNhapJdialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frm_DangNhapJdialog dialog = new frm_DangNhapJdialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangNhap;
    private javax.swing.JCheckBox cboShow;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lblQuenMk;
    private javax.swing.JLabel lbl_Hinh;
    private javax.swing.JLabel lbl_IconKey;
    private javax.swing.JLabel lbl_IconUser;
    private javax.swing.JTextField txtMaNv;
    private javax.swing.JPasswordField txtMatKhau;
    // End of variables declaration//GEN-END:variables
}
