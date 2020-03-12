package by.bsuir.lab1.model;

public class Student {

    private Long id;
    private String firstName;
    private String secondName;
    private int course;
    private String faculty;

    public Long getId() {
        return id;
    }

    public Student setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Student setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getSecondName() {
        return secondName;
    }

    public Student setSecondName(String secondName) {
        this.secondName = secondName;
        return this;
    }

    public int getCourse() {
        return course;
    }

    public Student setCourse(int course) {
        this.course = course;
        return this;
    }

    public String getFaculty() {
        return faculty;
    }

    public Student setFaculty(String faculty) {
        this.faculty = faculty;
        return this;
    }
}
