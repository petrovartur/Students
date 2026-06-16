package model;

public class Student {
    private int id;
    private String fullName;
    private String group;

    public Student(int id, String fullName, String group) {
        this.id = id;
        this.fullName = fullName;
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(id > 0)
            this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

  
    public String toString() {
        return "Student{" +
                "id=STD-" + id +
                ", fullName='" + fullName + '\'' +
                ", group='" + group + '\'' +
                '}';
    }
}
