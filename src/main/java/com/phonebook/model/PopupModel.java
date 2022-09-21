package com.phonebook.model;

public class PopupModel {
    private static String selectedName;
    private static String selectedPhoneNumber;

    public static String getSelectedName() {
        return selectedName;
    }

    public static void setSelectedName(String selectedName) {
        PopupModel.selectedName = selectedName;
    }

    public static String getSelectedPhoneNumber() {
        return selectedPhoneNumber;
    }

    public static void setSelectedPhoneNumber(String selectedPhoneNumber) {
        PopupModel.selectedPhoneNumber = selectedPhoneNumber;
    }
}
