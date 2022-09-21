package com.phonebook.controller;

import javax.swing.*;
import java.sql.*;
import com.phonebook.model.LoginModel;
import com.phonebook.view.*;

public class LoginController extends DataSourceConnection{
    static int id;
    private static LoginView loginView;
    private static LoginModel loginModel;

    public LoginController(LoginModel m , LoginView v){
        loginModel = m;
        loginView = v;
        initLoginView();
    }

    public static void initLoginController() {
        loginView.getLoginBtn().addActionListener(e -> loginBtnAction());
        loginView.loginPage();
    }

    public void initLoginView(){
        loginView.getUserInput().setText(loginModel.getUsername());
        loginView.getPassInput().setText(loginModel.getPass());
    }

    public static void loginBtnAction() {
        loginModel = new LoginModel(loginView.getUserInput().getText() , loginView.getPassInput().getText());
        loginView.frameLogin.dispose();
        PreparedStatement creds;
        try {
            creds = con.prepareStatement("Use PhoneBook "+"SELECT userId, username, password FROM dbo.users WHERE username = ? AND password = ?");
            creds.setString(1, loginModel.getUsername());
            creds.setString(2, String.valueOf(loginModel.getPass()));
            ResultSet rs = creds.executeQuery();
            if(rs.next()){
                id = rs.getInt(1);
                loginModel.setId(id);
                LoginView.frameLogin.dispose();
                ContactsView contactsView = new ContactsView();
                ContactsController.initContactsController();
                InsertController.initInsertController();
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
