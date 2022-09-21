package com.phonebook.controller;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import com.phonebook.model.*;
import com.phonebook.view.ContactsView;

public class ContactsController extends DataSourceConnection{
    private static ContactsModel contactsModel = new ContactsModel();
    private static ContactsView contactsView = new ContactsView();
    public static void initContactsController() {
        try {
            showData();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        contactsView.pubTable.setModel(contactsModel.getPubTableModel());
        contactsView.prvTable.setModel(contactsModel.getPrvTableModel());
        contactsView.pubTable.setDefaultEditor(Object.class, null);
        contactsView.prvTable.setDefaultEditor(Object.class, null);
        TableColumnModel pubColumnModel = contactsView.pubTable.getColumnModel();
        pubColumnModel.getColumn(0).setPreferredWidth(75);
        pubColumnModel.getColumn(1).setPreferredWidth(120);
        pubColumnModel.getColumn(2).setPreferredWidth(75);
        pubColumnModel.getColumn(3).setPreferredWidth(75);
        TableColumnModel prvColumnModel = contactsView.prvTable.getColumnModel();
        prvColumnModel.getColumn(0).setPreferredWidth(75);
        prvColumnModel.getColumn(1).setPreferredWidth(120);
        prvColumnModel.getColumn(2).setPreferredWidth(75);
        prvColumnModel.getColumn(3).setPreferredWidth(75);
    }
    static int colNo;
    static ResultSet rs;
    static DefaultTableModel pubTableModel = contactsView.getPubTableModel();
    static DefaultTableModel prvTableModel = contactsView.getPrvTableModel();
    private static String[] cols = {"FirstName","PhoneNumber" , "Country" , "Province"};
    public static ResultSet readData(int auth) throws SQLException {
        String sql;
        if(auth == 1){
            sql = "Use PhoneBook" + " select FullName , PhoneNumber from dbo.contacts where auth = 1";
            PreparedStatement pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
        } else if (auth == 2 && LoginModel.getId()==1) {
            sql = "Use PhoneBook" + " select FullName , PhoneNumber from dbo.contacts where auth = 2";
            PreparedStatement pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
        }else{
            sql = "Use PhoneBook" + " select FullName , PhoneNumber from dbo.contacts where auth = 2 AND ownerId = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1 , LoginModel.getId());
            rs = pst.executeQuery();
        }
        ResultSetMetaData rsmd = rs.getMetaData();
        colNo = rsmd.getColumnCount();
        return rs;
    }
    public static void showData() throws SQLException {
        pubTableModel.setColumnIdentifiers(cols);
        prvTableModel.setColumnIdentifiers(cols);
        ResultSet rs1 = readData(1);
        Object[] data;
        while (rs1.next()) {
            data = new Object[colNo];
            for (int i = 0; i < colNo; i++) {
                data[i] = rs1.getObject(i + 1);
            }
            pubTableModel.addRow(data);
            contactsModel.setPubTableModel(pubTableModel);
        }
        ResultSet rs2 = readData(2);
        while (rs2.next()) {
            data = new Object[colNo];
            for (int i = 0; i < colNo; i++) {
                data[i] = rs2.getObject(i + 1);
            }
            prvTableModel.addRow(data);
            contactsModel.setPrvTableModel(prvTableModel);
        }

    }

}
