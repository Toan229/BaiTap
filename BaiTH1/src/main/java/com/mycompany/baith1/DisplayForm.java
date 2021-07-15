/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.baith1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author phtoa
 */
public class DisplayForm extends javax.swing.JFrame {

    /**
     * Creates new form DisplayForm
     */
    public DisplayForm() {
        initComponents();
        String[] columnsName = {"Mã sản phẩm", "Tên sản phẩm", "Tên loại sản phẩm"}; 
        DefaultTableModel model = (DefaultTableModel)DisplayTable.getModel();
        model.setColumnIdentifiers(columnsName);
        loadTable();
        loadComboBox();
    }

    private void loadTable()
    {
        DefaultTableModel model = (DefaultTableModel)DisplayTable.getModel();
        model.setRowCount(0);
        try {
            String query = "SELECT MaSP, TenSP, TenLoaiSP FROM SanPham INNER JOIN LoaiSanPham ON SanPham.MaLoaiSP = LoaiSanPham.MaLoaiSP";
            ResultSet rs = new ConnectDataBase().getTable(query);
            while(rs.next())
            {
                String[] datarow = {rs.getString("MaSP"), rs.getString("TenSP"), rs.getString("TenLoaiSP")};
                model.addRow(datarow);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DisplayForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void loadComboBox()
    {
        String query = "SELECT TenLoaiSP FROM LoaiSanPham";
        try {
            ResultSet rs = new ConnectDataBase().getTable(query);
            jComboBox1.removeAllItems();
            while(rs.next())
            {
                jComboBox1.addItem(rs.getString("TenLoaiSP"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DisplayForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DisplayForm.class.getName()).log(Level.SEVERE, null, ex);
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

        ReloadBtn = new javax.swing.JButton();
        AddNewBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        DisplayTable = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ReloadBtn.setText("Tải lại danh sách");
        ReloadBtn.setPreferredSize(new java.awt.Dimension(133, 30));
        ReloadBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ReloadBtnMouseClicked(evt);
            }
        });

        AddNewBtn.setText("Thêm mới sản phẩm");
        AddNewBtn.setPreferredSize(new java.awt.Dimension(133, 30));
        AddNewBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddNewBtnMouseClicked(evt);
            }
        });

        DisplayTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(DisplayTable);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Mã sản phẩm");

        jLabel2.setText("Tên sản phẩm");

        jLabel3.setText("Loại sản phẩm");

        jLabel4.setText("Nhà sản xuất");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                        .addComponent(jTextField2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AddNewBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ReloadBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(29, Short.MAX_VALUE)
                        .addComponent(ReloadBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(AddNewBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(26, 26, 26)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        ReloadBtn.getAccessibleContext().setAccessibleName("ReloadBtn");
        AddNewBtn.getAccessibleContext().setAccessibleName("AddNewBtn");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ReloadBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReloadBtnMouseClicked
        // TODO add your handling code here:
        loadTable();
    }//GEN-LAST:event_ReloadBtnMouseClicked

    private void AddNewBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddNewBtnMouseClicked
        // TODO add your handling code here:
        String query = "SELECT * FROM LoaiSanPham WHERE TenLoaiSP = '" + jComboBox1.getSelectedItem().toString().trim() + "'";
        try {
            ResultSet rs = new ConnectDataBase().getTable(query);
            if(rs.next())
            {
                String query1 = "INSERT INTO SanPham VALUES (?, ?, ?, ?)";
                new ConnectDataBase().execQuery(query1, jTextField1.getText(), jTextField2.getText(), jTextField3.getText(), rs.getString("MaLoaiSP"));
                String[] newRow = {jTextField1.getText(), jTextField2.getText(), jComboBox1.getSelectedItem().toString().trim()};
                DefaultTableModel model = (DefaultTableModel)DisplayTable.getModel();
                model.addRow(newRow);                
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DisplayForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AddNewBtnMouseClicked

    /**
     * @param args the command line arguments
     */
    /*public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DisplayForm().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddNewBtn;
    private javax.swing.JTable DisplayTable;
    private javax.swing.JButton ReloadBtn;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}