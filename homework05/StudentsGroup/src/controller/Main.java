package controller;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        
        // Создание нескольких преподавателей
        controller.createTeacher("Иванов", "Иван", "Иванович");
        controller.createTeacher("Петров", "Петр", "Петрович");
        controller.createTeacher("Сидоров", "Сидор", "Сидорович");

        // Создание нескольких студентов
        controller.createStudent("Смирнов", "Петр", "Сергеевич");
        controller.createStudent("Кузнецов", "Алексей", "Алексеевич");
        controller.createStudent("Сидоров", "Александр", "Иванович");
        controller.createStudent("Орлов", "Олег", "Михайлович");
        controller.createStudent("Григорьев", "Григорий", "Григорьевич");
        controller.createStudent("Федоров", "Федор", "Федорович");
        controller.createStudent("Александров", "Александр", "Александрович");
        controller.createStudent("Николаев", "Николай", "Николаевич");

        // Формирование списка ID студентов для каждой группы
        List<Integer> group1Students = new ArrayList<>();
        group1Students.add(1);
        group1Students.add(2);

        List<Integer> group2Students = new ArrayList<>();
        group2Students.add(3);
        group2Students.add(4);

        List<Integer> group3Students = new ArrayList<>();
        group3Students.add(5);
        group3Students.add(6);

        List<Integer> group4Students = new ArrayList<>();
        group4Students.add(7);
        group4Students.add(8);

        // Формирование нескольких учебных групп
        controller.createStudentGroup(1, group1Students);
        controller.createStudentGroup(2, group2Students);
        controller.createStudentGroup(3, group3Students);
        controller.createStudentGroup(1, group4Students);

        // Вывод всех созданных групп на консоль
        System.out.println("All Student Groups:");
        controller.printAllStudentGroups();
    }
}