package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    @Test
    void getSumFromNumbersInString() {
        String input = "10,5,5,26\n54";
        int expectedSum = 100;

        int actualSum = Calculator.add(input);

        assertThat(actualSum).isEqualTo(expectedSum);
    }
}