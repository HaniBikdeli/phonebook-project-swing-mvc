package com.phonebook.view;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;

public class SearchView {
    public static JPanel searchContact = new JPanel();
    public static JLabel searchLabel = new JLabel("FullName");
    public static JTextField searchInput= new JTextField("Enter Target's FullName");
    public static JButton searchBtn = new JButton("Search");
    public static Border searchBorder = new LineBorder(Color.gray, 3, true);

    public static void searchPage(){
        searchContact.setBounds(450, 320, 250, 120);
        searchContact.setBorder(searchBorder);

        searchInput.setBounds(115, 30, 120, 25);
        searchLabel.setBounds(20 , 30 , 100 , 25);
        searchBtn.setBounds(115, 60, 120, 25);

        searchContact.add(searchInput);
        searchContact.add(searchLabel);
        searchContact.add(searchBtn);

        ContactsView.getFrame().add(searchContact);
        searchContact.setLayout(null);
        searchContact.setVisible(true);
    }

    public static JPanel getSearchContact() {
        return searchContact;
    }

    public static void setSearchContact(JPanel searchContact) {
        SearchView.searchContact = searchContact;
    }

    public static JButton getSearchBtn() {
        return searchBtn;
    }

    public static void setSearchBtn(JButton searchBtn) {
        SearchView.searchBtn = searchBtn;
    }

    public static JTextField getSearchInput() {
        return searchInput;
    }

    public static void setSearchInput(JTextField searchInput) {
        SearchView.searchInput = searchInput;
    }
}
