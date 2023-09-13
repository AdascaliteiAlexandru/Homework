package org.homework3;

public class Main {
    public static void main(String[] args) {
        Car car = new VWPassat(27, "oiqe0934");
        car.start();
        //car.setAvailableFuel(0); for testing
        car.shiftGear(1);
        car.drive(0.01);
        car.shiftGear(2);
        car.drive(0.02);
        car.shiftGear(3);
        car.drive(0.5);
        car.shiftGear(4);
        car.drive(0.5);
        car.shiftGear(4);
        car.drive(0.5);
        car.shiftGear(5);
        car.drive(10);
        car.shiftGear(4);
        car.drive(0.5);
        car.shiftGear(3);
        car.drive(0.1);
        car.stop();

        Vehicle vehicle = new VWGolf(30, "1987ddkshik289");
        vehicle.start();
        vehicle.drive(1);
        vehicle.stop();
    }
}
