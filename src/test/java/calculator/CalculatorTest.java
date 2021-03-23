package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

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
                Arguments.of("1001,2,1000", 1002),
                Arguments.of("//[;][,]\n4;1,5", 10),
                Arguments.of("//[hello][yo]\n10hello100yo20hello20yo50", 200),
                Arguments.of("//[hello][yo][<]\n10hello100yo20hello20yo50<100", 300),
                Arguments.of("sdgson4afgd34agoin456aodfi12!%!%#6", 512)
        );
    }

    @Test
    void addNegativeNumberThrowsException() {
        assertThatIllegalArgumentException().isThrownBy(() -> Calculator.add("-10,10"));
    }

}