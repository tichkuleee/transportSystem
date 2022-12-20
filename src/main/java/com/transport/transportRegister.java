package com.transport;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class transportRegister {
    public static String vhID,vhType,vhGear,cusName,cusEmail;
    public static int vhMilage, cusID, rentHrs;
    public static float rentRate;
    public static Long cusLic, cusPhone;
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        //Create Session Factory
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        regVehicle(sessionFactory);


        //typeOfVechicle (Bus, Truck, Taxi etc), vehicleId, milageOfVehicle,
        // custId, custName, mob, email, drivingLisence, durationOfRent

    }
    public static void regVehicle(SessionFactory sessionFactory) {
        Session newSession = sessionFactory.openSession();
        Transaction tr1 = null;
        Scanner newScan = new Scanner(System.in);
        VehicleSystem obj = new VehicleSystem();
      /*  VehicleSystem v1;
        v1 = new VehicleSystem();
        String vhID = "";
        String vhType = null;
        int vhMilage = 0;
        String vhGear = null;
        int cusID = 0; */
        System.out.println("Please enter the vehicle ID: ");
        vhID = newScan.next();
        obj.setVehicleId(vhID);
        System.out.println("Please enter the vehicle type: ");
        vhType = newScan.next();
        obj.setTypeOfVehicle(vhType);
        System.out.println("Please enter the vehicle milage: ");
        vhMilage = newScan.nextInt();
        obj.setMilageOfVehicle(vhMilage);
        System.out.println("Please enter the customer ID: ");
        cusID = newScan.nextInt();
        obj.setCustId(cusID);

        if (vhID.equalsIgnoreCase("B01")
                || vhID.equalsIgnoreCase("T01")) {
            vhGear = "Manual";
            obj.setGearType(vhGear);
        } else {
            vhGear = "Automatic";
            obj.setGearType(vhGear);
        }

        if (vhID.equalsIgnoreCase("B01") && vhType.equalsIgnoreCase("bus")
                || vhID.equalsIgnoreCase("T01") && vhType.equalsIgnoreCase("truck")
                || vhID.equalsIgnoreCase("TX01") && vhType.equalsIgnoreCase("taxi")
                || vhID.equalsIgnoreCase("SC01") && vhType.equalsIgnoreCase("scooty")
                || vhID.equalsIgnoreCase("BK01") && vhType.equalsIgnoreCase("bike")) {
            System.out.println("Validation Successful!!! Processing Data...");
            regCustomer(sessionFactory);
            try {
                obj = new VehicleSystem(vhID, vhType, vhMilage, vhGear,cusID);
                tr1 = newSession.beginTransaction();
                newSession.save(obj);
                tr1.commit();
            } catch (Exception e) {
                System.err.println("Error Message ::" + e.getMessage());
                if (tr1 != null) {
                    tr1.rollback();
                }
            } finally {
                if (newSession != null) {
                    newSession.close();
                }
            }

        } else {
            System.out.println("Vehicle not validated. Please try again...");
        }
    }//regVehicle Close

    public static void regCustomer(SessionFactory sessionFactory){
        Session newSession1 = sessionFactory.openSession();
        Transaction tr2 = null;
        Scanner scan = new Scanner(System.in);
        CustomerSystem obj1 = new CustomerSystem();
        System.out.println("Please enter Customer's name: ");
        cusName = scan.next();
        obj1.setCustName(cusName);
        System.out.println("Please enter Customer's Mobile Number: ");
        cusPhone = scan.nextLong();
        obj1.setMob(cusPhone);
        System.out.println("Please enter Customer's Email: ");
        cusEmail = scan.next();
        obj1.setEmail(cusEmail);
        System.out.println("Please enter Customer's License Number: ");
        cusLic = scan.nextLong();
        obj1.setDrivingLicense(cusLic);
        System.out.println("Please enter the rental time in hours: ");
        rentHrs = scan.nextInt();
        obj1.setDurationForRent(rentHrs);
        obj1.setCustId(cusID);

        //Assigning rates for vehicle
        switch (vhID){
            case "B01":
                rentRate = 100;
                obj1.setRate(rentRate);
                break;
            case "T01":
                rentRate = 150;
                obj1.setRate(rentRate);
                break;
            case "TX01":
                rentRate = 60;
                obj1.setRate(rentRate);
                break;
            case "SC01":
                rentRate = 30;
                obj1.setRate(rentRate);
                break;
            case "BK01":
                rentRate = 40;
                obj1.setRate(rentRate);
                break;
        }


        try {
            obj1 = new CustomerSystem(cusID, cusName, cusPhone,cusEmail,cusLic,rentHrs,rentRate);
            tr2 = newSession1.beginTransaction();
            newSession1.save(obj1);
            tr2.commit();
        } catch (Exception e) {
            System.err.println("Error Message ::" + e.getMessage());
            if (tr2 != null) {
                tr2.rollback();
            }
        } finally {
            if (newSession1 != null) {
                newSession1.close();
            }
        }



    }//regCustomer close

}
