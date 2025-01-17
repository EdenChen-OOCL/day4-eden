package oo.step7;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import oo.School;
import oo.Student;
import oo.Teacher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SchoolTest {

    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setup() {
        System.setOut(new PrintStream(outContent));
    }

    private String systemOut() {
        return outContent.toString();
    }

    @Test
    public void should_print_message_when_assign_leader_given_teacher_is_teaching_the_class() {
        Student tom = new Student(1, "Tom", 18);
        School school = new School();
        school.attach(tom);

        school.startSchool();

        assertThat(systemOut()).contains("My name is Tom. I am 18 years old. I am a student.");
    }

    @Test
    public void should_print_message_when_assign_leader_given_another_student_is_in_the_class() {
        Teacher jerry = new Teacher(1, "Jerry", 21);
        School school = new School();
        school.attach(jerry);

        school.startSchool();

        assertThat(systemOut()).contains("My name is Jerry. I am 21 years old. I am a teacher.");
    }
}
