package org.homework10;

import java.util.*;

public class Festival {
    enum TicketType {
        FULL,
        FULL_VIP,
        FREE_PASS,
        ONE_DAY,
        ONE_DAY_VIP
    }

    public static void main(String[] args) throws InterruptedException{
        List<TicketType> festivalGate = new ArrayList<>();
        List<TicketType> values =
                Collections.unmodifiableList(Arrays.asList(TicketType.values()));
        int size = values.size();
        Random random = new Random();

        for (int i = 1; i <= 200; ++i) {
            TicketType ticketType = values.get(random.nextInt(size));
            FestivalAttendeeThread attendee = new FestivalAttendeeThread(ticketType, festivalGate);
            festivalGate.add(ticketType);

            if (i%5 == 0) {
                FestivalStatisticsThread stats = new FestivalStatisticsThread(festivalGate);
            }

        }
    }
}
