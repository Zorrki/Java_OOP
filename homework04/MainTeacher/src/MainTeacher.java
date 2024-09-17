import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Teacher;

public class MainTeacher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TeacherController teacherController = new TeacherController();
        
        // Инициализируем список начальными данными
        List<Teacher> initialTeachers = new ArrayList<>();
        initialTeachers.add(new Teacher(1, "Иванов", "Иван", "Иванович"));
        initialTeachers.add(new Teacher(2, "Петров", "Петр", "Петрович"));
        initialTeachers.add(new Teacher(3, "Смирнов", "Алексей", "Алексеевич"));
        initialTeachers.add(new Teacher(4, "Сидоров", "Сергей", "Сергеевич"));
        initialTeachers.add(new Teacher(5, "Кузнецов", "Дмитрий", "Дмитриевич"));
        initialTeachers.add(new Teacher(6, "Воробьев", "Александр", "Александрович"));
        teacherController.initTeacherList(initialTeachers);

        while (true) {
            System.out.println("\nВыберите действие:");
            System.out.println("1. Создать учителя");
            System.out.println("2. Редактировать учителя");
            System.out.println("3. Удалить учителя");
            System.out.println("4. Показать всех учителей");
            System.out.println("5. Выйти");
            System.out.print("Ваш выбор: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    createTeacher(scanner, teacherController);
                    break;
                case 2:
                    editTeacher(scanner, teacherController);
                    break;
                case 3:
                    deleteTeacher(scanner, teacherController);
                    break;
                case 4:
                    teacherController.printTeachers();
                    break;
                case 5:
                    System.out.println("Выход");
                    scanner.close();
                    return;
                default:
                    System.out.println("Неверный выбор, попробуйте снова.");
            }
        }
    }

    private static void createTeacher(Scanner scanner, TeacherController teacherController) {
        System.out.println("\nВведите данные учителя или 'отмена' для возврата в основное меню.");
        
        System.out.print("Введите фамилию: ");
        String surname = scanner.nextLine();
        if (surname.equalsIgnoreCase("отмена")) return;

        System.out.print("Введите имя: ");
        String firstname = scanner.nextLine();
        if (firstname.equalsIgnoreCase("отмена")) return;

        System.out.print("Введите отчество: ");
        String patronymic = scanner.nextLine();
        if (patronymic.equalsIgnoreCase("отмена")) return;

        teacherController.create(surname, firstname, patronymic);
        System.out.println("Учитель создан.");
    }

    private static void editTeacher(Scanner scanner, TeacherController teacherController) {
        System.out.println("\nВведите данные для редактирования учителя или 'отмена' для возврата в основное меню.");

        System.out.print("Введите ID учителя: ");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("отмена")) return;
        int id = Integer.parseInt(input);

        System.out.print("Введите фамилию: ");
        String surname = scanner.nextLine();
        if (surname.equalsIgnoreCase("отмена")) return;

        System.out.print("Введите имя: ");
        String firstname = scanner.nextLine();
        if (firstname.equalsIgnoreCase("отмена")) return;

        System.out.print("Введите отчество: ");
        String patronymic = scanner.nextLine();
        if (patronymic.equalsIgnoreCase("отмена")) return;

        teacherController.editTeacher(id, surname, firstname, patronymic);
        System.out.println("Учитель отредактирован.");
    }

    private static void deleteTeacher(Scanner scanner, TeacherController teacherController) {
        System.out.println("\nВведите ID учителя для удаления или 'отмена' для возврата в основное меню.");
        
        System.out.print("Введите ID учителя: ");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("отмена")) return;
        int id = Integer.parseInt(input);

        teacherController.deleteTeacher(id);
        System.out.println("Учитель удален.");
    }
}