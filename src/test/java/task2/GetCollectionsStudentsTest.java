package task2;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@Data
public class GetCollectionsStudentsTest {

    private List<TestEntityStudent> testData;

    @Before
    public void setUp(){
        GetCollectionsStudentsTest getCollectionsStudentsTest = new GetCollectionsStudentsTest();

        List<TestEntityStudent> testData= new ArrayList<>();
        testData.add(TestEntityStudent.builder().name("Ivan").gender("male").mark(5l).build());
        testData.add(TestEntityStudent.builder().name("Petr").gender("male").mark(4l).build());
        testData.add(TestEntityStudent.builder().name("Oleg").gender("male").mark(4l).build());
        testData.add(TestEntityStudent.builder().name("Anna").gender("female").mark(4l).build());
        testData.add(TestEntityStudent.builder().name("Igor").gender("male").mark(5l).build());
        testData.add(TestEntityStudent.builder().name("Olga").gender("female").mark(4l).build());

        getCollectionsStudentsTest.setTestData(testData);
    }

    @Test
    public void getAllStudentsByMark() {

        GetCollectionsStudents getCollectionsStudentsTest = new GetCollectionsStudents();
        List<TestEntityStudent> expected = getCollectionsStudentsTest.getAllStudentsByMark(testData,5l);
        Assert.assertEquals(2,2);

    }
}