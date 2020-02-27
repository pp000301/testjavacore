package task2;

import java.util.List;
import java.util.stream.Collectors;

public class GetCollectionsStudents {

    //The method returns a list of students by grade
    public List<TestEntityStudent> getAllStudentsByMark(List<TestEntityStudent> ListStudents, Long mark){
        return ListStudents.stream().filter(x->x.getMark().equals(mark)).collect(Collectors.toList());
    }
}
