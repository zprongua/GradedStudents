package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Student extends Classroom {
    String firstName;
    String lastName;
    ArrayList<Double> examScores = new ArrayList<>();

    public Student(String firstName, String lastName, Double[] ExamScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores.addAll(Arrays.asList(ExamScores));
    }

    public void addExam(Double examScore) {
        examScores.add(examScore);
    }

    public Integer getNumberOfExams() {
        return examScores.size();
    }

    public String getExamScores() {
        String str = "Exam Scores:";
        int counter = 1;
        for (Double d : examScores) {
            str += ("\n\tExam "+counter+": "+d);
            counter++;
        }
        return str;
    }

    public void setExamScore(int e, Double score) {
        examScores.set(e-1, score);
    }

    public Double getAverageExamScore() {
        Double average = 0.0;
        for (Double d : examScores) {
            average += d;
        }
        return average/examScores.size();
    }

    @Override
    public String toString() {
        return "Student: "+firstName+" "+lastName+"\nAverage Score: "+getAverageExamScore()+"\n"+getExamScores();
    }

//    public static Comparator<Student> nameComparator = Comparator.comparing(o -> o.firstName);

//    public static Comparator<Student> scoreComparator = (o1, o2) -> (int) (o2.getAverageExamScore() - o1.getAverageExamScore());
}
