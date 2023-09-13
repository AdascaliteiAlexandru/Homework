package org.homework3;

public class CKlasse extends Mercedes {
    public CKlasse(float availableFuel, String chassisNumber) {
        setAvailableFuel(availableFuel);
        setChassisNumber(chassisNumber);
    }
    @Override
    public void start() {
        System.out.println("The car named CKlasse has been started");
    }

    @Override
    public void stop() {
        System.out.println("The car named CKlasse has been stopped");
    }
}
