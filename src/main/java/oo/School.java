package oo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class School {
    private final Set<Person> teachersAndStudents = new HashSet<>();

    public School() {

    }

    public void attach(final Person person) {
        teachersAndStudents.add(person);
    }

    public void startSchool() {
        teachersAndStudents.forEach(person -> {
            String introduceInfo = person.introduce();
            System.out.println(introduceInfo);
        });
    }
}
