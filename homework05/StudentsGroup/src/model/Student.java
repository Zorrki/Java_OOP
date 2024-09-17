package model;

public class Student extends User {
    private Integer studentId;

    public Student(Integer studentId, String surname, String firstname, String patronymic) {
        super(surname, firstname, patronymic);
        this.studentId = studentId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    @Override
    public String toString() {
        return String.format("Student ID: %d, Name: %s %s %s", 
                               studentId, getSurname(), getFirstname(), getPatronymic());
    }
}