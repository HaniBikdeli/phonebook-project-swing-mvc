package com.phonebook.view;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;

public class InsertView {
    public static JPanel addContact = new JPanel();
    public static JLabel firstNameLabel = new JLabel("FirstName");
    public static JLabel phoneNumLabel = new JLabel("Phone Number");
    public static JLabel accessLabel = new JLabel("Access");
    public static JButton insertBtn = new JButton("Add");
    public static JTextField firstNameInput= new JTextField("Enter Target's FullName");
    public static JTextField phoneNumInput = new JTextField("e.g 09123456789");
    public static Border insertBorder = new LineBorder(Color.gray, 3, true);

    static String[] accessOptions = {"Public", "Private"};
    static JComboBox<String> accessMenu = new JComboBox<>(accessOptions);
    public static void insertComponent(){
        addContact.setBounds(450, 30, 250, 220);
        addContact.setBorder(insertBorder);

        firstNameInput.setBounds(115, 25, 120, 25);
        phoneNumInput.setBounds(115, 65, 120, 25);
        insertBtn.setBounds(115, 175, 120, 25);

        firstNameLabel.setBounds(10, 25, 120, 25);
        phoneNumLabel.setBounds(10, 65, 120, 25);
        accessLabel.setBounds(10, 105, 120, 25);
        accessMenu.setBounds(115, 105, 129, 25);

        addContact.add(firstNameLabel);
        addContact.add(firstNameInput);
        addContact.add(phoneNumLabel);
        addContact.add(phoneNumInput);
        addContact.add(accessLabel);
        addContact.add(accessMenu);
//            addContact.add(countryMenu);
//            addContact.add(provinceMenu);
        addContact.add(insertBtn);

        addContact.setLayout(null);
        addContact.setVisible(true);
    }

    public static JPanel getAddContact() {
        return addContact;
    }

    public  void setAddContact(JPanel addContact) {
        InsertView.addContact = addContact;
    }

    public  JLabel getPhoneNumLabel() {
        return phoneNumLabel;
    }

    public  void setPhoneNumLabel(JLabel phoneNumLabel) {
        InsertView.phoneNumLabel = phoneNumLabel;
    }

    public  JLabel getFirstNameLabel() {
        return firstNameLabel;
    }

    public  void setFirstNameLabel(JLabel firstNameLabel) {
        InsertView.firstNameLabel = firstNameLabel;
    }

    public  JLabel getAccessLabel() {
        return accessLabel;
    }

    public  void setAccessLabel(JLabel accessLabel) {
        InsertView.accessLabel = accessLabel;
    }

    public  JButton getInsertBtn() {
        return insertBtn;
    }

    public  void setInsertBtn(JButton insertBtn) {
        InsertView.insertBtn = insertBtn;
    }

    public  JTextField getFirstNameInput() {
        return firstNameInput;
    }

    public  void setFirstNameInput(JTextField firstNameInput) {
        InsertView.firstNameInput = firstNameInput;
    }

    public  JTextField getPhoneNumInput() {
        return phoneNumInput;
    }

    public  void setPhoneNumInput(JTextField phoneNumInput) {
        InsertView.phoneNumInput = phoneNumInput;
    }

    public  Border getInsertBorder() {
        return insertBorder;
    }

    public  void setInsertBorder(Border insertBorder) {
        InsertView.insertBorder = insertBorder;
    }

    public  String[] getAccessOptions() {
        return accessOptions;
    }

    public  void setAccessOptions(String[] accessOptions) {
        InsertView.accessOptions = accessOptions;
    }

    public  JComboBox<String> getAccessMenu() {
        return accessMenu;
    }

    public  void setAccessMenu(JComboBox<String> accessMenu) {
        InsertView.accessMenu = accessMenu;
    }
}
