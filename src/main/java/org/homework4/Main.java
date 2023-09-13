package org.homework4;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Phone phone= new SamsungGalaxy6();
        phone.createContact("0747488147", "Ovidiu", "Marian");
        phone.createContact( "0747488148", "Marian", "David");
        phone.seeContacts();

        phone.sendMessage("0747488147", "fjiofjeriogjeiotgjeriofjeriogtjgtioerjgioergierjgierjgiejigjergjergjeriogjeriogjergjergjerogjeriogjerigjergjerigjiergnerngioerjgioergioergierjgierjgijergioeriogjerigjioerjgioerjgoierj");
        phone.sendMessage("0747488148", "just a message on a Samsung phone");

        phone.seeMessages();
        phone.call("0747488147");
        phone.seeCalls();

        Phone phone2 = new iPhone14ProMax();
        phone2.createContact("0747488150", "first name", "last name");
        phone2.createContact( "0747488151", "second first name", "second last name");
        phone2.seeContacts();

        phone2.sendMessage("0747488150", "fjiofjeriogjeiotgjeriofjeriogtjgtioerjgioergierjgierjgiejigjergjergjeriogjeriogjergjergjerogjeriogjerigjergjerigjiergnerngioerjgioergioergierjgierjgijergioeriogjerigjioerjgioerjgoierj");
        phone2.sendMessage("0747488151", "just a message on a Apple phone");

        phone2.seeMessages();
        phone2.call("0747488150");
        phone2.seeCalls();
    }
}
