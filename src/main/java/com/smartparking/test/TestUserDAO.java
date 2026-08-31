package com.smartparking.test;

import com.smartparking.dao.UserDAO;

public class TestUserDAO {

    public static void main(String[] args) {

        UserDAO dao = new UserDAO();

        dao.getAllUsers();

    }

}