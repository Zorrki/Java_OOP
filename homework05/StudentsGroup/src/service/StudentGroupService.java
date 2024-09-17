package service;

import model.Student;
import model.Teacher;
import model.StudentGroup;

import java.util.List;
import java.util.ArrayList;

public class StudentGroupService {
    private final List<StudentGroup> studentGroups = new ArrayList<>();
    private Integer maxGroupId = 0;

    public void createStudentGroup(Teacher teacher, List<Student> studentList) {
        StudentGroup studentGroup = new StudentGroup();
        studentGroup.setGroupId(++maxGroupId);
        studentGroup.setTeacher(teacher);
        studentGroup.setStudentList(studentList);
        studentGroups.add(studentGroup);
    }

    public StudentGroup getStudentGroup() {
        if (studentGroups.isEmpty()) {
            return null;
        }
        return studentGroups.get(studentGroups.size() - 1);
    }

    public List<StudentGroup> getAllStudentGroups() {
        return studentGroups;
    }
}