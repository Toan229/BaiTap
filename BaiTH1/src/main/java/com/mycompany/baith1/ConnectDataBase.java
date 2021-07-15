/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.baith1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author phtoa
 */
public class ConnectDataBase {
    private final  String url = "jdbc:sqlserver://localhost;databaseName=QLSanPham;";
    private Connection conn = null;
    ConnectDataBase() throws SQLException, ClassNotFoundException{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        conn = DriverManager.getConnection(url, "sa", "123");
    }
     
    public ResultSet getTable(String query)
    {
        ResultSet rs;
        try {
            Statement st = conn.createStatement();
            rs = st.executeQuery(query);
            return rs;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public void execQuery(String query, String maSP, String tenSP, String nhaSX, String maLoaiSP)
    {
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString (1, maSP);
            ps.setString (2, tenSP);
            ps.setString (3, nhaSX);
            ps.setString(4, maLoaiSP);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
