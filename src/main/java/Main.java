import task1.TestConditionalOperator;
import task2.GetCollectionsStudents;
import task2.TestEntityStudent;
import task3and4.TestEntityExeption;
import task5.TestGeneric;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static task6.TestLambda.evaluate;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {
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
        System.out.println("The number is even " + testConditionalOperator.getEven(testNumber));
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
        String s = input();
        System.out.println("The count symbol:  " + TestEntityExeption.getCountSymble(s, 'f'));
        //End testing block of task3
        System.out.println("---------------------------------------------------------------------------------");

        //Testing block of task5
        //Example of use Generic Types
        TestGeneric<String> st = new TestGeneric<>();
        List<String> list = Arrays.asList("test");
        st.test(list);
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        st.test(list1);
        List<Double> list2 = Arrays.asList(1.1, 2.2, 3.3);
        st.test(list2);
        //End testing block of task5
        System.out.println("---------------------------------------------------------------------------------");

        //Testing block of task6
        //Example of use lambda expressions
        List<Integer> list3 = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        System.out.print("Displays all numbers: ");
        evaluate(list3, (n) -> true);

        System.out.print("Does not output anything: ");
        evaluate(list3, (n) -> false);

        System.out.print("Displays is even numbers: ");
        evaluate(list3, (n) -> n % 2 == 0);

        System.out.print("Displays is not even numbers: ");
        evaluate(list3, (n) -> n % 2 == 1);

        System.out.print("Displays numbers more 5: ");
        evaluate(list3, (n) -> n > 5);
        //End testing block of task6

        //Testing block of task7
        //Example of use NIO

        String uri = "F:\\example.txt";

        try {

            File f = new File(uri);

            if (f.createNewFile())
                System.out.println("File created");
            else
                System.out.println("File already exists");
        } catch (Exception e) {
            System.err.println(e);
        }

        Path path = Paths.get(uri);
        Files.write(path, Collections.singleton("Test message!!!"));
        List<String> resultString = Files.readAllLines(Paths.get(uri));
        System.out.println(resultString);

        //End testing block of task7

        //Testing block of task8
        //Example of use JDBC
        //PostgreSQL
        Connection connection = null;
        String url = "jdbc:postgresql://ec2-54-217-235-87.eu-west-1.compute.amazonaws.com:5432/d2pec6je7msmae";
        String name = "lfohkxhgbbgvwr";
        String password = "7d63df0bf5f911df6a91a9cb7f1e2b4ecbcb1001d4053cf85dd4572475ad4adb";

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, name, password);
            Statement statement = connection.createStatement();
            ResultSet result1 = statement.executeQuery(
                    "SELECT * FROM test_entity");

            while (result1.next()) {
                System.out.println("Номер в выборке #" + result1.getRow()
                        + "\t Номер в базе #" + result1.getInt("id")
                        + "\t" + result1.getString("test_text"));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //End PostgreSQL

        //H2 DB
        String urlH2="jdbc:h2:mem:default";
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection(urlH2);
            Statement statement = connection.createStatement();
            ResultSet result1 = statement.executeQuery(
                    "SELECT * FROM test_entity");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        //End H2 db


        //End testing block of task8

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
