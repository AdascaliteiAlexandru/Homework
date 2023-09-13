package org.homework9;

import java.util.HashMap;
import java.util.Map;

public class StudentTest {
    public static void main(String[] args) throws Exception {
        Map<String, Student> students = new HashMap();

        students.put("832598346", new Student("Ion", "Adascalitei", "1928-10-21", 'M', "832598346"));
        //students.put("832598316", new Student("Ion", "", "1928-10-21", 'M', "832598316"));
        //students.put("532598346", new Student("Ion", "Adascalitei", "1928-10-21", 'J', "532598346"));
        //students.put("822598346", new Student("Ion", "Adascalitei", "1899-10-21", 'F', "822598346"));
        students.put("831598346", new Student("Ion", "Alexandra", "1928-10-21", 'M', "831598346"));
        students.put("732598316", new Student("Giovanni", "Andrada", "2000-10-21", 'F', "732598346"));
        students.put("732598346", new Student("Popa", "Ana", "2000-10-21", 'F', "732598346"));
        System.out.println(students.size());
        students = new Student().deleteStudent("732598346", students);
        //students = new Student().deleteStudent("73259826", students);
        System.out.println(students.size());
        new Student().allStudentsOfAgeX(94, students);
        new Student().listedByLastName(students);
    }

}
