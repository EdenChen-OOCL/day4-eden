package oo;


import java.util.Objects;

public class Student extends Person {

    public static final String STUDENT_ROLE = "student";
    public Klass kclass;

    public Student(int id, String name, int age) {
        super(id, name, age, STUDENT_ROLE);
    }

    @Override
    public String introduce() {
        String introduceString = super.introduce() + String.format(" I am a %s.", STUDENT_ROLE);
        if(Objects.isNull(kclass)) {
            return introduceString;
        }
        String classIntroduceString = kclass.isLeader(this) ? " I am the leader of class %d." : " I am in class %d.";
        return introduceString + String.format(classIntroduceString, kclass.getNumber());
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
