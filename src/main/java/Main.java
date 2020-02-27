import task1.TestConditionalOperator;
import task2.GetCollectionsStudents;
import task2.TestEntityStudent;
import task3and4.TestEntityExeption;
import task5.TestGeneric;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static task6.TestLambda.evaluate;

public class Main {
    public static void main(String[] args) {
        // Testing block of task1
        /*
        task checks whether the number is equal to 7
        task return the day of the week by number
        task determines whether the number is even
        */
        int testNumber = getRandomNunber(1, 7);
        TestConditionalOperator testConditionalOperator = new TestConditionalOperator();
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("Test number = " + testNumber);
        System.out.println("The result of checking whether the number is 7: " + testConditionalOperator.getTrueSevev(testNumber));
        System.out.println("Day of week: " + testConditionalOperator.getDayWeek(testNumber));
        System.out.println("The number is even "+testConditionalOperator.getEven(testNumber));
        System.out.println("---------------------------------------------------------------------------------");
        // End testing block of task1

        //Testing block of task2
        //Task get a list of students by mark
        List<TestEntityStudent> testData = new ArrayList<>();
        testData.add(TestEntityStudent.builder().name("Ivan").gender("male").mark(5l).build());
        testData.add(TestEntityStudent.builder().name("Petr").gender("male").mark(4l).build());
        testData.add(TestEntityStudent.builder().name("Oleg").gender("male").mark(4l).build());
        testData.add(TestEntityStudent.builder().name("Anna").gender("female").mark(4l).build());
        testData.add(TestEntityStudent.builder().name("Igor").gender("male").mark(5l).build());
        testData.add(TestEntityStudent.builder().name("Olga").gender("female").mark(4l).build());

        GetCollectionsStudents getCollectionsStudents = new GetCollectionsStudents();
        testData = getCollectionsStudents.getAllStudentsByMark(testData, 4l);
        testData.stream().forEach(System.out::println);
        System.out.println("---------------------------------------------------------------------------------");
        //End testing block of task2

        //Testing block of task3-4
        //Task find the number of characters in a string
        System.out.println("Enter the testing string:");
        String s= input();
        System.out.println("The count symbol:  "+ TestEntityExeption.getCountSymble(s,'f') );
        //End testing block of task3
        System.out.println("---------------------------------------------------------------------------------");

        //Testing block of task5
        //Example of use Generic Types
        TestGeneric<String> st = new TestGeneric<>();
        List<String> list = Arrays.asList("test");
        st.test(list);
        List<Integer> list1= Arrays.asList(1,2,3);
        st.test(list1);
        List<Double> list2= Arrays.asList(1.1,2.2,3.3);
        st.test(list2);
        //End testing block of task5
        System.out.println("---------------------------------------------------------------------------------");

        //Testing block of task6
        //Example of use lambda expressions
        List<Integer> list3 = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        System.out.print("Displays all numbers: ");
        evaluate(list3, (n)->true);

        System.out.print("Does not output anything: ");
        evaluate(list3, (n)->false);

        System.out.print("Displays is even numbers: ");
        evaluate(list3, (n)-> n%2 == 0 );

        System.out.print("Displays is not even numbers: ");
        evaluate(list3, (n)-> n%2 == 1 );

        System.out.print("Displays numbers more 5: ");
        evaluate(list3, (n)-> n > 5 );
        //End testing block of task5
    }

    // The method generates a random number from x to y, used in the block task1.
    private static int getRandomNunber(int x, int y) {
        Random random = new Random();
        int num = x + random.nextInt(y - x);
        return num;
    }

    // The matod reads a string from the console, used in the block task3.
    public static String input() throws NullPointerException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        try {
            s = reader.readLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {

            try {
                reader.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        if (s.equals("")) {
            throw new NullPointerException("String can not be empty!");
        }
        return s;
    }


}
