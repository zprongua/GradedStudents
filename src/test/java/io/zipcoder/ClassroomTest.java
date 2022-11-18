package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ClassroomTest {

    @Test
    public void testGetAverageExamScore() {
        Double[] s1Scores = {100.0, 150.0};
        Double[] s2Scores = {225.0, 25.0};

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);

        Student[] students = {s1, s2};
        Classroom classroom = new Classroom(students);

        Double expected = 125.0;
        Double actual = classroom.getAverageExamScore();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAddStudent() {
        int maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student("Leon", "Hunter", examScores);
        classroom.addStudent(student);
        String exp = Arrays.toString(classroom.getStudents());
        String act = "[" + student + "]";
        Assert.assertEquals(exp, act);
    }

    @Test
    public void testRemoveStudent() {
        Double[] s1Scores = {100.0, 150.0};
        Double[] s2Scores = {225.0, 25.0};

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);

        Student[] students = {s1, s2};
        Classroom classroom = new Classroom(students);

        classroom.removeStudent("student", "one");
        String exp = Arrays.toString(classroom.getStudents());
        String act = "[" + s2 + "]";
        Assert.assertEquals(exp, act);
    }

    @Test
    public void testGetStudentsByScore() {
        Double[] s1Scores = {100.1, 150.0};
        Double[] s2Scores = {225.0, 25.0};
        Double[] s3Scores = {125.5, 125.0};

        Student s1 = new Student("Gamma", "Zulu", s1Scores);
        Student s2 = new Student("Bravo", "Yankee", s2Scores);
        Student s3 = new Student("Alpha", "Kilo", s3Scores);

        Student[] students = {s1, s2, s3};
        Classroom classroom = new Classroom(students);
        String exp = Arrays.toString(classroom.getStudents());

        Assert.assertNotEquals(exp, Arrays.toString(classroom.getStudentsByScore()));
    }

    @Test
    public void testGetGradeBook() {
        Double[] s1Scores = {100.0};
        Double[] s2Scores = {75.0};
        Double[] s3Scores = {65.0};
        Double[] s4Scores = {45.0};
        Double[] s5Scores = {0.0};

        Student s1 = new Student("Gamma", "Zulu", s1Scores);
        Student s2 = new Student("Bravo", "Yankee", s2Scores);
        Student s3 = new Student("Alpha", "Kilo", s3Scores);
        Student s4 = new Student("Charlie", "Papa", s4Scores);
        Student s5 = new Student("Sierra", "Tango", s5Scores);

        Student[] students = {s1, s2, s3, s4, s5};
        Classroom classroom = new Classroom(students);

        classroom.setCurve();
        classroom.getGradeBook();
        Assert.assertEquals("A", classroom.gb.get(s1));
    }
}
