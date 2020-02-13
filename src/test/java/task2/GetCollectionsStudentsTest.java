package task2;

import lombok.Data;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

@Data
public class GetCollectionsStudentsTest {

    @Test
    public void getAllStudentsByMark() {
        GetCollectionsStudents getCollectionsStudents = new GetCollectionsStudents();
        List<TestEntityStudent> expected = getCollectionsStudents.getAllStudentsByMark(getData(), 5l);
        Assert.assertEquals(expected.size(), 2);
    }


    private static List<TestEntityStudent> getData() {
        List<TestEntityStudent> testData = new ArrayList<>();
        testData.add(TestEntityStudent.builder().name("Ivan").gender("male").mark(5l).build());
        testData.add(TestEntityStudent.builder().name("Petr").gender("male").mark(4l).build());
        testData.add(TestEntityStudent.builder().name("Oleg").gender("male").mark(4l).build());
        testData.add(TestEntityStudent.builder().name("Anna").gender("female").mark(4l).build());
        testData.add(TestEntityStudent.builder().name("Igor").gender("male").mark(5l).build());
        testData.add(TestEntityStudent.builder().name("Olga").gender("female").mark(4l).build());
        return testData;
    }
}