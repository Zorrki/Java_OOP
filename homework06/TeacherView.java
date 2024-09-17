package view;

import model.Teacher;
import java.util.List;

// Принцип Разделения Интерфейсов (ISP) и Принцип Инверсии Зависимостей (DIP): Класс TeacherView реализует интерфейс UserView для преподавателей.
public class TeacherView implements UserView<Teacher> {
    @Override
    public void sendOnConsole(List<Teacher> list) {
        for (Teacher teacher : list) {
            System.out.println(teacher);
        }
    }
}