/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bai5;

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
    private final  String url = "jdbc:sqlserver://localhost;databaseName=QLSinhVien;";
    private Connection conn = null;
    ConnectDataBase() throws SQLException, ClassNotFoundException{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        conn = DriverManager.getConnection(url, "sa", "123");
    }
     
    public void createTable()
    {
        try {
            Statement st = conn.createStatement();
            String query;
            
            //Bảng SinhVien
            query = "CREATE TABLE SinhVien " +
                    "( MaSV nchar(10) PRIMARY KEY," +
                    "HoTen nvarchar(50)," +
                    "DiaChi nvarchar(50)," +
                    "Lop nchar(10))";
            st.executeUpdate(query);
            
            //Bảng HocVi
            query = "CREATE TABLE HocVi " 
                    +"( MaHV nchar(10) PRIMARY KEY," 
                    +"TenHV nvarchar(20))";
            st.executeUpdate(query);
            
            //Bảng DeTai
            query = "CREATE TABLE DeTai " 
                    +"( MaDT nchar(10) PRIMARY KEY," 
                    +"TenDT nvarchar(20))";
            st.executeUpdate(query);
            
            //Bảng SinhVien_DeTai
            query = "CREATE TABLE SinhVien_DeTai " 
                    + "( MaSV nchar(10)," 
                    + "MaDT nchar(10),"
                    + "PRIMARY KEY(MaSV, MaDT),"
                    + "FOREIGN KEY(MaDT) REFERENCES DeTai(MaDT),"
                    + "FOREIGN KEY(MaSV) REFERENCES SinhVien(MaSV))";
            st.executeUpdate(query);
            
            //Bảng GiaoVien
            query = "CREATE TABLE GiaoVien " 
                    + "( MaGV nchar(10) PRIMARY KEY,"
                    + "HoTen nvarchar(50),"
                    + "DiaChi nvarchar(50),"
                    + "MaHV nchar(10),"
                    + "FOREIGN KEY (MaHV) REFERENCES HocVi(MaHV))";
            st.executeUpdate(query);

            //Bảng GiaoVien_DeTai
            query = "CREATE TABLE GiaoVien_DeTai " 
                    + "( MaGV nchar(10)," 
                    + "MaDT nchar(10),"
                    + "PRIMARY KEY(MaGV, MaDT),"
                    + "FOREIGN KEY(MaDT) REFERENCES DeTai(MaDT),"
                    + "FOREIGN KEY(MaGV) REFERENCES GiaoVien(MaGV))";
            st.executeUpdate(query);
            
            //Bảng KetQua
            query = "CREATE TABLE KetQua " 
                    + "( MaSV nchar(10)," 
                    + "MaDT nchar(10),"
                    + "Diem int,"
                    + "PRIMARY KEY(MaSV, MaDT),"
                    + "FOREIGN KEY(MaDT) REFERENCES DeTai(MaDT),"
                    + "FOREIGN KEY(MaSV) REFERENCES SinhVien(MaSV))";
            st.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
}
