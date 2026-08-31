package com.smartparking.test;

import com.smartparking.dao.UserDAO;
import com.smartparking.model.User;

public class TestUpdateUser {

    public static void main(String[] args) {

        User user = new User();

        user.setUserId(6);
        user.setName("Virat Kohli Updated");
        user.setEmail("virat18@gmail.com");
        user.setPassword("virat@123");
        user.setPhone("9999999999");
        user.setAddress("Mumbai");

        UserDAO dao = new UserDAO();

        if (dao.updateUser(user)) {
            System.out.println("Update Successful!");
        } else {
            System.out.println("Update Failed!");
        }
    }
}