package Bai7;

public class Student {
    private String id;
    private String name;
    private String email;
    private double gpa;

    public Student() {
    }

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student(Student other) {
        this.id = other.id;
        this.name = other.name;
        this.email = other.email;
        this.gpa = other.gpa;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public double getGpa() {
        return gpa;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGpa(double gpa) {
        if (gpa >= 0.0 && gpa <= 10.0) {
            this.gpa = gpa;
        } else {
            System.out.println("GPA khong hop le!");
        }
    }

    public void display() {
        System.out.println(id + " " + name + " " + email + " " + gpa);
    }
}

