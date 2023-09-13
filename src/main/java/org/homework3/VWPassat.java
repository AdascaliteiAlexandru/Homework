package org.homework3;

public class VWPassat extends Volkswagen{
    public VWPassat(float availableFuel, String chassisNumber) {
        setAvailableFuel(availableFuel);
        setChassisNumber(chassisNumber);
        setCurrent_consumption(4.7);
    }

    @Override
    public void shiftGear(int current_gear) {
        if (current_gear > getCurrent_gear()) {
            double cons = getCurrent_consumption();
            setCurrent_consumption(cons - 10 * cons / 100); // consumption decreases 10% every time they shift up
        } else if (current_gear < getCurrent_gear()){
            double cons = getCurrent_consumption();
            setCurrent_consumption(cons + 5 * cons / 100);
        }
        super.shiftGear(current_gear);
    }

    @Override
    public void start() {
        System.out.println("The car named VWPassat has been started");
    }

    @Override
    public void stop() {
        System.out.println("The car named VWPassat has been stopped");
    }
}
