package com.phonebook.view;

import javax.swing.*;
import java.awt.*;

public class EditView {
    public static JFrame editFrame = new JFrame();
    public static JLabel editNameLabel = new JLabel("FirstName");
    public static JLabel editPhoneNumberLabel = new JLabel("Phone Number");
    public static JButton saveBtn = new JButton("Save");
    public static JTextField editNameInput= new JTextField("Enter Target's FullName");
    public static JTextField editPhoneNumberInput = new JTextField("e.g 09123456789");
    public static void editForm(){
        editFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        editFrame.setSize(270, 200);
        editFrame.setTitle("Edit Page");
        editFrame.setLocationRelativeTo(null);
        editFrame.setLayout(null);
        editFrame.setBackground(Color.cyan);

        editNameLabel.setBounds(15, 20, 120, 25);
        editPhoneNumberLabel.setBounds(15, 65, 120, 25);
        saveBtn.setBounds(115, 100, 120, 25);

        editNameInput.setBounds(115, 20, 120, 25);
        editPhoneNumberInput.setBounds(115, 65, 120, 25);

        editFrame.add(editNameLabel);
        editFrame.add(editPhoneNumberLabel);
        editFrame.add(saveBtn);
        editFrame.add(editNameInput);
        editFrame.add(editPhoneNumberInput);

        editFrame.setLayout(null);
        editFrame.setVisible(true);
    }

    public static JFrame getEditFrame() {
        return editFrame;
    }

    public static void setEditFrame(JFrame editFrame) {
        EditView.editFrame = editFrame;
    }

    public static JLabel getEditNameLabel() {
        return editNameLabel;
    }

    public static void setEditNameLabel(JLabel editNameLabel) {
        EditView.editNameLabel = editNameLabel;
    }

    public static JLabel getEditPhoneNumberLabel() {
        return editPhoneNumberLabel;
    }

    public static void setEditPhoneNumberLabel(JLabel editPhoneNumberLabel) {
        EditView.editPhoneNumberLabel = editPhoneNumberLabel;
    }

    public static JButton getSaveBtn() {
        return saveBtn;
    }

    public static void setSaveBtn(JButton saveBtn) {
        EditView.saveBtn = saveBtn;
    }

    public static JTextField getEditNameInput() {
        return editNameInput;
    }

    public static void setEditNameInput(JTextField editNameInput) {
        EditView.editNameInput = editNameInput;
    }

    public static JTextField getEditPhoneNumberInput() {
        return editPhoneNumberInput;
    }

    public static void setEditPhoneNumberInput(JTextField editPhoneNumberInput) {
        EditView.editPhoneNumberInput = editPhoneNumberInput;
    }
}
