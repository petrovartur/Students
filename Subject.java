package model;

public class Subject {
    private String code;
    private int studentId;
    private String name;
    private String teacher;
    private int credits;

    public Subject(String code, int studentId, String name,
                   String teacher, int credits) {
        this.code = code;
        this.studentId = studentId;
        this.name = name;
        this.teacher = teacher;
        this.credits = credits;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        if(code != null && !code.isEmpty())
            this.code = code;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        if(studentId > 0)
            this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public String getTeacher() {
        return teacher;
    }

    public int getCredits() {
        return credits;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public void setCredits(int credits) {
        if(credits > 0)
            this.credits = credits;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "code='" + code + '\'' +
                ", studentId=" + studentId +
                ", name='" + name + '\'' +
                ", teacher='" + teacher + '\'' +
                ", credits=" + credits +
                '}';
    }
}
