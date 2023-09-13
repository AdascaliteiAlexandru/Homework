package org.homework11;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.StringJoiner;

public class Celebrated {
    private String firstName;
    private String lastName;
    private Date dateOfBirth;

    public Celebrated(String celebratedLine){
        String[] celebratedInfo = celebratedLine.split(",");
        this.firstName = celebratedInfo[0].trim();
        this.lastName = celebratedInfo[1].trim();

        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        this.dateOfBirth = new Date();
        try {
            this.dateOfBirth = formatter.parse(celebratedInfo[2].trim());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getMonthOfBirth(){
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(dateOfBirth);
        return calendar.get(Calendar.MONTH)+1;
    }

    public String adjustForWriting(){
        return this.getFirstName() + ", " + this.getLastName();
    }
}
