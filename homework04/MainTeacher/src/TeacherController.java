import java.util.List;

import model.Teacher;
import view.TeacherView;

public class TeacherController implements UserController<Teacher> {

    private final TeacherService teacherService = new TeacherService();
    private final TeacherView teacherView = new TeacherView();

    @Override
    public void create(String surname, String firstname, String patronymic) {
        teacherService.create(surname, firstname, patronymic);
    }

    public void editTeacher(Integer teacherId, String surname, String firstname, String patronymic) {
        teacherService.editTeacher(teacherId, surname, firstname, patronymic);
    }

    public void deleteTeacher(Integer teacherId) {
        teacherService.deleteTeacher(teacherId);
    }

    public void initTeacherList(List<Teacher> list) {
        teacherService.initData(list);
    }

    public void printTeachers() {
        teacherView.sendOnConsole(teacherService.getAll());
    }
}