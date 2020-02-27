package task3and4;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class TestEntityExeption {

    //The method counts the number of specified characters in a string
    public static long getCountSymble(String string, Character character) {
        Integer count = 0;
        List<Character> characters = new ArrayList<>();
        for (int i = 0; i < string.length(); i++) {
            char k = string.charAt(i);
            characters.add(k);
        }
        return characters.stream().filter(x -> x == character).count();
    }
}
