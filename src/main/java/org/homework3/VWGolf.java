package org.homework3;

public class VWGolf extends Volkswagen {
    public VWGolf(float availableFuel, String chassisNumber) {
        setAvailableFuel(availableFuel);
        setChassisNumber(chassisNumber);
    }
    @Override
    public void start() {
        System.out.println("The vehicle named VWGolf has been started");
    }

    @Override
    public void stop() {
        System.out.println("The vehicle named VWGolf has been stopped");
    }
}