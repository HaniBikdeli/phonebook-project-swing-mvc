package com.phonebook.view;

import com.phonebook.controller.DataSourceConnection;
import javax.swing.*;

public class LoginView extends DataSourceConnection {
    public static JFrame frameLogin = new JFrame();
    public static JPasswordField passInput= new JPasswordField();
    public static JTextField userInput = new JTextField("Enter Username");
    public static JButton loginBtn = new JButton("Login");
    public static JLabel userLabel = new JLabel("Username");
    public static JLabel passLabel = new JLabel("Password");

    public static void loginPage(){
        frameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameLogin.setSize(350,230);
        frameLogin.setTitle("Login Page");
        frameLogin.setLocationRelativeTo(null);
        frameLogin.setLayout(null);

        userInput.setBounds(135,55,120,25);
        passInput.setBounds(135,100,120,25);
        loginBtn.setBounds(110 , 140 , 80 , 25);
//        loginBtn.addActionListener(this);
        userLabel.setBounds(70, 55 , 120 , 25);
        passLabel.setBounds(70,100,120,25);

        frameLogin.add(userInput);
        frameLogin.add(passInput);
        frameLogin.add(loginBtn);
        frameLogin.add(userLabel);
        frameLogin.add(passLabel);

        frameLogin.setVisible(true);
    }

    public JFrame getFrameLogin() {
        return frameLogin;
    }
    public void setFrameLogin(JFrame frameLogin) {
        LoginView.frameLogin = frameLogin;
    }
    public JPasswordField getPassInput() {
        return passInput;
    }
    public void setPassInput(JPasswordField passInput) {
        LoginView.passInput = passInput;
    }
    public JTextField getUserInput() {
        return userInput;
    }
    public void setUserInput(JTextField userInput) {
        LoginView.userInput = userInput;
    }
    public JButton getLoginBtn() {
        return loginBtn;
    }
    public void setLoginBtn(JButton loginBtn) {
        LoginView.loginBtn = loginBtn;
    }
    public JLabel getUserLabel() {
        return userLabel;
    }
    public void setUserLabel(JLabel userLabel) {
        LoginView.userLabel = userLabel;
    }
    public JLabel getPassLabel() {
        return passLabel;
    }
    public void setPassLabel(JLabel passLabel) {
        LoginView.passLabel = passLabel;
    }
}
