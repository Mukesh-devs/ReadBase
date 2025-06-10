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
            view.userLogin();
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
                isNumeric = true;
                continue;
            }
            if ( Character.isAlphabetic(pass.charAt(i))) {
                isAlpha = true;
            }
        }
        if ( !isAlpha || !isNumeric ) {
            view.printError("Password should contains Alphanumeric characters..");
            if ( pass.length() < 8) {
                view.printError("Password must be length of 8");
                return false;
            }
            return false;
        }
        return true;
    }

    public boolean isValidMobile(String mobileNo) {
        if ( mobileNo.length() != 10) {
            view.printError("Mobile Number must in 10 digits");
            return false;
        }
        for ( int i = 0; i < mobileNo.length(); i++ ) {
            if ( Character.isAlphabetic(mobileNo.charAt(i))) {
                view.printError("Mobile Number only be numbers");
                return false;
            }
        }
        return true;
    }

    void validateLogin(String username, String password) {
        if ( ReadBaseDb.getInstance().validateLogin(username,password)) {
            view.successLogin(username);
        }
        else {
            view.invalidLogin();
        }
    }
}
