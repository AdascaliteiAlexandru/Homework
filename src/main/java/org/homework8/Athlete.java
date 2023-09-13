package org.homework8;

public class Athlete {
    enum Shot {
        HIT,
        MISS
    }
    String name;
    public int timeResult;
    public int missPenalty;

    Athlete(String name, String timeResult, String missPenalty) {
        this.name = name;
        this.timeResult = calculateTimeResult(timeResult);
        this.missPenalty = calculateMissPenalty(missPenalty);
    }

    public int calculateMissPenalty(String shots) {
        int res = 0;
        for (int i = 0; i < shots.length(); ++i) {
            Shot shot = (shots.charAt(i) == 'x' || shots.charAt(i) == 'X' ? Shot.HIT : Shot.MISS);
            switch (shot) {
                case MISS:
                   res += 10;
            }
        }

        return res;
    }

    public int calculateTimeResult(String time) {
        String[] aux = time.split(":");
        return Integer.parseInt(aux[0]) * 60 + Integer.parseInt(aux[1]);
    }

    public static void printInfo(Athlete a) {
        System.out.println(a.name + ' ' +
                (a.missPenalty+a.timeResult)/60 + ":" +
                (a.missPenalty+a.timeResult)%60 + " (" +
                a.timeResult/60 + ":" + a.timeResult%60 + " +" + ' ' +
                a.missPenalty + ")\n");
    }
}
