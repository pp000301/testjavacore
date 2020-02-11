package task2;

import java.util.List;
import java.util.stream.Collectors;

public class GetCollectionsStudents {
    public List<TestEntityStudent> getAllStudentsByMark(List<TestEntityStudent> ListStudents, Long mark){
        return ListStudents.stream().filter(x->x.getMark()==mark).collect(Collectors.toList());
    }
}
