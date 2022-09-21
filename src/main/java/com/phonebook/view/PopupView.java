package com.phonebook.view;

import com.phonebook.controller.PopupController;

import javax.swing.*;
import java.awt.*;

public class PopupView{
    public static JFrame framePopUp = new JFrame();
    public static JLabel opsLabel = new JLabel("Choose Operation");
    public static JButton rmBtn = new JButton("Remove");
    public static JButton editBtn = new JButton("Edit");
    public static void popupForm(){
        framePopUp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        framePopUp.setSize(270, 200);
        framePopUp.setTitle("Home Page");
        framePopUp.setLocationRelativeTo(null);
        framePopUp.setLayout(null);
        framePopUp.setBackground(Color.cyan);

        opsLabel.setBounds(75 , 30 , 130 , 15);
        rmBtn.setBounds(25 , 75, 90 , 30);
        editBtn.setBounds(135 , 75, 90 , 30);

        PopupController.initPopupController();

        framePopUp.add(opsLabel);
        framePopUp.add(editBtn);
        framePopUp.add(rmBtn);
        framePopUp.setVisible(true);
    }

    public static JFrame getFramePopUp() {
        return framePopUp;
    }

    public static void setFramePopUp(JFrame framePopUp) {
        PopupView.framePopUp = framePopUp;
    }

    public static JLabel getOpsLabel() {
        return opsLabel;
    }

    public static void setOpsLabel(JLabel opsLabel) {
        PopupView.opsLabel = opsLabel;
    }

    public static JButton getRmBtn() {
        return rmBtn;
    }

    public static void setRmBtn(JButton rmBtn) {
        PopupView.rmBtn = rmBtn;
    }

    public static JButton getEditBtn() {
        return editBtn;
    }

    public static void setEditBtn(JButton editBtn) {
        PopupView.editBtn = editBtn;
    }
}
