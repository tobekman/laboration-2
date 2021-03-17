package calculator;

public class Calculator {

    public static int add(String numbers) {

        int result = 0;
        String[] numbersArray = numbers.split(",");

        for (String s : numbersArray) {
            result = result + Integer.parseInt(s);
        }
        return result;
    }
}
