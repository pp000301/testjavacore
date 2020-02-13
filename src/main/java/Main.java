import task1.TestConditionalOperator;
import task2.GetCollectionsStudents;
import task2.TestEntityStudent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Testing block of task1
        int testNumber = getRandomNunber(1, 7);
        TestConditionalOperator testConditionalOperator = new TestConditionalOperator();
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("Test number = " + testNumber);
        System.out.println("The result of checking whether the number is 7: " + testConditionalOperator.getTrueSevev(testNumber));
        System.out.println("Day of week: " + testConditionalOperator.getDayWeek(testNumber));
        System.out.println("Determines whether the number is even: " + testConditionalOperator.getEven(testNumber));
        System.out.println("---------------------------------------------------------------------------------");
        // End testing block of task1

        List<TestEntityStudent> testData= new ArrayList<>();
        testData.add(TestEntityStudent.builder().name("Ivan").gender("male").mark(5l).build());
        testData.add(TestEntityStudent.builder().name("Petr").gender("male").mark(4l).build());
        testData.add(TestEntityStudent.builder().name("Oleg").gender("male").mark(4l).build());
        testData.add(TestEntityStudent.builder().name("Anna").gender("female").mark(4l).build());
        testData.add(TestEntityStudent.builder().name("Igor").gender("male").mark(5l).build());
        testData.add(TestEntityStudent.builder().name("Olga").gender("female").mark(4l).build());

        testData.stream().forEach(System.out::println);
        System.out.println("-------------------------------------");
        testData.stream().filter(x->x.getMark()==5).forEach(System.out::println);
        System.out.println("-------------------------------------");
        List<TestEntityStudent> testData1= new ArrayList<>();
        testData1=testData.stream().filter(x->x.getMark()==4).collect(Collectors.toList());
        testData1.stream().forEach(System.out::println);
        System.out.println("------------------------------------------");
        GetCollectionsStudents getCollectionsStudents = new GetCollectionsStudents();
        List<TestEntityStudent> testData2= new ArrayList<>();
        testData2=getCollectionsStudents.getAllStudentsByMark(testData,4l);
        testData2.stream().forEach(System.out::println);
    }

    // The method generates a random number from x to y
    private static int getRandomNunber(int x, int y) {
        Random random = new Random();
        int num = x + random.nextInt(y - x);
        return num;
    }
}
