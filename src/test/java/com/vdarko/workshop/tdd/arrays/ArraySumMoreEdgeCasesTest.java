package com.vdarko.workshop.tdd.arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import org.junit.jupiter.api.Test;

public class ArraySumMoreEdgeCasesTest {

  /**
   * <b>GIVEN</b> array high values</br>
   * <b>WHEN</b> sum is calculated</br>
   * <b>THEN</b> sum value should not incorrect with opposite sign</br>
   * <b>AND</b> exception is thrown with appropriate message</br>
   *
   * @see Math#addExact(int, int)
   */
  @Test
  public void testSumOverflow() {

    // GIVEN
    Integer[] numbers = new Integer[] { 1, 2, Integer.MAX_VALUE };

    // WHEN
    ArraySum arraySum = new ArraySum();
    Throwable thrown = catchThrowable(() -> {//
      arraySum.sum(numbers);
    });

    // THEN
    assertThat(thrown)//
    .isNotNull()//
    .isInstanceOf(IllegalArgumentException.class)//
    .hasRootCauseInstanceOf(ArithmeticException.class)//
    .hasRootCauseMessage("integer overflow")//
    .hasMessage("Array is not valid, it contains too high or low values and value cannot be calculated");
  }

  /**
   * <b>GIVEN</b> array low values</br>
   * <b>WHEN</b> sum is calculated</br>
   * <b>THEN</b> sum value should not incorrect with opposite sign</br>
   * <b>AND</b> exception is thrown with appropriate message</br>
   *
   * @see Math#addExact(int, int)
   */
  @Test
  public void testSumUnderflow() {

    // GIVEN
    Integer[] numbers = new Integer[] { -1, -2, Integer.MIN_VALUE };

    // WHEN
    ArraySum arraySum = new ArraySum();
    Throwable thrown = catchThrowable(() -> {//
      arraySum.sum(numbers);
    });

    // THEN
    assertThat(thrown)//
    .isNotNull()//
    .isInstanceOf(IllegalArgumentException.class)//
    .hasRootCauseInstanceOf(ArithmeticException.class)//
    .hasRootCauseMessage("integer overflow")//
    .hasMessage("Array is not valid, it contains too high or low values and value cannot be calculated");
  }
}
