package oo;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Teacher extends Person {
    private final Set<Klass> klasses = new HashSet<>();

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    @Override
    public String introduce() {
        String classNumberString = klasses.stream()
                .map(Klass::getNumber)
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        return super.introduce() + String.format(" I am a teacher. I teach Class %s.", classNumberString);
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
