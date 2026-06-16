package model;

public class Grade {
    private int id;
    private String subjectCode;
    private String type;
    private double score;
    private String comment;

    public Grade(int id, String subjectCode,
                 String type, double score, String comment) {
        this.id = id;
        this.subjectCode = subjectCode;
        this.type = type;
        this.score = score;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public String getType() {
        return type;
    }

    public double getScore() {
        return score;
    }

    public String getComment() {
        return comment;
    }

    public void setId(int id) {
        if(id > 0)
            this.id = id;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setScore(double score) {
        if(score > 0)
            this.score = score;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", subjectCode='" + subjectCode + '\'' +
                ", type='" + type + '\'' +
                ", score=" + score +
                ", comment='" + comment + '\'' +
                '}';
    }
}
