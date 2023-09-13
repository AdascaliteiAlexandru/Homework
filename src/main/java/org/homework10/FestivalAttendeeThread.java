package org.homework10;

import java.util.List;
import java.util.Queue;
import org.homework10.Festival;

public class FestivalAttendeeThread extends Thread {
    FestivalAttendeeThread(Festival.TicketType ticketType, List<Festival.TicketType> gate) {
        start();
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Ticket validated");

        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
