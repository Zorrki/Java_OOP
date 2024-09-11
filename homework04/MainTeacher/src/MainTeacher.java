package homework04.MainTeacher.src;

import java.util.ArrayList;
import java.util.List;

public class MainTeacher {
    public static void main(String[] args) {
        // Создаем начальные данные
        List<Teacher> initialTeachers = new ArrayList<>();
        initialTeachers.add(new Teacher(1, "Иванов", "Иван", "Иванович"));
        initialTeachers.add(new Teacher(2, "Петров", "Петр", "Петрович"));
        initialTeachers.add(new Teacher(3, "Смирнов", "Алексей", "Алексеевич"));
        initialTeachers.add(new Teacher(4, "Сидоров", "Сергей", "Сергеевич"));
        initialTeachers.add(new Teacher(5, "Кузнецов", "Дмитрий", "Дмитриевич"));
        initialTeachers.add(new Teacher(6, "Воробьев", "Александр", "Александрович"));
        
        // Создаем контроллер и инициализируем список учителей
        TeacherController teacherController = new TeacherController();
        teacherController.initTeacherList(initialTeachers);

        // Добавляем нового учителя
        teacherController.create("Попов", "Виктор", "Викторович");

        // Изменяем данные существующего учителя
        teacherController.editTeacher(2, "Петров", "Алексей", "Петрович");
        
        // Выводим всех учителей на консоль
        teacherController.printTeachers();
    }
}
