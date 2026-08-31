package com.smartparking.model;

public class ParkingSlot {

    private int slotId;
    private String slotNumber;
    private String slotType;
    private String status;


    public ParkingSlot() {
    }


    public ParkingSlot(int slotId, String slotNumber, String slotType, String status) {
        this.slotId = slotId;
        this.slotNumber = slotNumber;
        this.slotType = slotType;
        this.status = status;
    }


    public int getSlotId() {
        return slotId;
    }


    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }


    public String getSlotNumber() {
        return slotNumber;
    }


    public void setSlotNumber(String slotNumber) {
        this.slotNumber = slotNumber;
    }


    public String getSlotType() {
        return slotType;
    }


    public void setSlotType(String slotType) {
        this.slotType = slotType;
    }


    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status;
    }

}