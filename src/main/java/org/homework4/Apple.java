package org.homework4;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Apple implements Phone{
    Apple() {
        this.currBattery = battery;
        this.color = "white";
        this.material = "premium";
        long left = 100000000000000L;
        long right = 999999999999999L;
        this.IMEI = left + (long)(Math.random() * (right - left));
    }
    final int battery = 100;
    private int currBattery;
    private String color;
    private String material;
    private long IMEI;
    private Map<String, String> contacts = new HashMap<>();
    private Map<String, List<String>> messages = new HashMap<>();
    private Map<String, List<String>> calls = new HashMap<>();

    public boolean maxLimit(String message) {
        return message.length() <= 100;
    }

    @Override
    public void createContact(String number, String firstName, String lastName) {
        contacts.put(number, new String(firstName + " " + lastName));
    }

    @Override
    public void seeContacts() {
        for (String key : contacts.keySet()) {
            System.out.println("Number: " + key);
            System.out.println("Full name: " + contacts.get(key));
        }
    }

    @Override
    public void sendMessage(String number, String message) {
        if (message.length() > 100) {
            System.out.println("The message exceeds the limit of 100 characters");
            return;
        } else if (currBattery == 0) {
            System.out.println("It's an iPhone, of course it doesn't have battery.");
            return;
        }

        List<String> list = messages.get(number);
        if (list == null) {
            list = new ArrayList<>();
            messages.put(number, list);
        }
        messages.get(number).add(message);
        System.out.println("SENT");
        --currBattery;
    }

    @Override
    public void seeMessages() {
        if (!messages.isEmpty())
            for (Map.Entry<String, List<String>> e : messages.entrySet())
                for (String e1 : e.getValue())
                    System.out.println("You send a message to '" + contacts.get(e.getKey()) + "' with content '" + e1 + "'");
    }

    @Override
    public void call(String number) {
        if (currBattery == 0) {
            System.out.println("Battery low");
            return;
        }

        List<String> list = calls.get(number);
        if (list == null) {
            list = new ArrayList<>();
            calls.put(number, list);
        }
        calls.get(number).add(LocalTime.now().toString());
        System.out.println("CALL ENDED");
        currBattery -= 2;
    }

    @Override
    public void seeCalls() {
        for (Map.Entry<String, List<String>> e : calls.entrySet())
            for (String e1 : e.getValue())
                System.out.println("You called'" + contacts.get(e.getKey()) + "' at " + e1);

    }
}
