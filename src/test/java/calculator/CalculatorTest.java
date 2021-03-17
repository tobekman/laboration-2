package calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    @ParameterizedTest
    @MethodSource("provideStringsForGetSumFromNumbersInString")
    void getSumFromNumbersInString(String input, int expectedSum) {

        int actualSum = Calculator.add(input);

        assertThat(actualSum).isEqualTo(expectedSum);
    }

    private static Stream<Arguments> provideStringsForGetSumFromNumbersInString() {
        return Stream.of(
                Arguments.of("10,5", 15),
                Arguments.of("50,35,25", 110),
                Arguments.of("15,5\n10\n20", 50),
                Arguments.of("//;\n10;30", 40),
                Arguments.of("//hello\n10hello30hello40", 80),
                Arguments.of("-10,10,-5,5,-199,199", 0),
                Arguments.of("1001,2,1000", 1002)
        );
    }

}