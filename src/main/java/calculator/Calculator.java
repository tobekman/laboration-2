package calculator;

import java.util.ArrayList;
import java.util.Arrays;

public class Calculator {

    public static int add(String numbers) {

        String[] numbersToAdd = numbers.replaceAll("[^0-9-]", " ")
                .trim()
                .split(" ");

        int result = Arrays.stream(numbersToAdd)
                .filter(num -> !num.isBlank())
                .map(Integer::parseInt)
                .filter(num -> num < 1001)
                .reduce(0, Integer::sum);

        ArrayList<Integer> negativeNumbers = new ArrayList<>();

        for (String s : numbersToAdd) {
            if (!s.isBlank()) {
                if (Integer.parseInt(s) < 0) {
                    negativeNumbers.add(Integer.parseInt(s));
                }
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
