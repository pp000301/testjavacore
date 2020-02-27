import task1.TestConditionalOperator;
import task2.GetCollectionsStudents;
import task2.TestEntityStudent;
import task3.TestEntityExeption;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

        //Testing block of task2
        List<TestEntityStudent> testData= new ArrayList<>();
        testData.add(TestEntityStudent.builder().name("Ivan").gender("male").mark(5l).build());
        testData.add(TestEntityStudent.builder().name("Petr").gender("male").mark(4l).build());
        testData.add(TestEntityStudent.builder().name("Oleg").gender("male").mark(4l).build());
        testData.add(TestEntityStudent.builder().name("Anna").gender("female").mark(4l).build());
        testData.add(TestEntityStudent.builder().name("Igor").gender("male").mark(5l).build());
        testData.add(TestEntityStudent.builder().name("Olga").gender("female").mark(4l).build());

        GetCollectionsStudents getCollectionsStudents = new GetCollectionsStudents();
        testData=getCollectionsStudents.getAllStudentsByMark(testData,4l);
        testData.stream().forEach(System.out::println);
        //End testing block of task2

       //Testing block of task3

       //End testing block of task3

    }

    // The method generates a random number from x to y
    private static int getRandomNunber(int x, int y) {
        Random random = new Random();
        int num = x + random.nextInt(y - x);
        return num;
    }
}
