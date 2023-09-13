package org.finalexam;

import java.time.LocalDate;
public class Package {
    public Package(String targetLocation, int targetDistance, int packageValue, String deliveryDate) {
        this.targetLocation = targetLocation;
        this.targetDistance = targetDistance;
        this.packageValue = packageValue;
        this.deliveryDate = LocalDate.parse(deliveryDate);
    }

    String targetLocation;
    int targetDistance;
    int packageValue;
    LocalDate deliveryDate;
}
