package com.zsgs.readbase.features.registration;

import com.zsgs.readbase.repository.db.ReadBaseDb;
import com.zsgs.readbase.repository.dto.RegistrationInfo;

public class RegistrationModel {

    private final RegistrationView view;

    public RegistrationModel(RegistrationView registrationView) {
        view = registrationView;
    }

    public void init() {
        if (ReadBaseDb.getInstance().getRegistrationInfo() != null) {
//            view.proceedLogin();
            System.out.println("wait");
        }
        else {
            view.proceedRegistration();
        }
    }
    void registerUser(RegistrationInfo registrationInfo) {
        if ( ifUserExists(registrationInfo.getFirstname())) {
            view.printError("User Already Exixts");
            view.printError("TryAgain..");
            view.proceedRegistration();
        }
        else {
            System.out.println("Registered Successfully");
            ReadBaseDb.getInstance().setRegistrationInfo(registrationInfo);
        }
    }

    private boolean ifUserExists(String firstname) {
        return false;
    }

    boolean isPasswordValid(String pass) {
        boolean isNumeric = false;
        boolean isAlpha = false;
        for (int i = 0; i < pass.length(); i++ ) {
            if ( Character.isDigit(pass.charAt(i))) {
                isAlpha = true;
            }
            if ( Character.isAlphabetic(pass.charAt(i))) {
                isNumeric = true;
            }
        }
        if ( !isAlpha || !isNumeric ) {
            view.printError("Password should contains Alphanumeric characters..");
            return false;
        } else if ( pass.length() < 8) {
            view.printError("Password must be length of 8");
            return false;
        }
        return true;
    }

}
