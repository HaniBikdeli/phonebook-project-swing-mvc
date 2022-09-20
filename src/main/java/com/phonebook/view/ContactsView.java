package com.phonebook.view;

import com.phonebook.controller.DataSourceConnection;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.sql.SQLException;

public class ContactsView extends DataSourceConnection {
    private static JFrame frame = new JFrame();
    private static JFrame framePopUp = new JFrame();
    private static JPanel pubPhoneNums = new JPanel();
    private static JPanel prvPhoneNums = new JPanel();
    private static JPanel rmContact = new JPanel();
    public static JTable pubTable = new JTable();
    public static JTable prvTable = new JTable();
    private static JLabel hpHeaderPub = new JLabel("Your Public Contacts");
    private static JLabel hpHeaderPrv = new JLabel("Your Private Contacts");
    private static JLabel opsLabel = new JLabel("Choose Operation");
    private static JButton newNumBtn = new JButton("New Number");
    private static JButton rmBtn = new JButton("remove");
    private static JButton editBtn = new JButton("edit");
    private static JButton rmNumBtn = new JButton("Remove Number");
    private static Border border = new LineBorder(Color.gray, 3, true);
    private static DefaultTableModel pubTableModel = (DefaultTableModel) pubTable.getModel();
    private static DefaultTableModel prvTableModel = (DefaultTableModel) prvTable.getModel();

    public ContactsView() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750, 450);
        frame.setTitle("Home Page");
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setBackground(Color.cyan);

        hpHeaderPub.setBounds(75, 10, 125, 15);
        pubPhoneNums.setBounds(50, 45, 350, 125);
        pubPhoneNums.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));

        hpHeaderPrv.setBounds(75, 190, 125, 15);
        prvPhoneNums.setBounds(50, 210, 350, 125);
        prvPhoneNums.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));

//        pubTableModel = (DefaultTableModel) pubTable.getModel();
//        prvTableModel = (DefaultTableModel) prvTable.getModel();

//        PhoneBookLogin.showData();
        prvPhoneNums.setBorder(border);

//        rmBtn.addActionListener(this);
        pubPhoneNums.add(pubTable);
        prvPhoneNums.add(prvTable);

        newNumBtn.setBounds(38, 360, 130, 25);
//        newNumBtn.addActionListener(newNum);
        rmNumBtn.setBounds(180, 360, 130, 25);
//        rmNumBtn.addActionListener(rmNum);
        frame.add(hpHeaderPub);
        frame.add(hpHeaderPrv);
        frame.add(pubPhoneNums);
        frame.add(prvPhoneNums);
//        frame.add(addContact);
//        frame.add(searchContact);

//        PhoneBookRm.removePage();
//        PhoneBookInsert insert = new PhoneBookInsert();
//        insert.insertPage();
//        PhoneBookSearch search = new PhoneBookSearch();
//        search.searchPage();
        frame.setVisible(true);
    }
    public static JFrame getFrame() {
        return frame;
    }

    public static void setFrame(JFrame frame) {
        ContactsView.frame = frame;
    }

    public static JPanel getPubPhoneNums() {
        return pubPhoneNums;
    }

    public static void setPubPhoneNums(JPanel pubPhoneNums) {
        ContactsView.pubPhoneNums = pubPhoneNums;
    }

    public static JPanel getPrvPhoneNums() {
        return prvPhoneNums;
    }

    public static void setPrvPhoneNums(JPanel prvPhoneNums) {
        ContactsView.prvPhoneNums = prvPhoneNums;
    }

    public static JTable getPubTable() {
        return pubTable;
    }

    public static void setPubTable(JTable pubTable) {
        ContactsView.pubTable = pubTable;
    }

    public static JTable getPrvTable() {
        return prvTable;
    }

    public static void setPrvTable(JTable prvTable) {
        ContactsView.prvTable = prvTable;
    }

    public static DefaultTableModel getPubTableModel() {
        return pubTableModel;
    }

    public static void setPubTableModel(DefaultTableModel pubTableModel) {
        ContactsView.pubTableModel = pubTableModel;
    }

    public static DefaultTableModel getPrvTableModel() {
        return prvTableModel;
    }

    public static void setPrvTableModel(DefaultTableModel prvTableModel) {
        ContactsView.prvTableModel = prvTableModel;
    }

}
