package view;

import model.StudentGroup;

// Принцип Разделения Интерфейсов (ISP) и Принцип Инверсии Зависимостей (DIP): Класс StudentGroupView реализует вывод информации о группах на консоль.
public class StudentGroupView {
    public void sendOnConsole(StudentGroup studentGroup) {
        System.out.println(studentGroup);
    }
}