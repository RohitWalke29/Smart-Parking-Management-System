package com.smartparking.model;


public class Vehicle {


    private int vehicleId;
    private int userId;
    private String vehicleNumber;
    private String vehicleType;
    private String vehicleModel;



    public Vehicle() {

    }



    public Vehicle(int vehicleId, int userId, String vehicleNumber, 
                   String vehicleType, String vehicleModel) {

        this.vehicleId = vehicleId;
        this.userId = userId;
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.vehicleModel = vehicleModel;

    }



    public int getVehicleId() {
        return vehicleId;
    }


    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }



    public int getUserId() {
        return userId;
    }


    public void setUserId(int userId) {
        this.userId = userId;
    }



    public String getVehicleNumber() {
        return vehicleNumber;
    }


    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }



    public String getVehicleType() {
        return vehicleType;
    }


    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }



    public String getVehicleModel() {
        return vehicleModel;
    }


    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }


}