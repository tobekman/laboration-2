package calculator;

import java.util.ArrayList;

public class Calculator {

    public static int add(String numbers) {

        int result = 0;
        String delimiter;
        ArrayList<Integer> negativeNumbers = new ArrayList<>();

        if (numbers.startsWith("//[")) {

            String[] splitDelimAndNumbers = numbers.split("\n", 2);
            delimiter = splitDelimAndNumbers[0]
                    .replaceFirst("//", "")
                    .replaceAll("\\[", "")
                    .replaceAll("]", "|");
            delimiter = delimiter.substring(0, delimiter.length() - 1);
            numbers = splitDelimAndNumbers[1];

        } else if (numbers.startsWith("//")) {

            String[] splitDelimAndNumbers = numbers.split("\n", 2);
            delimiter = splitDelimAndNumbers[0].replaceFirst("//", "");
            numbers = splitDelimAndNumbers[1];

        } else {
            delimiter = ",|\n";
        }

        String[] numbersArray = numbers.split(delimiter);

        for (String s : numbersArray) {
            if (Integer.parseInt(s) < 0) {
                negativeNumbers.add(Integer.parseInt(s));
            }

            if (Integer.parseInt(s) < 1001) {
                result = result + Integer.parseInt(s);
            }

        }

        if (negativeNumbers.size() > 0) {
            StringBuilder numbersString = new StringBuilder();
            for (int num : negativeNumbers) {
                numbersString.append(" ").append(num);
            }
            throw new IllegalArgumentException("negatives are not allowed" + numbersString);
        }

        return result;
    }

}
