package org.homework8;

import java.lang.String;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainReader {
    public static List<Athlete> finalStandings(File inFile) throws IOException{
        BufferedReader in = null;
        List<Athlete> athletes = new ArrayList<Athlete>();

        try {
            in = new BufferedReader(new FileReader(inFile));
            String line;

            while ((line = in.readLine()) != null) {
                String[] info = new String[100];
                info = line.split(",");
                athletes.add(new Athlete(info[1], info[3], info[4] + info[5] + info[6]));
            }
        } finally {
            if (in != null)
                in.close();
        }

        Collections.sort(athletes, new TimeComparator());
        System.out.print("Winner - ");
        Athlete.printInfo(athletes.get(0));

        System.out.print("Runner-up - ");
        Athlete.printInfo(athletes.get(1));

        System.out.print("Third Place - ");
        Athlete.printInfo(athletes.get(2));
        return athletes;
    }
}

class TimeComparator implements Comparator<Athlete> {
    @Override
    public int compare(Athlete a1, Athlete a2) {
        if (a1.timeResult + a1.missPenalty == a2.timeResult + a2.missPenalty)
            return 0;
        else if (a1.timeResult + a1.missPenalty > a2.timeResult + a2.missPenalty)
            return 1;
        else
            return -1;
    }
}
