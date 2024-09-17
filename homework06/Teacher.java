package model;

// Принцип Открытости/Закрытости (OCP): Класс Teacher наследуется от User, не изменяя его код, а расширяя его.
public class Teacher extends User {
    private Integer teacherId;

    public Teacher(Integer teacherId, String surname, String firstname, String patronymic) {
        super(surname, firstname, patronymic);
        this.teacherId = teacherId;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    @Override
    public String toString() {
        return String.format("Teacher ID: %d, Name: %s %s %s", teacherId, getSurname(), getFirstname(), getPatronymic());
    }
}