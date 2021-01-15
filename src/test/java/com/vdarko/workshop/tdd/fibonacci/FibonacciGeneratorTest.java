package com.vdarko.workshop.tdd.fibonacci;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import org.junit.jupiter.api.Test;

public class FibonacciGeneratorTest {

  /**
   * <b>GIVEN</b> numbers count is 5 <br>
   * <b>WHEN</b> 5 fibonacci numbers are generated<br>
   * <b>THEN</b> following numbers are generated 1 1 2 3 5<br>
   */
  @Test
  public void testGenerate() {
    // GIVEN
    Integer numbersCount = 5;
    Integer[] expectedFibonacciNumbers = new Integer[] { 1, 1, 2, 3, 5 };

    // WHEN
    FibonacciGenerator fibonacciGenerator = new FibonacciGenerator();
    Integer[] actualFibonacciNumbers = fibonacciGenerator.generate(numbersCount);

    // THEN
    assertThat(actualFibonacciNumbers).isEqualTo(expectedFibonacciNumbers);
  }

  /**
   * <b>GIVEN</b> numbers count is null <br>
   * <b>WHEN</b> fibonacci numbers are generated<br>
   * <b>THEN</b> exception is thrown with appropriate message<br>
   */
  @Test
  public void testNullAsNumbersCount() {
    // GIVEN
    Integer numbersCount = null;

    // WHEN
    FibonacciGenerator fibonacciGenerator = new FibonacciGenerator();

    Throwable thrown = catchThrowable(() -> {//
      fibonacciGenerator.generate(numbersCount);
    });

    // THEN
    assertThat(thrown)//
    .isNotNull()//
    .isInstanceOf(IllegalArgumentException.class)//
    .hasMessage("Numbers count cannot be null");
  }

  /**
   * <b>GIVEN</b> numbers count is negative <br>
   * <b>WHEN</b> fibonacci numbers are generated<br>
   * <b>THEN</b> exception is thrown with appropriate message<br>
   */
  @Test
  public void testNumbersCountIsNegative() {
    // GIVEN
    Integer numbersCount = -5;

    // WHEN
    FibonacciGenerator fibonacciGenerator = new FibonacciGenerator();

    Throwable thrown = catchThrowable(() -> {//
      fibonacciGenerator.generate(numbersCount);
    });

    // THEN
    assertThat(thrown)//
    .isNotNull()//
    .isInstanceOf(IllegalArgumentException.class)//
    .hasMessage("Numbers count cannot be negative");
  }

  /**
   * <b>GIVEN</b> numbers count is too high<br>
   * <b>AND</b> fibonacci numbers will be out of Integer range >
   * {@link Integer#MAX_VALUE}<br>
   * <b>WHEN</b> fibonacci numbers are generated<br>
   * <b>THEN</b> exception is thrown with appropriate message<br>
   */
  @Test
  public void testNumbersCountTooHigh() {
    // GIVEN
    Integer numbersCount = 100;

    // WHEN
    FibonacciGenerator fibonacciGenerator = new FibonacciGenerator();

    Throwable thrown = catchThrowable(() -> {//
      fibonacciGenerator.generate(numbersCount);
    });

    // THEN
    assertThat(thrown)//
    .isNotNull()//
    .isInstanceOf(IllegalArgumentException.class)//
    .hasMessage("Numbers count too high, fibonacci numbers will be higher than integer max value=2147483647");
  }

  /**
   * <b>GIVEN</b> numbers count is 48<br>
   * <b>WHEN</b> fibonacci numbers are generated<br>
   * <b>THEN</b> last number is still positive<br>
   * <b>AND</b> integer number overflow didn't change signum of the integer<br>
   */
  @Test
  public void testHighestNumbersCount() {
    // GIVEN
    Integer numbersCount = 48;
    Integer lastNumberIsGreaterThan = 0;

    // WHEN
    FibonacciGenerator fibonacciGenerator = new FibonacciGenerator();
    Integer[] actualFibonacciNumbers = fibonacciGenerator.generate(numbersCount);

    // THEN
    assertThat(actualFibonacciNumbers).hasSize(numbersCount);
    assertThat(actualFibonacciNumbers[numbersCount - 1]).isGreaterThan(lastNumberIsGreaterThan);
  }

  /**
   * <b>GIVEN</b> numbers count is 0 <br>
   * <b>WHEN</b> 0 fibonacci numbers are generated<br>
   * <b>THEN</b> empty result is returned<br>
   */
  @Test
  public void testZeroNumbers() {
    // GIVEN
    Integer numbersCount = 0;
    Integer[] expectedFibonacciNumbers = new Integer[] {};

    // WHEN
    FibonacciGenerator fibonacciGenerator = new FibonacciGenerator();
    Integer[] actualFibonacciNumbers = fibonacciGenerator.generate(numbersCount);

    // THEN
    assertThat(actualFibonacciNumbers).isEqualTo(expectedFibonacciNumbers);
  }
}
