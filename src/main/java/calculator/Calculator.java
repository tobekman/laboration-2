package calculator;

import java.util.ArrayList;

public class Calculator {

    public static int add(String numbers) {

        int result = 0;
        String delimiter = "";
        ArrayList<Integer> negativeNumbers = new ArrayList<>();

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
            if(Integer.parseInt(s) < 0) {
                negativeNumbers.add(Integer.parseInt(s));
            }
            
            result = result + Integer.parseInt(s);
        }

        if(negativeNumbers.size() > 0) {
            StringBuilder numbersString = new StringBuilder();
            for (int num: negativeNumbers) {
                numbersString.append(" ").append(num);
            }
            throw new IllegalArgumentException("negatives are not allowed" + numbersString);
        }

        return result;
    }
}
