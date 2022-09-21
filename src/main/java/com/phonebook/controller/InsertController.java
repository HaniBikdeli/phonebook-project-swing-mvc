package com.phonebook.controller;

import com.phonebook.model.*;
import com.phonebook.view.ContactsView;
import com.phonebook.view.InsertView;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertController extends DataSourceConnection{
    private static InsertModel insertModel = new InsertModel();
    private static InsertView insertView = new InsertView();
    public static void initInsertController(){
        InsertView.insertComponent();
        ContactsView.getFrame().add(InsertView.getAddContact());
        insertView.getInsertBtn().addActionListener(e -> insertBtnAction());
    }
    public static void countryMenu() throws SQLException {
        JComboBox<String> provinceMenu = new JComboBox<>();
        JComboBox<String> countryMenu = new JComboBox<>();
        int countryId;
        PreparedStatement comboBoxCountries = con.prepareStatement("Use PhoneBook "+"select * from dbo.countries");
        ResultSet rs1=comboBoxCountries.executeQuery();
        countryId = rs1.getInt("countryId");
        while (rs1.next()) {
            countryMenu.addItem(rs1.getString("CountryName"));
        }
        PreparedStatement comboBoxProvince = con.prepareStatement("Use PhoneBook "+"select * from dbo.provinces where provinceFk = ?");
        comboBoxProvince.setInt(1,countryId);
        ResultSet rs2=comboBoxProvince.executeQuery();

        while (rs2.next()) {
            provinceMenu.addItem(rs2.getString("ProvinceName"));
        }
        countryMenu.setBounds(10, 145, 90, 25);
        provinceMenu.setBounds(115, 145, 120, 25);
    }
    public static void insertBtnAction(){
        PreparedStatement addData;
        String fullName = insertView.getFirstNameInput().getText();
        String phoneNumber = insertView.getPhoneNumInput().getText();
        int accessIndex = insertView.getAccessMenu().getSelectedIndex();
        int access;
        if (accessIndex == 0) {
            access = 1;
        } else {
            access = 2;
        }
        try {
            addData = con.prepareStatement("Use PhoneBook "+"insert into dbo.contacts (FullName , PhoneNumber ,ownerId , auth) values ( ? , ? ,?,?)");
            addData.setString(1, fullName);
            addData.setString(2, phoneNumber);
            addData.setInt(3, LoginModel.getId());
            addData.setInt(4, access);
            addData.executeUpdate();
            JOptionPane.showMessageDialog(null, "Contact Added");
            resetTable();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    public static void resetTable(){
        DefaultTableModel removePubRow = (DefaultTableModel) ContactsView.getPubTable().getModel();
        removePubRow.setRowCount(0);
        DefaultTableModel removePrvRow = (DefaultTableModel) ContactsView.getPrvTable().getModel();
        removePrvRow.setRowCount(0);
        ContactsController.initContactsController();
    }
}
