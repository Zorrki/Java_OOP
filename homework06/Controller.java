package controller;

import service.DataService;
import service.StudentGroupService;
import model.Student;
import model.Teacher;
import model.StudentGroup;
import model.Type;
import view.StudentView;
import view.TeacherView;
import view.StudentGroupView;

import java.util.ArrayList;
import java.util.List;

// Принцип Единственной Ответственности (SRP): Класс Controller отвечает за управление действиями пользователя.
public class Controller {
    private final DataService dataService = new DataService();
    private final StudentGroupService studentGroupService = new StudentGroupService();
    private final StudentView studentView = new StudentView();
    private final TeacherView teacherView = new TeacherView();
    private final StudentGroupView studentGroupView = new StudentGroupView();

    public void createStudent(String surname, String firstname, String patronymic) {
        dataService.create(Type.STUDENT, surname, firstname, patronymic);
    }

    public void createTeacher(String surname, String firstname, String patronymic) {
        dataService.create(Type.TEACHER, surname, firstname, patronymic);
    }

    public void getAllStudents() {
        studentView.sendOnConsole(dataService.getAllStudents());
    }

    public void getAllTeachers() {
        teacherView.sendOnConsole(dataService.getAllTeachers());
    }

    public void createStudentGroup(Integer teacherId, List<Integer> studentIdList) {
        Teacher teacher = (Teacher) dataService.getUserById(Type.TEACHER, teacherId);
        List<Student> studentList = new ArrayList<>();
        for (Integer id: studentIdList) {
            studentList.add((Student) dataService.getUserById(Type.STUDENT, id));
        }
        studentGroupService.createStudentGroup(teacher, studentList);
    }

    public void printStudentGroup() {
        studentGroupView.sendOnConsole(studentGroupService.getStudentGroup());
    }

    public void printAllStudentGroups() {
        List<StudentGroup> studentGroups = studentGroupService.getAllStudentGroups();
        for (StudentGroup group : studentGroups) {
            studentGroupView.sendOnConsole(group);
        }
    }
}