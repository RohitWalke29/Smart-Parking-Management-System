package com.smartparking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.smartparking.model.Admin;
import com.smartparking.util.DBConnection;

public class AdminDAO {

    // Admin Login
    public Admin loginAdmin(String username, String password) {

        Admin admin = null;

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM admins WHERE username=? AND password=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                admin = new Admin();

                admin.setAdminId(rs.getInt("admin_id"));
                admin.setUsername(rs.getString("username"));
                admin.setPassword(rs.getString("password"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return admin;
    }

}