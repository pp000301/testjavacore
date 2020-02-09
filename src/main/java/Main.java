import task1.TestConditionalOperator;

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


    }

    // The method generates a random number from x to y
    private static int getRandomNunber(int x, int y) {
        Random random = new Random();
        int num = x + random.nextInt(y - x);
        return num;
    }
}
