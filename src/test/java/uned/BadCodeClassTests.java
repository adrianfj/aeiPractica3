package uned;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BadCodeClassTests {

    @Test
    @DisplayName("With empty input throws exception")
    public void emptyInput_throwsException() {
        Assertions.assertThrows(
                BadOperationException.class,
                () -> BadCodeClass.c(""));
    }

    @Test
    @DisplayName("With a single number returns the number")
    public void singleNumber_returnsNumber() throws Exception {
        Assertions.assertEquals(5, BadCodeClass.c("5"));
    }

    @Test
    @DisplayName("Adds two numbers")
    public void addsTwoNumbers_returnsSum() throws Exception {
        Assertions.assertEquals(9, BadCodeClass.c("5+4"));
    }

    @Test
    @DisplayName("Adds two numbers with spaces")
    public void addsTwoNumbersWithSpaces_returnsSum() throws Exception {
        Assertions.assertEquals(9, BadCodeClass.c("  5 +   4    "));
    }

    @Test
    @DisplayName("Substracts two numbers")
    public void substractsTwoNumbers_returnsSub() throws Exception {
        Assertions.assertEquals(-1, BadCodeClass.c("4-5"));
    }

    @Test
    @DisplayName("Substracts two numbers with spaces")
    public void substractsTwoNumbersWithSpaces_returnsSub() throws Exception {
        Assertions.assertEquals(-1, BadCodeClass.c("  4 -   5    "));
    }

    @Test
    @DisplayName("Multiplies two numbers")
    public void multipliesTwoNumbers_returnsMult() throws Exception {
        Assertions.assertEquals(20, BadCodeClass.c("4*5"));
    }

    @Test
    @DisplayName("Multiplies two numbers with spaces")
    public void multipliesTwoNumbersWithSpaces_returnsMult() throws Exception {
        Assertions.assertEquals(20, BadCodeClass.c("  4 *   5    "));
    }

    @Test
    @DisplayName("Divides two numbers")
    public void dividesTwoNumbers_returnsDiv() throws Exception {
        Assertions.assertEquals(2, BadCodeClass.c("8/3"));
    }

    @Test
    @DisplayName("Divides two numbers with spaces")
    public void dividesTwoNumbersWithSpaces_returnsDiv() throws Exception {
        Assertions.assertEquals(2, BadCodeClass.c("  8 /   3    "));
    }

    @Test
    @DisplayName("Complex operation without negative numbers neither parenthesis")
    public void complex_operationReturnsResult() throws Exception {
        Assertions.assertEquals(-8, BadCodeClass.c("1 - 2  *    3  * 3 + 5  / 2 +    3 -9  "));
    }
}
