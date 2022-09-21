package com.phonebook.controller;

import com.phonebook.view.EditView;
import com.phonebook.view.PopupView;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PopupController extends DataSourceConnection{

    public static void initPopupController(){
        PopupView.getRmBtn().addActionListener(e -> rmBtnAction());
        PopupView.getEditBtn().addActionListener(e -> editBtnAction());
        EditController.initEditController();
    }
    public static void rmBtnAction(){
        try {
            PreparedStatement pstDelete = con.prepareStatement("Delete from dbo.contacts where PhoneNumber = ? and FullName = ?");
            pstDelete.setString(1, ContactsController.getSelectedPhoneNumber());
            pstDelete.setString(2, ContactsController.getSelectedName());
            pstDelete.executeUpdate();
            PopupView.framePopUp.dispose();
            InsertController.resetTable();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void editBtnAction(){
        EditView.editForm();
    }

}
