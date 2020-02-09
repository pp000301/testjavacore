package task1;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TestConditionalOperator extends AbstractClass implements TestInterface {


    // The method checks whether the number is equal to 7
    public boolean getTrueSevev(int x) {
        boolean res = false;
        if (x == 7)
            res = true;
        return res;
    }

    //This method return the day of the week by number
    public String getDayWeek(int x) {
        String res = "";
        switch (x) {
            case 1:
                res = "Понедельник";
                break;
            case 2:
                res = "Вторник";
                break;
            case 3:
                res = "Среда";
                break;
            case 4:
                res = "Четверг";
                break;
            case 5:
                res = "Пятница";
                break;
            case 6:
                res = "Суббота";
                break;
            case 7:
                res = "Воскресенье";
                break;
        }
        return res;
    }

    //The method determines whether the number is even
    public boolean getEven(int x) {
        boolean res = false;
        if ((x % 2) == 0)
            res = true;
        return res;
    }
}
