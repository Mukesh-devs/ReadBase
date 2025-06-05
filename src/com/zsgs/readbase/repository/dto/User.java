package com.zsgs.readbase.repository.dto;

import java.util.List;

public class User {

    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String mobileNumber;
    private String address;
    private String dob;
    private List<BorrowRecord> borrowBooks;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public List<BorrowRecord> getBorrowBooks() {
        return borrowBooks;
    }

    public void setBorrowBooks(List<BorrowRecord> borrowBooks) {
        this.borrowBooks = borrowBooks;
    }
}
