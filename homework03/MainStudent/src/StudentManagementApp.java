import java.util.ArrayList;
import java.util.List;

import controller.Controller;
import model.StudentGroup;
import service.StudentGroupService;

public class StudentManagementApp {
    public static void main(String[] args) {
        // Создаем список студентов
        Student student1 = new Student(1, "Ivanov", "Ivan", "Ivanovich");
        Student student2 = new Student(2, "Petrov", "Petr", "Petrovich");
        Student student3 = new Student(3, "Sidorov", "Sid", "Sidorovich");
        Student student4 = new Student(4, "Alexeev", "Alexey", "Alexeevich");
        Student student5 = new Student(5, "Smirnov", "Smir", "Smirnovich");

        // Создаем группы студентов
        StudentGroup group1 = new StudentGroup(101);
        group1.addStudent(student1);
        group1.addStudent(student2);

        StudentGroup group2 = new StudentGroup(102);
        group2.addStudent(student3);
        group2.addStudent(student4);
        group2.addStudent(student5);

        // Создаем сервисы групп студентов
        StudentGroupService groupService1 = new StudentGroupService(group1);
        StudentGroupService groupService2 = new StudentGroupService(group2);

        // Создаем списки потоков студентов и добавляем группы
        Stream stream1 = new Stream(List.of(group1));
        Stream stream2 = new Stream(List.of(group2, group1));

        // Создаем сервис потоков студентов
        StreamService streamService = new StreamService(new ArrayList<>(List.of(stream1, stream2)));

        // Создаем контроллер для первой группы
        Controller controller1 = new Controller(groupService1, streamService);

        // Создаем контроллер для второй группы
        Controller controller2 = new Controller(groupService2, streamService);

        // Выводим студентов до сортировки
        System.out.println("=== Before sorting by ID in Group 1 ===");
        printStudents(group1);
        System.out.println();

        System.out.println("=== Before sorting by ID in Group 2 ===");
        printStudents(group2);
        System.out.println();

        // Сортируем студентов по ID в обеих группах
        controller1.sortByStudentIdOfStudentGroup();
        controller2.sortByStudentIdOfStudentGroup();

        // Выводим студентов после сортировки
        System.out.println("=== After sorting by ID in Group 1 ===");
        printStudents(group1);
        System.out.println();

        System.out.println("=== After sorting by ID in Group 2 ===");
        printStudents(group2);
        System.out.println();

        // Удаляем студента из первой группы
        controller1.delStudent("Ivanov", "Ivan", "Ivanovich");

        // Удаляем студента из второй группы
        controller2.delStudent("Sidorov", "Sid", "Sidorovich");

        // Выводим студентов после удаления
        System.out.println("=== After deleting a student from Group 1 ===");
        printStudents(group1);
        System.out.println();

        System.out.println("=== After deleting a student from Group 2 ===");
        printStudents(group2);
        System.out.println();

        // Сортируем потоки по количеству групп
        System.out.println("=== Before sorting streams by group count ===");
        printStreams(streamService);
        System.out.println();

        controller1.sortStreamsByGroupCount();

        System.out.println("=== After sorting streams by group count ===");
        printStreams(streamService);
    }

    private static void printStudents(StudentGroup studentGroup) {
        for (Student student : studentGroup.getStudentGroup()) {
            System.out.println(student);
        }
    }

    private static void printStreams(StreamService streamService) {
        for (Stream stream : streamService.getStreams()) {
            System.out.println("Stream with " + stream.getListStudentGroup().size() + " groups:");
            for (StudentGroup group : stream) {
                System.out.println("\tGroup ID: " + group.getGroupId());
                printStudents(group);
            }
            System.out.println();
        }
    }
}