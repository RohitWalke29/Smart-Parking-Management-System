package com.smartparking.model;

import java.sql.Date;
import java.sql.Timestamp;

public class Booking {

    private int bookingId;
    private int userId;
    private int vehicleId;
    private int slotId;
    private Date bookingDate;
    private Timestamp startTime;
    private Timestamp endTime;
    private String status;

    public Booking() {
    }

    public Booking(int bookingId, int userId, int vehicleId, int slotId,
                   Date bookingDate, Timestamp startTime,
                   Timestamp endTime, String status) {

        this.bookingId = bookingId;
        this.userId = userId;
        this.vehicleId = vehicleId;
        this.slotId = slotId;
        this.bookingDate = bookingDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}