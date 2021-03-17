package calculator;

public class Calculator {

    public static int add(String numbers) {

        int result = 0;
        String[] numbersArray = numbers.split(",");

        if(numbersArray.length < 1 || numbersArray.length > 3) {
            return 0;
        }

        for (String s : numbersArray) {
            result = result + Integer.parseInt(s);
        }
        return result;
    }
}
