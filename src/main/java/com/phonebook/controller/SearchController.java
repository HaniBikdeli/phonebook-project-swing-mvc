package com.phonebook.controller;

import com.phonebook.model.ContactsModel;
import com.phonebook.model.LoginModel;
import com.phonebook.model.SearchModel;
import com.phonebook.view.ContactsView;
import com.phonebook.view.SearchView;

import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class SearchController extends DataSourceConnection{
    static int colNo;
    static ResultSet rs;
    static DefaultTableModel pubTableModel = ContactsView.getPubTableModel();
    static DefaultTableModel prvTableModel = ContactsView.getPrvTableModel();
    static SearchModel searchModel = new SearchModel();
    private static String[] cols = {"FirstName","PhoneNumber" , "Country" , "Province"};
    public static void initSearchController(){
        SearchView.searchPage();
        SearchView.getSearchBtn().addActionListener(e -> {
            try {
                DefaultTableModel removePubRow = (DefaultTableModel) ContactsView.getPubTable().getModel();
                removePubRow.setRowCount(0);
                DefaultTableModel removePrvRow = (DefaultTableModel) ContactsView.getPrvTable().getModel();
                removePrvRow.setRowCount(0);
                showSearchData();
                ContactsView.pubTable.setModel(searchModel.getPubTableModel());
                ContactsView.prvTable.setModel(searchModel.getPrvTableModel());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
    }
    public static ResultSet readSearchData(int auth) throws SQLException {
        String sql;
        sql = "Use PhoneBook" + " select FullName , PhoneNumber from dbo.contacts where auth = ? and FullName like ? and ownerId = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1 , auth);
        pst.setString(2 , SearchView.getSearchInput().getText());
        pst.setInt(3 , LoginModel.getId());
        rs = pst.executeQuery();
        ResultSetMetaData rsmd = rs.getMetaData();
        colNo = rsmd.getColumnCount();
        return rs;
    }
    public static void showSearchData() throws SQLException {
        pubTableModel.setColumnIdentifiers(cols);
        prvTableModel.setColumnIdentifiers(cols);
        ResultSet rs1 = readSearchData(1);
        Object[] data;
        while (rs1.next()) {
            data = new Object[colNo];
            for (int i = 0; i < colNo; i++) {
                data[i] = rs1.getObject(i + 1);
            }
            pubTableModel.addRow(data);
            searchModel.setPubTableModel(pubTableModel);
        }
        ResultSet rs2 = readSearchData(2);
        while (rs2.next()) {
            data = new Object[colNo];
            for (int i = 0; i < colNo; i++) {
                data[i] = rs2.getObject(i + 1);
            }
            prvTableModel.addRow(data);
            searchModel.setPrvTableModel(prvTableModel);
        }
    }
}
