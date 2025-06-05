package com.zsgs.readbase.repository.dto;

public class ReturnDetails {
    private String returnId;
    private String borrowRecordId;
    private Long returnDate;
    private Feedback feedback;
    private double finePaid;

    public String getReturnId() {
        return returnId;
    }

    public void setReturnId(String returnId) {
        this.returnId = returnId;
    }

    public String getBorrowRecordId() {
        return borrowRecordId;
    }

    public void setBorrowRecordId(String borrowRecordId) {
        this.borrowRecordId = borrowRecordId;
    }

    public Long getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Long returnDate) {
        this.returnDate = returnDate;
    }

    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }

    public double getFinePaid() {
        return finePaid;
    }

    public void setFinePaid(double finePaid) {
        this.finePaid = finePaid;
    }
}
