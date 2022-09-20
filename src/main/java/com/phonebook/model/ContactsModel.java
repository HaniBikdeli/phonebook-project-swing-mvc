package com.phonebook.model;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ContactsModel{
    private DefaultTableModel pubTableModel;
    private DefaultTableModel prvTableModel;

    public DefaultTableModel getPubTableModel() {
        return pubTableModel;
    }

    public void setPubTableModel(DefaultTableModel pubTableModel) {
        this.pubTableModel = pubTableModel;
    }

    public DefaultTableModel getPrvTableModel() {
        return prvTableModel;
    }

    public void setPrvTableModel(DefaultTableModel prvTableModel) {
        this.prvTableModel = prvTableModel;
    }
}
