package com.transport;

import javax.persistence.GeneratedValue;

public class VehicleSystem {
    @GeneratedValue
    private String vehicleId;
    private String typeOfVehicle;
    private int milageOfVehicle;
    private String gearType;
    private int custId;

    public VehicleSystem() {

    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getTypeOfVehicle() {
        return typeOfVehicle;
    }

    public void setTypeOfVehicle(String typeOfVehicle) {
        this.typeOfVehicle = typeOfVehicle;
    }

    public int getMilageOfVehicle() {
        return milageOfVehicle;
    }

    public void setMilageOfVehicle(int milageOfVehicle) {
        this.milageOfVehicle = milageOfVehicle;
    }

    public String getGearType() {
        return gearType;
    }

    public void setGearType(String gearType) {
        this.gearType = gearType;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }



    //Constructor for vehicle

    public VehicleSystem(String vehicleId, String typeOfVehicle, int milageOfVehicle, String gearType, int custId) {
        this.vehicleId = vehicleId;
        this.typeOfVehicle = typeOfVehicle;
        this.milageOfVehicle = milageOfVehicle;
        this.gearType = gearType;
        this.custId = custId;
    }

    //Constructor for Customer


}
