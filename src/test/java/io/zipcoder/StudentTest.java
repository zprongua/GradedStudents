package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

public class StudentTest {
    String firstName = "Charlie";
    String lastName = "Day";
    Double[] examScores = {100.0, 95.0, 123.0, 96.0};
    Student student1 = new Student(firstName, lastName, examScores);

    @Test
    public void testGetExamScores() {
        String expected = "Exam Scores:\n\tExam 1: 100.0\n\tExam 2: 95.0\n\tExam 3: 123.0\n\tExam 4: 96.0";
        String actual = student1.getExamScores();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetNumberOfExams() {
        Integer exp = student1.getNumberOfExams()+1;
        student1.addExam(42.0);
        Integer act = student1.getNumberOfExams();
        Assert.assertEquals(exp, act);
    }

    @Test
    public void testSetExamScore() {

    }

    @Test
    public void testGetAverageScore() {
        Double expected = 103.5;
        Double actual = student1.getAverageExamScore();
        student1.setExamScore(2, 100.0);
        Double exp = 104.75;
        Double act = student1.getAverageExamScore();

        Assert.assertEquals(exp, act);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testToString() {
        String actual = student1.toString();
        String expected = "Student: Charlie Day\nAverage Score: 103.5\nExam Scores:\n\tExam 1: 100.0\n\tExam 2: 95.0\n\tExam 3: 123.0\n\tExam 4: 96.0";

        Assert.assertEquals(expected, actual);
    }
}