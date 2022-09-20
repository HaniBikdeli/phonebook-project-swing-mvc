package com.phonebook.controller;

import com.phonebook.model.*;
import com.phonebook.view.InsertView;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertController extends DataSourceConnection{
    private static LoginModel loginModel;
    private static InsertModel insertModel;
    private static InsertView insertView;
    public InsertController(InsertModel m , InsertView v){
        insertModel = m;
        insertView = v;
    }
    public void initLoginView(){
        insertView.getFirstNameInput().setText(insertModel.getFirstName());
        insertView.getPhoneNumInput().setText(insertModel.getPhoneNumber());
    }
    public void initLoginController(){
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
            addData.setInt(3, loginModel.getId());
            addData.setInt(4, access);
            addData.executeUpdate();
            JOptionPane.showMessageDialog(null, "Contact Added");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
