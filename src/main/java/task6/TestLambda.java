package task6;

import java.util.List;
import java.util.function.Predicate;

public class TestLambda {

    public static void evaluate (List<Integer> list, Predicate<Integer> predicate) {
        for (Integer n : list) {
            if (predicate.test(n)) {
                System.out.print(n + " ");
            }
        }
        System.out.println();
    }
}
