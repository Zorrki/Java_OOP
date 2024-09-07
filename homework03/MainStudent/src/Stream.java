import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Stream implements Iterable<StudentGroup> {
    private List<StudentGroup> listStudentGroup;

    public List<StudentGroup> getListStudentGroup() {
        return listStudentGroup;
    }

    public void setListStudentGroup(List<StudentGroup> listStudentGroup) {
        this.listStudentGroup = listStudentGroup;
    }

    public Stream(List<StudentGroup> studentsStreame) {
        this.listStudentGroup = studentsStreame;
    }

    public Stream() {
        this.listStudentGroup = new ArrayList<>();
    }

    @Override
    public Iterator<StudentGroup> iterator() {
        return new Iterator<StudentGroup>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < listStudentGroup.size();
            }

            @Override
            public StudentGroup next() {
                return listStudentGroup.get(index++);
            }
        };
    }
}