package com.transport;

public class CustomerSystem {
    private int custId;
    private String custName;
    private long mob;
    private String email;
    private long drivingLicense;
    private int durationForRent;
    private float rate;

    public CustomerSystem() {

    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public long getMob() {
        return mob;
    }

    public void setMob(long mob) {
        this.mob = mob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getDrivingLicense() {
        return drivingLicense;
    }

    public void setDrivingLicense(long drivingLicense) {
        this.drivingLicense = drivingLicense;
    }

    public int getDurationForRent() {
        return durationForRent;
    }

    public void setDurationForRent(int durationForRent) {
        this.durationForRent = durationForRent;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public CustomerSystem(int custId, String custName, long mob, String email, long drivingLicense, int durationForRent, float rate) {
        this.custId = custId;
        this.custName = custName;
        this.mob = mob;
        this.email = email;
        this.drivingLicense = drivingLicense;
        this.durationForRent = durationForRent;
        this.rate = rate;
    }
}
