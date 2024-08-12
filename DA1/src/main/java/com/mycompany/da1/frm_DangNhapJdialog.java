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
import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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

        txtEmail.setBackground(anNen);
        txtMaXacNhan.setBackground(anNen);

        txtManv.setBackground(anNen);
        txtMk.setBackground(anNen);

        pnDangNhap.setOpaque(false);
        pnMkMoi.setOpaque(false);
        pnQuenMk.setOpaque(false);
    }

    public void OpenQuenMK() {
        new frm_quenMK().setVisible(true);
    }

    int width = 390;
    int heigh = 370;

    public void OpenMenuQuenMk() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < width; i++) {
                    pnQuenMk.setSize(i, heigh);
                    try {
                        Thread.sleep(2);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(frm_DangNhapJdialog.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
        }).start();
    }

    public void closeMenuQuenMk() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = width; i > 0; i--) {
                    pnQuenMk.setSize(i, heigh);
                    try {
                        Thread.sleep(2);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(frm_DangNhapJdialog.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
        }).start();
    }

    public void OpenMenuMkMoi() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < width; i++) {
                    pnMkMoi.setSize(i, heigh);
                    try {
                        Thread.sleep(2);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(frm_DangNhapJdialog.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
        }).start();
    }

    public void closeMenuMkMoi() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = width; i > 0; i--) {
                    pnMkMoi.setSize(i, heigh);
                    try {
                        Thread.sleep(2);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(frm_DangNhapJdialog.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
        }).start();
    }

    public void OpenMenuQDn() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < width; i++) {
                    pnDangNhap.setSize(i, heigh);
                    try {
                        Thread.sleep(2);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(frm_DangNhapJdialog.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
        }).start();
    }

    public void closeMenuDn() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = width; i > 0; i--) {
                    pnDangNhap.setSize(i, heigh);
                    try {
                        Thread.sleep(2);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(frm_DangNhapJdialog.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
        }).start();
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
        pnQuenMk = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtMaXacNhan = new javax.swing.JTextField();
        btnxacNhan = new javax.swing.JButton();
        btnGuima = new javax.swing.JButton();
        pnDangNhap = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtMaNv = new javax.swing.JTextField();
        lbl_IconUser = new javax.swing.JLabel();
        lbl_IconKey = new javax.swing.JLabel();
        txtMatKhau = new javax.swing.JPasswordField();
        cboShow = new javax.swing.JCheckBox();
        lblQuenMk = new javax.swing.JLabel();
        btnDangNhap = new javax.swing.JButton();
        pnMkMoi = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtManv = new javax.swing.JTextField();
        txtMk = new javax.swing.JPasswordField();
        btnXacNhan = new javax.swing.JButton();
        lblClose = new javax.swing.JLabel();
        lbl_Hinh = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 2, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Q U Ê N  M Ậ T  K H Ẩ U");

        txtEmail.setText("Email");
        txtEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        txtEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEmailFocusLost(evt);
            }
        });

        txtMaXacNhan.setText("Mã");
        txtMaXacNhan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        txtMaXacNhan.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMaXacNhanFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMaXacNhanFocusLost(evt);
            }
        });

        btnxacNhan.setForeground(new java.awt.Color(0, 0, 0));
        btnxacNhan.setText("XÁC NHẬN");
        btnxacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxacNhanActionPerformed(evt);
            }
        });

        btnGuima.setForeground(new java.awt.Color(0, 0, 0));
        btnGuima.setText("GỬI MÃ");
        btnGuima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuimaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnQuenMkLayout = new javax.swing.GroupLayout(pnQuenMk);
        pnQuenMk.setLayout(pnQuenMkLayout);
        pnQuenMkLayout.setHorizontalGroup(
            pnQuenMkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnQuenMkLayout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(btnGuima)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(btnxacNhan)
                .addGap(17, 17, 17))
            .addGroup(pnQuenMkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnQuenMkLayout.createSequentialGroup()
                    .addGap(71, 71, 71)
                    .addGroup(pnQuenMkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnQuenMkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtEmail)
                            .addComponent(txtMaXacNhan, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE))
                        .addGroup(pnQuenMkLayout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(jLabel1)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        pnQuenMkLayout.setVerticalGroup(
            pnQuenMkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnQuenMkLayout.createSequentialGroup()
                .addContainerGap(268, Short.MAX_VALUE)
                .addGroup(pnQuenMkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuima, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnxacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71))
            .addGroup(pnQuenMkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnQuenMkLayout.createSequentialGroup()
                    .addGap(69, 69, 69)
                    .addComponent(jLabel1)
                    .addGap(26, 26, 26)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(txtMaXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(142, Short.MAX_VALUE)))
        );

        jPanel1.add(pnQuenMk, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, 0, 370));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Đ Ă N G   N H Ậ P");

        txtMaNv.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMaNv.setForeground(new java.awt.Color(255, 255, 255));
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

        lbl_IconUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_IconUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconNhe/icons8_user_20px_1.png"))); // NOI18N
        lbl_IconUser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        lbl_IconKey.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_IconKey.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconNhe/matKhau.png"))); // NOI18N
        lbl_IconKey.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        txtMatKhau.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMatKhau.setForeground(new java.awt.Color(255, 255, 255));
        txtMatKhau.setText("111111");
        txtMatKhau.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        txtMatKhau.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMatKhauFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMatKhauFocusLost(evt);
            }
        });

        cboShow.setForeground(new java.awt.Color(255, 255, 255));
        cboShow.setText("Hiển thị");
        cboShow.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cboShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboShowActionPerformed(evt);
            }
        });

        lblQuenMk.setForeground(new java.awt.Color(255, 255, 255));
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

        btnDangNhap.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnDangNhap.setForeground(new java.awt.Color(0, 0, 0));
        btnDangNhap.setText("Đăng  Nhập");
        btnDangNhap.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangNhapActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnDangNhapLayout = new javax.swing.GroupLayout(pnDangNhap);
        pnDangNhap.setLayout(pnDangNhapLayout);
        pnDangNhapLayout.setHorizontalGroup(
            pnDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDangNhapLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(pnDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnDangNhapLayout.createSequentialGroup()
                        .addComponent(txtMaNv, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(lbl_IconUser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnDangNhapLayout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(lblQuenMk))
                    .addComponent(btnDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(cboShow)
                        .addGroup(pnDangNhapLayout.createSequentialGroup()
                            .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(lbl_IconKey, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        pnDangNhapLayout.setVerticalGroup(
            pnDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDangNhapLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addGroup(pnDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaNv, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_IconUser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(pnDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_IconKey, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cboShow)
                .addGap(8, 8, 8)
                .addComponent(lblQuenMk)
                .addGap(13, 13, 13)
                .addComponent(btnDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel1.add(pnDangNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, 360, 370));

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 2, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("M Ậ T  K H Ẩ U  M Ớ I");

        txtManv.setForeground(new java.awt.Color(255, 255, 255));
        txtManv.setText("Mã Nhân Viên");
        txtManv.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        txtManv.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtManvFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtManvFocusLost(evt);
            }
        });
        txtManv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtManvActionPerformed(evt);
            }
        });

        txtMk.setForeground(new java.awt.Color(255, 255, 255));
        txtMk.setText("matKhau");
        txtMk.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        txtMk.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMkFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMkFocusLost(evt);
            }
        });

        btnXacNhan.setForeground(new java.awt.Color(0, 0, 0));
        btnXacNhan.setText("XÁC NHẬN");
        btnXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnMkMoiLayout = new javax.swing.GroupLayout(pnMkMoi);
        pnMkMoi.setLayout(pnMkMoiLayout);
        pnMkMoiLayout.setHorizontalGroup(
            pnMkMoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 311, Short.MAX_VALUE)
            .addGroup(pnMkMoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnMkMoiLayout.createSequentialGroup()
                    .addGap(45, 45, 45)
                    .addGroup(pnMkMoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtManv, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtMk, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnXacNhan, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMkMoiLayout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(23, 23, 23)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        pnMkMoiLayout.setVerticalGroup(
            pnMkMoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
            .addGroup(pnMkMoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnMkMoiLayout.createSequentialGroup()
                    .addGap(68, 68, 68)
                    .addComponent(jLabel2)
                    .addGap(39, 39, 39)
                    .addComponent(txtManv, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(32, 32, 32)
                    .addComponent(txtMk, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(btnXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(69, Short.MAX_VALUE)))
        );

        jPanel1.add(pnMkMoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, 0, -1));

        lblClose.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lblClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblClose.setText("x");
        lblClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCloseMouseClicked(evt);
            }
        });
        jPanel1.add(lblClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, -10, 40, 50));
        jPanel1.add(lbl_Hinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 560));

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
        closeMenuDn();
        OpenMenuQuenMk();

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
        if (txtMatKhau.getText().equals("111111")) {
            txtMatKhau.setText("");
            txtMatKhau.setForeground(new Color(255, 255, 255));
        }
    }//GEN-LAST:event_txtMatKhauFocusGained

    private void txtMatKhauFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMatKhauFocusLost
        if (txtMatKhau.getText().equals("")) {
            txtMatKhau.setText("111111");
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

    private void btnxacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxacNhanActionPerformed
        kiemtra();


    }//GEN-LAST:event_btnxacNhanActionPerformed

    private void btnGuimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuimaActionPerformed
        password = generateRandomPassword(6);
        Subiject();
    }//GEN-LAST:event_btnGuimaActionPerformed

    private void btnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanActionPerformed
        doiMatKhau();
//        this.dispose();
//        OpenDoiDangNhap();


    }//GEN-LAST:event_btnXacNhanActionPerformed

    private void txtManvFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtManvFocusGained
        if (txtManv.getText().equals("Mã Nhân Viên")) {
            txtManv.setText("");
            txtManv.setForeground(new Color(255, 255, 255));
        }
    }//GEN-LAST:event_txtManvFocusGained

    private void txtManvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtManvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtManvActionPerformed

    private void txtManvFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtManvFocusLost
        if (txtManv.getText().equals("")) {
            txtManv.setText("Mã Nhân Viên");
            txtManv.setForeground(new Color(255, 255, 255));
        }
    }//GEN-LAST:event_txtManvFocusLost

    private void txtMkFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMkFocusGained
        if (txtMk.getText().equals("matKhau")) {
            txtMk.setText("");
            txtMk.setForeground(new Color(255, 255, 255));
        }
    }//GEN-LAST:event_txtMkFocusGained

    private void txtMkFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMkFocusLost
        if (txtMk.getText().equals("")) {
            txtMk.setText("matKhau");
            txtMk.setForeground(new Color(255, 255, 255));
        }
    }//GEN-LAST:event_txtMkFocusLost

    private void txtEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusGained
        if (txtEmail.getText().equals("Email")) {
            txtEmail.setText("");
            txtEmail.setForeground(new Color(255, 255, 255));
        }
    }//GEN-LAST:event_txtEmailFocusGained

    private void txtEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusLost
        if (txtEmail.getText().equals("")) {
            txtEmail.setText("Email");
            txtEmail.setForeground(new Color(255, 255, 255));
        }
    }//GEN-LAST:event_txtEmailFocusLost

    private void txtMaXacNhanFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMaXacNhanFocusGained
        if (txtMaXacNhan.getText().equals("Mã")) {
            txtMaXacNhan.setText("");
            txtMaXacNhan.setForeground(new Color(255, 255, 255));
        }
    }//GEN-LAST:event_txtMaXacNhanFocusGained

    private void txtMaXacNhanFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMaXacNhanFocusLost
        if (txtMaXacNhan.getText().equals("")) {
            txtMaXacNhan.setText("Mã");
            txtMaXacNhan.setForeground(new Color(255, 255, 255));
        }
    }//GEN-LAST:event_txtMaXacNhanFocusLost

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

    String password = null;

    public void Subiject() {
        //Đoạn dưới đâu là cấu hình SMTP server

        Properties pro = new Properties(); //Tạo một đối tượng Properties để lưu trữ các cặp giá trị key-value,
        //dùng để cấu hình các thuộc tính liên quan đến việc kết nối với SMTP server.
        pro.put("mail.smtp.auth", true); // Xác định rằng cần phải xác thực khi kết nối với SMTP server.
        pro.put("mail.smtp.starttls.enable", "true"); //Kích hoạt TLS (Transport Layer Security) để bảo mật kết nối.
        pro.put("mail.smtp.host", "smtp.gmail.com"); // Địa chỉ của SMTP server, ở đây là smtp.gmail.com.
        pro.put("mail.smtp.port", "587"); //Cổng để kết nối với SMTP server, Gmail dùng cổng 587.
        pro.put("mail.smtp.socketFactory.port", "587");
        pro.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        pro.put("mail.smtp.ssl.protocols", "TLSv1.2");
        String Email = "nngguuyyeenn007@gmail.com";
        String Pass = "teuhxzguxcppnobh";
        Session session = Session.getInstance(pro,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(Email, Pass);
            }
        }
        );
        try {
            Message myMessage = new MimeMessage(session);
            myMessage.setFrom(new InternetAddress(Email)); //Thiết lập địa chỉ email người gửi.
            myMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(txtEmail.getText()));
            myMessage.setSubject("Mã Xác Nhận"); // thiết lập tiêu đề email
            myMessage.setContent(password, "text/html;charset=utf-8");
            Transport.send(myMessage);
            MsgBox.alert(this, "Mã xác nhận đã được gửi thành công");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String generateRandomPassword(int length) {
        String characters = "0123456789";

        String randomString = "";
        Random random = new Random();

        for (int i = 0; i < 6; i++) {
            int index = random.nextInt(characters.length());
            randomString += characters.charAt(index);
        }
        return randomString;
    }

    void kiemtra() {
        if (txtMaXacNhan.getText().equalsIgnoreCase(password)) {
            MsgBox.alert(this, "Mã đúng");
            closeMenuQuenMk();
            OpenMenuMkMoi();
        } else {
            MsgBox.alert(this, "Mã sai");
        }
    }

    nhanVien getForm() {
        nhanVien nv = new nhanVien();
        nv.setMaNV(txtManv.getText());
        nv.setMatKhau(new String(txtMk.getPassword()));

        return nv;
    }

    public void doiMatKhau() {
        nhanVien nv = getForm();
        try {
            dao.updateMk(nv);
            MsgBox.alert(this, "Cập nhật mật khẩu thành công");
            closeMenuMkMoi();
            OpenMenuQDn();
        } catch (Exception e) {
            e.printStackTrace();
            MsgBox.alert(this, "Cập nhật không thành công");
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
    private javax.swing.JButton btnGuima;
    private javax.swing.JButton btnXacNhan;
    private javax.swing.JButton btnxacNhan;
    private javax.swing.JCheckBox cboShow;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lblQuenMk;
    private javax.swing.JLabel lbl_Hinh;
    private javax.swing.JLabel lbl_IconKey;
    private javax.swing.JLabel lbl_IconUser;
    private javax.swing.JPanel pnDangNhap;
    private javax.swing.JPanel pnMkMoi;
    private javax.swing.JPanel pnQuenMk;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMaNv;
    private javax.swing.JTextField txtMaXacNhan;
    private javax.swing.JTextField txtManv;
    private javax.swing.JPasswordField txtMatKhau;
    private javax.swing.JPasswordField txtMk;
    // End of variables declaration//GEN-END:variables
}
