package com.phonebook.view;

import javax.swing.*;
import java.awt.*;

public class SearchView {
    public static JPanel searchContact = new JPanel();
    public static JTextField searchInput= new JTextField("Enter Target's FullName");
    public static JButton searchBtn = new JButton("Search");
    public void searchPage(){
        searchContact.setBounds(50, 360, 300, 40);
        searchContact.setBackground(Color.cyan);

        searchInput.setBounds(15, 10, 150, 25);
        searchBtn.setBounds(180, 10, 90, 25);

        searchContact.add(searchInput);
        searchContact.add(searchBtn);

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
