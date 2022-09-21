package com.phonebook.controller;

import com.phonebook.model.EditModel;
import com.phonebook.view.EditView;
import com.phonebook.view.PopupView;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EditController extends DataSourceConnection{
    public static void initEditController(){
        EditView.getEditNameInput().setText(ContactsController.getSelectedName());
        EditView.getEditPhoneNumberInput().setText(ContactsController.getSelectedPhoneNumber());
        EditView.getSaveBtn().addActionListener(e -> saveBtnAction());
    }
    public static void saveBtnAction(){
        try {
            PreparedStatement pstEdit = con.prepareStatement("UPDATE dbo.contacts" +
                    " SET FullName = ? , PhoneNumber = ?" +
                    " where FullName = ? AND PhoneNumber = ?");
            pstEdit.setString(1, EditView.getEditNameInput().getText());
            pstEdit.setString(2, EditView.getEditPhoneNumberInput().getText());
            pstEdit.setString(3, EditView.getEditNameInput().getText());
            pstEdit.setString(4, ContactsController.getSelectedPhoneNumber());
            pstEdit.executeUpdate();
            EditView.editFrame.dispose();
            PopupView.framePopUp.dispose();
            InsertController.resetTable();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
