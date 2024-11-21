package oo;


import java.util.Objects;

public class Student extends Person {
    public Klass kclass;

    public Student(int id, String name, int age) {
        super(id, name, age);
    }

    @Override
    public String introduce() {
        return super.introduce() + String.format(" I am a student. I am in class %d.", kclass.getNumber());
    }

    public void join(Klass targetClass) {
        kclass = targetClass;
    }

    public boolean isIn(Klass targetClass) {
        return Objects.equals(kclass, targetClass);
    }

    public Klass getKclass() {
        return kclass;
    }
}
