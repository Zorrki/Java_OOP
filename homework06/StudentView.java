package view;

import model.Student;
import java.util.List;

// Принцип Разделения Интерфейсов (ISP) и Принцип Инверсии Зависимостей (DIP): Класс StudentView реализует интерфейс UserView для студентов.
public class StudentView implements UserView<Student> {
    @Override
    public void sendOnConsole(List<Student> list) {
        for (Student student : list) {
            System.out.println(student);
        }
    }
}