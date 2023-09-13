package org.homework9;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Year;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Student {
    Logger LOGGER = (Logger) LogManager.getLogger(Student.class);
    String id;
    String firstName;
    String lastName;
    LocalDate birthDate;
    char gender;

    public Student() {

    }
    public Student(String firstName, String lastName, String birthDate, char gender, String id) throws Exception {
        switch (validate(firstName, lastName, birthDate, gender, id)) {
            case 0:
                LOGGER.info("The student " + firstName + " " + lastName + " was added");
                break;
            case 1:
                LOGGER.error("The input is empty");
                throw new IllegalArgumentException("You forgot to enter something");
            case 2:
                LOGGER.error("Invalid input");
                throw new IllegalArgumentException("Invalid input");
        }

        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = LocalDate.parse(birthDate);
        this.gender = gender;
    }

    public int validate(String firstName, String lastName, String birthDate, char gender, String id) throws ParseException {
         if (firstName.isEmpty() || lastName.isEmpty() ||
                 birthDate == null || gender == ' ' || id.isEmpty())
            return 1;

        LocalDate birthDateTemp = LocalDate.parse(birthDate);
        int year = birthDateTemp.getYear();
        if (year < 1900 || year >= Year.now().getValue() - 18)
            return 2;

        char gender2 = Character.toUpperCase(gender);
        if (gender2 != 'M' && gender2 != 'F')
            return 2;
        return 0;
    }

    public Map<String, Student> deleteStudent(String id, Map<String, Student> students) throws Exception{
        if (students.containsKey(id)) {
            LOGGER.error("Student does not exist");
            throw new Exception("Student does not exist");
        } else
            LOGGER.info("The student " + students.get(id).firstName + " " + students.get(id).lastName + " was deleted");
        students.remove(id);
        return students;
    }

    public void allStudentsOfAgeX(long age, Map<String, Student> students) {
        for (String keys : students.keySet())
            if (ChronoUnit.YEARS.between(students.get(keys).birthDate, LocalDate.now()) == age)
                System.out.println(students.get(keys).firstName + " " + students.get(keys).lastName);

        LOGGER.info("The students of age " + age + " were listed");
    }

    public void listedByLastName(Map<String, Student> students) {
        List<Student> sortedList = new ArrayList<>();
        for (Map.Entry<String, Student> entry : students.entrySet())
            sortedList.add(entry.getValue());

        Collections.sort(sortedList, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return (s1.lastName).compareTo(s2.lastName);
            }
        });

        LOGGER.info("The students were listed in order of last name");
        for (Student s : sortedList)
            System.out.println(s.firstName + " " + s.lastName);
    }
}
