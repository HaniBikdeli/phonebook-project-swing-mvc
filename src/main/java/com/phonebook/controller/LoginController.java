package com.phonebook.controller;

import javax.swing.*;
import java.sql.*;
import com.phonebook.model.LoginModel;
import com.phonebook.view.*;

public class LoginController extends DataSourceConnection{
    static int id;
    ContactsView contactsView;
    private static LoginView loginView;
    private static LoginModel loginModel;
    public LoginController(LoginModel m , LoginView v){
        loginModel = m;
        loginView = v;
        initLoginView();
    }
    public void initLoginView(){
        loginView.getUserInput().setText(loginModel.getUsername());
        loginView.getPassInput().setText(loginModel.getPass());
    }
    public static void initController() {
        loginView.getLoginBtn().addActionListener(e -> loginBtnAction());
    }
    public static void loginBtnAction() {
        loginView.frameLogin.dispose();
        PreparedStatement creds;
        try {
            creds = con.prepareStatement("Use PhoneBook "+"SELECT userId, username, password FROM dbo.users WHERE username = ? AND password = ?");
            creds.setString(1, loginView.getUserInput().getText());
            creds.setString(2, String.valueOf(loginView.getPassInput()));
            ResultSet rs = creds.executeQuery();
            if(rs.next()){
                id = rs.getInt(1);
                loginModel.setId(id);
                LoginView.frameLogin.dispose();
            }
            else{
                JOptionPane.showMessageDialog(null, "Login Failed.");
                LoginView.loginPage();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

}
