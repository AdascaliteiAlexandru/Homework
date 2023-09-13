package org.homework10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FestivalStatisticsThread extends Thread{
    List<Festival.TicketType> gate;
    FestivalStatisticsThread(List<Festival.TicketType> gate) throws InterruptedException {
        this.gate = new ArrayList<>(gate);
        start();
        join(1000);
    }

    @Override
    public void run() {
        System.out.println(gate.size() + " people entered");
        System.out.println(Collections.frequency(gate, Festival.TicketType.FULL) + " have full tickets");
        System.out.println(Collections.frequency(gate, Festival.TicketType.FREE_PASS) + " have free passes");
        System.out.println(Collections.frequency(gate, Festival.TicketType.FULL_VIP) + " have full VIP passes");
        System.out.println(Collections.frequency(gate, Festival.TicketType.ONE_DAY) + " have one-day passes");
        System.out.println(Collections.frequency(gate, Festival.TicketType.ONE_DAY_VIP) + " have one-day VIP passes");
        System.out.println(Thread.currentThread().getName() + " Statistics generated");
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
