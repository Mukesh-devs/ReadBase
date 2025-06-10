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
        System.out.println("Welcome to ReadBase System.");

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
    void proceedLogin() {
        String username = getUserName();
        String password = getPassword();
        model.validateLogin(username,password);
    }

    void successLogin(String username) {
        System.out.println("Login successfully..");

    }

    void invalidLogin() {
        printError("Enter correct Login Credintials..");
        proceedLogin();
    }

    private String getMobileNo() {
        String mobileNo;
        do {
            System.out.println("Enter the Mobile Number : ");
            mobileNo = scanner.nextLine();
            if ( model.isValidMobile(mobileNo)) {
                return mobileNo;
            }
        }
        while (true);
    }

    private String getUserName() {

        System.out.println("Enter the UserName : ");
        String username = scanner.nextLine();
        return username;
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
                else {
                    printError("Password does not Match..");
                }
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
        System.out.print(RED + "Error : " + error + RESET + "\n");
    }

    private String getLastName() {
        String lastname;
        do {
            System.out.println("Enter the LastName : ");
            lastname = scanner.nextLine();
            if ( lastname.length() >= 2 && lastname.length() <= 50) {
                return lastname;
            }
            printError("LastName must be in lenght of 2 to 50.");
        } while (true);
    }

    private String getFirstName() {
        String firstname;
        do {
            System.out.println(RED + "Enter the FirstName : " + RESET);
            firstname = scanner.nextLine();
            if ( firstname.length() <= 50 && firstname.length() >= 2) {
                return firstname;
            }
            printError("FirstName must be in length of 2 to 50.");
        }
        while (true);
    }
    void userLogin() {
        System.out.println("1. proceed Registration");
        System.out.println("2. proceed Login");
        System.out.println("3. Exit");
        switch (Integer.parseInt(scanner.nextLine())) {
            case 1 -> {
                System.out.println("login success");
            }
            case 2 -> {
                proceedLogin();
            }
            case 3 -> {
                System.out.println( RED + "Thankyou.." + RESET);
                System.exit(0);
            }
        }
    }

//    public void proceedLogin() {
//        System.out.println("bye");
//    }
}
