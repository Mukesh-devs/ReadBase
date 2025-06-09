package com.zsgs.readbase.features.registration;

import com.zsgs.readbase.repository.db.ReadBaseDb;
import com.zsgs.readbase.repository.dto.RegistrationInfo;
import com.zsgs.readbase.util.Util;

import java.util.Scanner;

public class RegistrationView extends Util {

    private final RegistrationModel model;
    Scanner scanner = new Scanner(System.in);
    public RegistrationView() {
        model = new RegistrationModel(this);
    }

    public void init() {
        model.init();
        System.out.println("Registration View " + model);
    }

    void proceedRegistration() {
        System.out.println("Welcome to the Registration... ");
        RegistrationInfo registrationInfo = new RegistrationInfo();
        registrationInfo.setFirstname(getFirstName());
        registrationInfo.setLastname(getLastName());
        registrationInfo.setUserName(getUserName());
        registrationInfo.setEmailId(getEmailId());
        registrationInfo.setPassword(getPassword());
        registrationInfo.setConfirmPassword(getConfirmPassword(registrationInfo));
        registrationInfo.setMobileNo(getMobileNo());
        ReadBaseDb.getInstance().setRegistrationInfo(registrationInfo);
        model.registerUser(registrationInfo);
    }

    private String getMobileNo() {
        System.out.println("Enter the MobileNo : ");
        return scanner.nextLine();
    }

    private String getUserName() {

        System.out.println("Enter the UserName : ");
        return scanner.nextLine();
    }

    private String getEmailId() {
        System.out.println("Enter the EmailId : ");
        return scanner.nextLine();
    }

    private String getConfirmPassword(RegistrationInfo registrationInfo) {
        String confirmPassword;
        do {
            System.out.println("Enter the Confirm Password : ");
            confirmPassword = scanner.nextLine();
            if (model.isPasswordValid(confirmPassword)) {
                if ( confirmPassword.equals(registrationInfo.getPassword())) {
                    return confirmPassword;
                }
            }
            else {
                printError("Password does not Match..");
            }
        }
        while (true);
    }

    private String getPassword() {
        String password;
        do {
            System.out.println("Enter the password : ");
            password = scanner.nextLine();
            if ( model.isPasswordValid(password)) {
                return password;
            }
        } while (true);
    }



    void printError(String error) {
        System.out.print("Error : " + error);
    }

    private String getLastName() {
        String lastname;
        do {
            System.out.println("Enter the LastName : ");
            lastname = scanner.nextLine();
            if ( lastname.length() >= 2 && lastname.length() <= 50) {
                return lastname;
            }
        } while (true);
    }

    private String getFirstName() {
        String firstname;
        do {
            System.out.println("Enter the FirstName : ");
            firstname = scanner.nextLine();
            if ( firstname.length() <= 50 && firstname.length() >= 2) {
                return firstname;
            }
        }
        while (true);
    }


//    public void proceedLogin() {
//        System.out.println("bye");
//    }
}
