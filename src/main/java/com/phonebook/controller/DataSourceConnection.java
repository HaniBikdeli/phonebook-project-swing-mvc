package com.phonebook.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Properties;

public class DataSourceConnection{

    public static final String URL = "jdbc:sqlserver://localhost\\SQL;database=PhoneBook;trustServerCertificate=true";
    public static final String DB_USERNAME = "sa";
    public static final String DB_PASSWORD = "123";
    public static Connection con;

    static {
        try {
            con = DriverManager.getConnection(URL, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static Statement statement;

    static {
        try {
            statement = con.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
