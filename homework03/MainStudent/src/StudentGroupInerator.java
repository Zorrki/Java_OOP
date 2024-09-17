import java.util.Iterator;
import java.util.List;

import model.StudentGroup;

public class StudentGroupInerator implements Iterator<Student> {

    private List<Student> studentsGroup;
    private int index;

    public StudentGroupInerator(StudentGroup studentsGroup) {
        this.studentsGroup = studentsGroup.getStudentGroup();
        this.index = -1;
    }

    @Override
    public boolean hasNext() {
        return index < studentsGroup.size() - 1;
    }

    @Override
    public Student next() {
        if (!hasNext()) {
            throw new IllegalStateException("No more elements");
        }
        return studentsGroup.get(++index);
    }

    @Override
    public void remove() {
        if (index < 0 || index >= studentsGroup.size()) {
            throw new IllegalStateException("Illegal state for remove function");
        }
        studentsGroup.remove(index--);
    }
}