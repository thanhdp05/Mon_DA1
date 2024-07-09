/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.mycompany.da1;

import com.ntdk.dao.nhanVien_DAO;
import com.ntdk.entity.nhanVien;
import com.tndk.utils.MsgBox;
import com.tndk.utils.XImage;
import java.io.File;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dangt
 */
public class frm_QLNhanVien extends javax.swing.JDialog {

    /**
     * Creates new form frm_QLNhanVien
     */
    nhanVien_DAO dao = new nhanVien_DAO();
    int row = -1;
    
    public frm_QLNhanVien(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        innit();
    }
    
    private void innit() {
        this.fillTable();
        this.updateStatus();
    }
    
    public void fillTable() {
        DefaultTableModel model = (DefaultTableModel) tbl_data_QLNhanVien.getModel();
        model.setRowCount(0);
        try {
            String keyword = txt_timKiem.getText();
            List<nhanVien> list = dao.selectByKeyWord(keyword);
            for (nhanVien nv : list) {
                Object[] row = {nv.getMaNV(), nv.getHoTen(), nv.getEmail(), nv.getMatKhau(), nv.isVaiTro() ? "Trưởng phòng" : "Nhân viên", nv.getHinh()
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            MsgBox.alert(this, "lỗi truy vấn dữ liệu");
        }
    }
    
    public void setForm(nhanVien cd) {
        txt_maNhanVien.setText(cd.getMaNV());
        txt_hoVaTen.setText(cd.getHoTen());
        txt_email.setText(cd.getEmail());
        txt_matKhau.setText(cd.getMatKhau());
        txt_xacNhanMk.setText(cd.getMatKhau());
        rdo_truongPhong.setSelected(cd.isVaiTro());
        rdo_nhanVien.setSelected(!cd.isVaiTro());
        if (cd.getHinh() != null) {
            lbl_hinhAnh.setToolTipText(cd.getHinh());
            lbl_hinhAnh.setIcon(XImage.read(cd.getHinh()));
        }
    }
    
    nhanVien getForm() {
        nhanVien nv = new nhanVien();
        nv.setMaNV(txt_maNhanVien.getText());
        nv.setHoTen(txt_hoVaTen.getText());
        nv.setEmail(txt_email.getText());
        nv.setMatKhau(new String(txt_matKhau.getPassword()));
        nv.setVaiTro(rdo_truongPhong.isSelected());
        nv.setHinh(lbl_hinhAnh.getToolTipText());
        
        return nv;
    }
    
    public void clearForm() {
        nhanVien cd = new nhanVien();
        this.setForm(cd);
        this.row = -1;
        this.updateStatus();
    }
    
    public void insert() {
        nhanVien cd = getForm();
        try {
            dao.insert(cd);
            this.fillTable();
            this.clearForm();
            MsgBox.alert(this, "Thêm thành công");
        } catch (Exception e) {
            MsgBox.alert(this, "Thêm không thành công");
        }
    }
    
    public void update() {
        nhanVien nv = getForm();
        try {
            dao.update(nv);
            this.fillTable();
            MsgBox.alert(this, "Cập nhật thành công");
        } catch (Exception e) {
            e.printStackTrace();
            MsgBox.alert(this, "Cập nhật không thành công");
        }
    }
    
    public void delete() {
        if (MsgBox.confirm(this, "Bạn có muốn xóa hay không?")) {
            String macd = txt_maNhanVien.getText();
            try {
                dao.delete(macd);
                this.fillTable();
                this.clearForm();
                MsgBox.alert(this, "Xóa thành công!");
            } catch (Exception e) {
                e.printStackTrace();
                MsgBox.alert(this, "Xóa thất bại!");
            }
        }
    }
    
    public void edit() {
        String manv = (String) tbl_data_QLNhanVien.getValueAt(this.row, 0);
        nhanVien nv = dao.selectById(manv);
        this.setForm(nv);
        tabs.setSelectedIndex(1);
        this.updateStatus();
    }
    
    public void dauTien() {
        this.row = 0;
        this.edit();
    }
    
    public void troVe() {
        if (this.row > 0) {
            this.row--;
            this.edit();
        }
    }
    
    public void tiepTheo() {
        if (this.row < tbl_data_QLNhanVien.getRowCount() - 1) {
            this.row++;
            this.edit();
        }
    }
    
    public void cuoiCung() {
        this.row = tbl_data_QLNhanVien.getRowCount() - 1;
        this.edit();
    }
    
    public void updateStatus() {
        boolean edit = (this.row >= 0);
        boolean first = (this.row == 0);
        boolean last = (this.row == tbl_data_QLNhanVien.getRowCount() - 1);
        
        txt_maNhanVien.setEditable(!edit);
        btn_them.setEnabled(!edit);
        btn_sua.setEnabled(edit);
        btn_xoa.setEnabled(edit);
        
        btn_dauTien.setEnabled(edit && !first);
        btn_troVe.setEnabled(edit && !first);
        btn_tiepTheo.setEnabled(edit && !last);
        btn_cuoiCung.setEnabled(edit && !last);
    }
    
    public void chonAnh() {
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            XImage.save(file);
            ImageIcon icon = XImage.read(file.getName());
            lbl_hinhAnh.setIcon(icon);
            lbl_hinhAnh.setToolTipText(file.getName());
        }
    }
    
     public void timKiem() {
        this.fillTable();
        this.clearForm();
        this.row = -1;
        updateStatus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btg_vaiTro = new javax.swing.ButtonGroup();
        fileChooser = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        tabs = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_data_QLNhanVien = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        txt_timKiem = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        lbl_hinhAnh = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_maNhanVien = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_hoVaTen = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_xacNhanMk = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        rdo_nhanVien = new javax.swing.JRadioButton();
        rdo_truongPhong = new javax.swing.JRadioButton();
        txt_matKhau = new javax.swing.JPasswordField();
        btn_them = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        btn_lamMoi = new javax.swing.JButton();
        btn_dauTien = new javax.swing.JButton();
        btn_tiepTheo = new javax.swing.JButton();
        btn_troVe = new javax.swing.JButton();
        btn_cuoiCung = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 255));
        jLabel1.setText("QUẢN LÝ NHÂN VIÊN");

        tbl_data_QLNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã nhân viên", "Họ và tên", "Email", "Mật khẩu", "Vai trò", "Hình"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_data_QLNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_data_QLNhanVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_data_QLNhanVien);

        txt_timKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_timKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_timKiem, javax.swing.GroupLayout.DEFAULT_SIZE, 647, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addComponent(txt_timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 686, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        tabs.addTab("DANH SÁCH", jPanel3);

        lbl_hinhAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_hinhAnhMouseClicked(evt);
            }
        });

        jLabel3.setText("Ảnh nhân viên");

        jLabel4.setText("Mã nhân viên");

        txt_maNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_maNhanVienActionPerformed(evt);
            }
        });

        jLabel5.setText("Họ và tên");

        txt_hoVaTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_hoVaTenActionPerformed(evt);
            }
        });

        jLabel6.setText("Mật khẩu");

        txt_xacNhanMk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_xacNhanMkActionPerformed(evt);
            }
        });

        jLabel7.setText("Xác nhận mật khẩu");

        jLabel8.setText("Email");

        txt_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_emailActionPerformed(evt);
            }
        });

        jLabel9.setText("Vai trò");

        btg_vaiTro.add(rdo_nhanVien);
        rdo_nhanVien.setText("Nhân viên");
        rdo_nhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdo_nhanVienActionPerformed(evt);
            }
        });

        btg_vaiTro.add(rdo_truongPhong);
        rdo_truongPhong.setText("Trưởng phòng");
        rdo_truongPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdo_truongPhongActionPerformed(evt);
            }
        });

        btn_them.setText("Thêm");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        btn_sua.setText("Sữa");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        btn_xoa.setText("Xóa");
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });

        btn_lamMoi.setText("Làm mới");
        btn_lamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lamMoiActionPerformed(evt);
            }
        });

        btn_dauTien.setText("D");
        btn_dauTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dauTienActionPerformed(evt);
            }
        });

        btn_tiepTheo.setText("N");
        btn_tiepTheo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tiepTheoActionPerformed(evt);
            }
        });

        btn_troVe.setText("T");
        btn_troVe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_troVeActionPerformed(evt);
            }
        });

        btn_cuoiCung.setText("C");
        btn_cuoiCung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cuoiCungActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btn_them)
                        .addGap(18, 18, 18)
                        .addComponent(btn_sua)
                        .addGap(18, 18, 18)
                        .addComponent(btn_xoa)
                        .addGap(18, 18, 18)
                        .addComponent(btn_lamMoi))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lbl_hinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_maNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_hoVaTen, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                            .addComponent(rdo_truongPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGap(18, 18, 18)
                                            .addComponent(rdo_nhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(91, 91, 91)
                                .addComponent(jLabel4)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6)
                            .addComponent(txt_xacNhanMk, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                            .addComponent(jLabel7)
                            .addComponent(txt_matKhau)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btn_dauTien)
                                .addGap(18, 18, 18)
                                .addComponent(btn_troVe)
                                .addGap(18, 18, 18)
                                .addComponent(btn_tiepTheo)
                                .addGap(18, 18, 18)
                                .addComponent(btn_cuoiCung)))))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_maNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_matKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_hoVaTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_dauTien)
                                    .addComponent(btn_tiepTheo)
                                    .addComponent(btn_troVe)
                                    .addComponent(btn_cuoiCung))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(rdo_nhanVien)
                                            .addComponent(rdo_truongPhong)))
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)))
                            .addComponent(lbl_hinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(53, 53, 53)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_xacNhanMk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_them)
                    .addComponent(btn_sua)
                    .addComponent(btn_xoa)
                    .addComponent(btn_lamMoi))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabs.addTab("CẬP NHẬT", jPanel2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 718, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(250, 250, 250)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_maNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_maNhanVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_maNhanVienActionPerformed

    private void txt_hoVaTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_hoVaTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_hoVaTenActionPerformed

    private void txt_xacNhanMkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_xacNhanMkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_xacNhanMkActionPerformed

    private void txt_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_emailActionPerformed

    private void rdo_truongPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdo_truongPhongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdo_truongPhongActionPerformed

    private void rdo_nhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdo_nhanVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdo_nhanVienActionPerformed

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        this.insert();
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        this.update();
    }//GEN-LAST:event_btn_suaActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        this.delete();
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void btn_lamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lamMoiActionPerformed
        this.clearForm();
    }//GEN-LAST:event_btn_lamMoiActionPerformed

    private void btn_dauTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dauTienActionPerformed
        this.dauTien();
    }//GEN-LAST:event_btn_dauTienActionPerformed

    private void btn_troVeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_troVeActionPerformed
        this.troVe();
    }//GEN-LAST:event_btn_troVeActionPerformed

    private void btn_tiepTheoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tiepTheoActionPerformed
        this.tiepTheo();
    }//GEN-LAST:event_btn_tiepTheoActionPerformed

    private void btn_cuoiCungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cuoiCungActionPerformed
        this.cuoiCung();
    }//GEN-LAST:event_btn_cuoiCungActionPerformed

    private void tbl_data_QLNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_data_QLNhanVienMouseClicked
        if (evt.getClickCount() == 2) {
            this.row = tbl_data_QLNhanVien.getSelectedRow();
            this.edit();
        }
    }//GEN-LAST:event_tbl_data_QLNhanVienMouseClicked

    private void lbl_hinhAnhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_hinhAnhMouseClicked
        this.chonAnh();
    }//GEN-LAST:event_lbl_hinhAnhMouseClicked

    private void txt_timKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_timKiemActionPerformed
        this.timKiem();
    }//GEN-LAST:event_txt_timKiemActionPerformed

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
            java.util.logging.Logger.getLogger(frm_QLNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_QLNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_QLNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_QLNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frm_QLNhanVien dialog = new frm_QLNhanVien(new javax.swing.JFrame(), true);
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
    private javax.swing.ButtonGroup btg_vaiTro;
    private javax.swing.JButton btn_cuoiCung;
    private javax.swing.JButton btn_dauTien;
    private javax.swing.JButton btn_lamMoi;
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_tiepTheo;
    private javax.swing.JButton btn_troVe;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_hinhAnh;
    private javax.swing.JRadioButton rdo_nhanVien;
    private javax.swing.JRadioButton rdo_truongPhong;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tbl_data_QLNhanVien;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_hoVaTen;
    private javax.swing.JTextField txt_maNhanVien;
    private javax.swing.JPasswordField txt_matKhau;
    private javax.swing.JTextField txt_timKiem;
    private javax.swing.JTextField txt_xacNhanMk;
    // End of variables declaration//GEN-END:variables
}
