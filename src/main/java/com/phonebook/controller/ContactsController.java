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
    private static LoginModel loginModel;
    private static ContactsModel contactsModel;
    private static ContactsView contactsView;
    public ContactsController(ContactsModel m, ContactsView v){
        contactsModel = m;
        contactsView = v;
        initContactsView();
    }
    public void initContactsView() {

    }
    public static void initController() {
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
        } else if (auth == 2 && loginModel.getId()==1) {
            sql = "Use PhoneBook" + " select FullName , PhoneNumber from dbo.contacts where auth = 2";
        }else{
            sql = "Use PhoneBook" + " select FullName , PhoneNumber from dbo.contacts where auth = 2 AND ownerId = ?";
        }
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1 , loginModel.getId());
        rs = pst.executeQuery(sql);
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

    public static void main(String[] args) {
       initController();
    }
}
