package service;

import model.Grade;
import model.Student;
import model.Subject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GradeBookService {

    private List<Student> students = new ArrayList<>();
    private List<Grade> grades = new ArrayList<>();

    private HashMap<String, Subject> subjects = new HashMap<>();

    private int gradeIdCounter = 1;

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addSubject(String code,
                           int studentId,
                           String name,
                           int credits) {

        if(credits <= 0){
            System.out.println("Некорректное количество кредитов");
            return;
        }

        if(findStudent(studentId) == null){
            System.out.println("Студент не найден");
            return;
        }

        Subject subject =
                new Subject(code, studentId, name,
                        "Unknown", credits);

        subjects.put(code, subject);
    }

    public void addGrade(String subjectCode,
                         String type,
                         double score) {

        if(score <= 0){
            System.out.println("Оценка должна быть больше 0");
            return;
        }

        if(!subjects.containsKey(subjectCode)){
            System.out.println("Предмет не найден");
            return;
        }

        Grade grade = new Grade(
                gradeIdCounter++,
                subjectCode,
                type,
                score,
                ""
        );

        grades.add(grade);
    }

    public double getAverage(String subjectCode){

        double sum = 0;
        int count = 0;

        for(Grade grade : grades){
            if(grade.getSubjectCode().equals(subjectCode)){
                sum += grade.getScore();
                count++;
            }
        }

        return count == 0 ? 0 : sum / count;
    }

    public double getStudentGPA(int studentId){

        List<Subject> subjectList =
                getSubjectsByStudent(studentId);

        double sum = 0;
        int count = 0;

        for(Subject subject : subjectList){

            double avg = getAverage(subject.getCode());

            if(avg > 0){
                sum += avg;
                count++;
            }
        }

        return count == 0 ? 0 : sum / count;
    }

    public List<Subject> getSubjectsByStudent(int studentId){

        List<Subject> result = new ArrayList<>();

        for(Subject subject : subjects.values()){
            if(subject.getStudentId() == studentId){
                result.add(subject);
            }
        }

        return result;
    }

    public List<Grade> getGradesBySubject(String subjectCode){

        List<Grade> result = new ArrayList<>();

        for(Grade grade : grades){
            if(grade.getSubjectCode().equals(subjectCode)){
                result.add(grade);
            }
        }

        return result;
    }

    public double getStudentAverage(int studentId){
        return getStudentGPA(studentId);
    }

    public List<Student> getStudentsWithGPAAbove(double gpa){

        List<Student> result = new ArrayList<>();

        for(Student student : students){
            if(getStudentGPA(student.getId()) > gpa){
                result.add(student);
            }
        }

        return result;
    }

    public Student getTopStudent(){

        Student best = null;
        double max = 0;

        for(Student student : students){

            double gpa = getStudentGPA(student.getId());

            if(gpa > max){
                max = gpa;
                best = student;
            }
        }

        return best;
    }

    private Student findStudent(int id){

        for(Student student : students){
            if(student.getId() == id){
                return student;
            }
        }

        return null;
    }
}
