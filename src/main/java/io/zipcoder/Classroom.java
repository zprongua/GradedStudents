package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Classroom {
    Student[] students;
    Double a;
    Double b;
    Double c;
    Double d;
    Double f;
    HashMap<Student, String> gb = new HashMap<>();

    public Classroom() {
        this.students = new Student[30];
    }

    public Classroom(int max) {
        this.students = new Student[max];
    }

    public Classroom(Student[] students) {
        this.students = students;
    }

    public Student[] getStudents() {
        return students;
    }

    public Double getAverageExamScore() {
        if (students[0]!=null) {
            Double average = 0.0;
            int count = 0;
            for (Student s : students) {
                average += s.getAverageExamScore();
                count++;
            }
            return average / count;
        }
        return 0.0;
    }

    public void addStudent(Student student) {
        for (int i=0; i<students.length; i++) {
            if (students[i]==null) {
                students[i] = student;
            }
        }
    }

    public void removeStudent(String firstName, String lastName) {
        if (students!=null) {
            ArrayList<Student> stu = new ArrayList<>(Arrays.asList(students));
            for (Student s : stu) {
                if (s.firstName.equals(firstName) && s.lastName.equals(lastName)) {
                    stu.remove(s);
                }
            }
            students = stu.toArray(new Student[0]);
        }
    }

    public Student[] getStudentsByScore() {
        sortStudentsByScores();
        return students;
    }

    public void sortStudentsByScores() {
        sortStudentsByName();
        Arrays.sort(students, Student.scoreComparator);
    }

    public void sortStudentsByName() {
        Arrays.sort(students, Student.nameComparator);
    }

    public void setCurve() {
        sortStudentsByScores();
        Double high = students[0].getAverageExamScore();
        Double low = students[students.length-1].getAverageExamScore();
        Double dif = high - low;
        a = dif*0.9 + low;
        b = dif*0.71 + low;
        c = dif*0.51 + low;
        d = dif*0.11 + low;
        f = low;
    }

    public void getGradeBook() {
        setCurve();
        sortStudentsByName();
        for (Student s : students) {
            String grade = assignGrade(s.getAverageExamScore());
            gb.put(s, grade);
//            System.out.println(s.firstName+ "\t" +gb.get(s)+"\t"+s.getAverageExamScore());
        }

    }

    public String assignGrade(Double score) {
        if (score>a) {
            return "A";
        }
        else if (score>b) {
            return "B";
        }
        else if (score>c) {
            return "C";
        }
        else if (score>d) {
            return "D";
        }
        else {return "F";}
    }
}
