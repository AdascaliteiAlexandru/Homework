package org.finalexam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DeliverySystem {
    public static void main(String[] args) {
        List<Package> packages = new ArrayList<>();
        packages.add(new Package("Apahida", 15, 100, "2017-09-01"));
        packages.add(new Package("Apahida", 15, 110, "2017-09-01"));
        packages.add(new Package("Apahida", 15, 130, "2017-09-02"));
        packages.add(new Package("Apahida", 15, 120, "2017-09-02"));
        Map<String, Map<LocalDate, List<Package>>> group = packages.stream().collect(Collectors.groupingBy(p -> p.targetLocation, Collectors.groupingBy(d -> d.deliveryDate)));
        group.forEach((k, v) -> System.out.println(k + v));
    }
}
