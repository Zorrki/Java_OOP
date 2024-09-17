package model;

// Принцип Единственной Ответственности (SRP): Класс User отвечает только за представление пользователя и хранение его атрибутов.
public abstract class User {
    private String surname;
    private String firstname;
    private String patronymic;

    public User(String surname, String firstname, String patronymic) {
        this.surname = surname;
        this.firstname = firstname;
        this.patronymic = patronymic;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getSurname() {
        return surname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    @Override
    public String toString() {
        return String.format("User: %s %s %s", surname, firstname, patronymic);
    }
}