/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;

/**
 *
 * @author SE150853 Nguyen Huynh Minh Khoi
 */
public class Booking {
    private String bookingID;
    private String childrenPitchID;
    private String userID;
    private Date bookingDate;
    private String timeID;
    private String timeRent;

    public Booking() {
    }

    public Booking(String bookingID, String childrenPitchID, String userID, Date bookingDate, String timeID) {
        this.bookingID = bookingID;
        this.childrenPitchID = childrenPitchID;
        this.userID = userID;
        this.bookingDate = bookingDate;
        this.timeID = timeID;
    }

    public Booking(String bookingID, String childrenPitchID, String userID, Date bookingDate, String timeID, String timeRent) {
        this.bookingID = bookingID;
        this.childrenPitchID = childrenPitchID;
        this.userID = userID;
        this.bookingDate = bookingDate;
        this.timeID = timeID;
        this.timeRent = timeRent;
    }
    

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public String getChildrenPitchID() {
        return childrenPitchID;
    }

    public void setChildrenPitchID(String childrenPitchID) {
        this.childrenPitchID = childrenPitchID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getTimeID() {
        return timeID;
    }

    public void setTimeID(String timeID) {
        this.timeID = timeID;
    }

    public String getTimeRent() {
        return timeRent;
    }

    public void setTimeRent(String timeRent) {
        this.timeRent = timeRent;
    }
    
}
