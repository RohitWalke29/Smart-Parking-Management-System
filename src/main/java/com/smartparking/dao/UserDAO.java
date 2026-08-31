package com.smartparking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.smartparking.model.User;
import com.smartparking.util.DBConnection;

public class UserDAO {


    // ===================== GET ALL USERS =====================

    public List<User> getAllUsers() {

        List<User> userList = new ArrayList<>();

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM users";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();


            while(rs.next()) {

                User user = new User();

                user.setUserId(rs.getInt("user_id"));
                user.setName(rs.getString("full_name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
                user.setCreatedAt(rs.getString("created_at"));


                userList.add(user);

            }


            rs.close();
            ps.close();
            con.close();


        } catch(Exception e) {

            e.printStackTrace();

        }


        return userList;

    }



    // ===================== ADD USER =====================

    public boolean addUser(User user) {


        boolean status = false;


        try {


            Connection con = DBConnection.getConnection();


            String sql =
            "INSERT INTO users(full_name,email,password,phone,address) VALUES(?,?,?,?,?)";


            PreparedStatement ps = con.prepareStatement(sql);


            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getPhone());
            ps.setString(5, user.getAddress());


            int rows = ps.executeUpdate();


            if(rows > 0) {

                status = true;

            }


            ps.close();
            con.close();



        } catch(Exception e) {

            e.printStackTrace();

        }


        return status;

    }




    // ===================== UPDATE USER =====================


    public boolean updateUser(User user) {


        boolean status = false;


        try {


            Connection con = DBConnection.getConnection();


            String sql =
            "UPDATE users SET full_name=?, email=?, password=?, phone=?, address=? WHERE user_id=?";


            PreparedStatement ps = con.prepareStatement(sql);



            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getPhone());
            ps.setString(5, user.getAddress());
            ps.setInt(6, user.getUserId());



            int rows = ps.executeUpdate();



            if(rows > 0) {

                status = true;

            }



            ps.close();
            con.close();



        } catch(Exception e) {

            e.printStackTrace();

        }



        return status;


    }
    
    // ===================== DELETE USER =====================

    public boolean deleteUser(int userId) {


        boolean status = false;


        try {


            Connection con = DBConnection.getConnection();


            String sql = "DELETE FROM users WHERE user_id=?";


            PreparedStatement ps = con.prepareStatement(sql);


            ps.setInt(1, userId);


            int rows = ps.executeUpdate();


            if(rows > 0) {

                status = true;

            }


            ps.close();
            con.close();



        } catch(Exception e) {

            e.printStackTrace();

        }


        return status;


    }




    // ===================== LOGIN USER =====================


    public User loginUser(String email, String password) {


        User user = null;


        try {


            Connection con = DBConnection.getConnection();


            String sql =
            "SELECT * FROM users WHERE email=? AND password=?";


            PreparedStatement ps = con.prepareStatement(sql);


            ps.setString(1, email);
            ps.setString(2, password);



            ResultSet rs = ps.executeQuery();



            if(rs.next()) {


                user = new User();


                user.setUserId(rs.getInt("user_id"));
                user.setName(rs.getString("full_name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
                user.setCreatedAt(rs.getString("created_at"));


            }



            rs.close();
            ps.close();
            con.close();



        } catch(Exception e) {

            e.printStackTrace();

        }


        return user;


    }


}