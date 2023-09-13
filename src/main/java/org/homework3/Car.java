package org.homework3;

import java.util.Scanner;

public abstract class Car implements Vehicle {
    final double fuelTankSize = 60.0f;
    final String fuelType = "PETROL";
    final int gear = 6;
    final double consumptionPer100Km = 4.7;

    private double availableFuel;
    private double current_consumption;
    private int tireSize;
    private int current_gear;
    public String chassisNumber;

    public void consumption(double distance) {
        if (this.availableFuel <= 0) {
            System.out.println("Out of fuel");
            return;
        }
        this.availableFuel -= (current_consumption * distance) / 100;
        System.out.println("Fuel available: " + this.availableFuel);
    }

    public void setAvailableFuel(double availableFuel) {
        this.availableFuel = availableFuel;
    }
    public void setCurrent_consumption(double current_consumption) {
        this.current_consumption = current_consumption;
    }
    public void setChassisNumber(String chassisNumber) {
        this.chassisNumber = chassisNumber;
    }
    public void setTires(int tires) {
        this.tireSize = tires;
    }
    public void shiftGear(int current_gear) {
        this.current_gear = current_gear;
        System.out.println("Gear changed to " + current_gear);
    }

    public double getCurrent_consumption() {
        return current_consumption;
    }

    public int getCurrent_gear() {
        return current_gear;
    }

    @Override
    public void drive(double distance) {
        consumption(distance);
    }
}
