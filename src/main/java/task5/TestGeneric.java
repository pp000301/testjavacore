package task5;

import java.util.Collection;
import java.util.List;

public class TestGeneric <T> {

    public <E> void test(Collection<E> collection) {
        for (E element : collection) {
            System.out.println(element);
        }
    }
    public void test(List<Integer> collection) {
        for (Integer element : collection) {
            System.out.println(element);
        }
    }
}
