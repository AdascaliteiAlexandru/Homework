package org.homework5;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        TreeSet<Person> persons = new TreeSet<>(new newComparator());
        persons.add(new Person("Irina", 25));
        persons.add(new Person("Irina", 18));
        persons.add(new Person("Andrei", 32));

        for (Person person : persons) {
            System.out.println("Person named " + person.name + " and is " + person.age + " years old");
        }

        Address address1 = new Address("Romania", "Primaverii", 22);
        Address address2 = new Address("Romania", "Tei", 29);
        List<Address> addresses = new ArrayList<>();
        addresses.add(address2);
        addresses.add(address1);

        Map<Person, List<Hobby>> map = new HashMap<Person, List<Hobby>>();
        List<Hobby> hobbies = new ArrayList<>();
        hobbies.add(new Hobby("football", 7, addresses));
        hobbies.add(new Hobby("baseball", 5, addresses));

        map.put(new Person("Ovidiu", 36), hobbies);

        Map.Entry<Person, List<Hobby>> entry = map.entrySet().iterator().next();
        Person person = entry.getKey();
        List<Hobby> hobbiess = entry.getValue();
        System.out.println("Name: " + person.name);
        System.out.println("Age: " + person.age);

        System.out.println("Hobbies: ");
        for (Hobby hobby : hobbiess)
            hobby.print();
    }
}

class newComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        if (p1.name.equals(p2.name)) {
            if (p1.age < p2.age)
                return -1;
            else if (p1.age > p2.age)
                return 1;
            else
                return 0;
        }

        return (p1.name).compareTo(p2.name);
    }
}


