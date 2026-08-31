package com.smartparking.test;

import com.smartparking.dao.UserDAO;
import com.smartparking.model.User;

public class TestAddUser {

    public static void main(String[] args) {

        User user = new User();

        user.setName("Virat Kohli");
        user.setEmail("virat@gmail.com");
        user.setPassword("virat123");
        user.setPhone("9876500000");
        user.setAddress("Delhi");

        UserDAO dao = new UserDAO();

        boolean result = dao.addUser(user);

        if (result) {
            System.out.println("Data Inserted Successfully!");
        } else {
            System.out.println("Insertion Failed!");
        }
    }
}