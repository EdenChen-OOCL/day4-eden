package oo;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Teacher extends Person {

    public static final String TEACHER_ROLE = "teacher";
    private final Set<Klass> klasses = new HashSet<>();

    public Teacher(int id, String name, int age) {
        super(id, name, age, TEACHER_ROLE);
    }

    @Override
    public String introduce() {
        String introduceString = super.introduce() + String.format(" I am a %s.", role);
        if (klasses.isEmpty()) {
            return introduceString;
        }
        String classNumberString = klasses.stream()
                .map(Klass::getNumber)
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        return introduceString + String.format(" I teach Class %s.", classNumberString);
    }

    public void assignTo(Klass targetClass) {
        klasses.add(targetClass);
    }

    public boolean belongsTo(Klass targetClass) {
        return klasses.contains(targetClass);
    }

    public boolean isTeaching(Student targetStudent) {
        if (Objects.isNull(targetStudent)) {
            return false;
        }
        Klass kclass = targetStudent.getKclass();
        return belongsTo(kclass);
    }
}
