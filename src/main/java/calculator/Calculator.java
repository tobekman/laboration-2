package calculator;

public class Calculator {

    public static int add(String numbers) {

        int result = 0;
        String delimiter = "";

        if (numbers.startsWith("//")) {
            String[] newDelim = numbers.split("\n", 2);
            delimiter = newDelim[0].replaceFirst("//", "");
            numbers = newDelim[1];
        }
        else {
            delimiter = ",|\n";
        }

        String[] numbersArray = numbers.split(delimiter);

        for (String s : numbersArray) {
            result = result + Integer.parseInt(s);
        }
        return result;
    }
}
