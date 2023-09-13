package org.homework5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hobby {
    Hobby(String name, int frequency, List<Address> addresses) {
        this.name = name;
        this.frequency = frequency;
        this.addresses = new ArrayList<Address>(addresses);
    }
    String name;
    int frequency;
    List<Address> addresses;

    public void print() {
        System.out.println("--------------");
        System.out.println(this.name + " with frequency " + this.frequency + " on the following addresses: ");

        for (Address address : addresses)
            System.out.println("Country: " + address.country + " Street: " + address.street + " Number: " + address.number);
    }
}
