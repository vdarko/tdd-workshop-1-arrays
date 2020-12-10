package com.vdarko.workshop.tdd.arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import org.junit.jupiter.api.Test;

public class ArraySumEdgeCasesTest {

  /**
   * <b>GIVEN</b> empty array</br>
   * <b>WHEN</b> sum is calculated</br>
   * <b>THEN</b> sum is equal to 0</br>
   */
  @Test
  public void testEmptyArray() {

    // GIVEN
    Integer[] numbers = new Integer[] {};

    // WHEN
    ArraySum arraySum = new ArraySum();
    Integer sum = arraySum.sum(numbers);

    // THEN
    assertThat(sum).isZero();
  }

  /**
   * <b>GIVEN</b> null array</br>
   * <b>WHEN</b> sum is calculated</br>
   * <b>THEN</b> null is returned</br>
   */
  @Test
  public void testNullInput() {

    // GIVEN
    Integer[] numbers = null;

    // WHEN
    ArraySum arraySum = new ArraySum();
    Integer sum = arraySum.sum(numbers);

    // THEN
    assertThat(sum).isNull();
  }

  /**
   * <b>GIVEN</b> array contains <code>null</code> on element with index=1</br>
   * <b>WHEN</b> sum is calculated</br>
   * <b>THEN</b> exception is thrown with appropriate message</br>
   */
  @Test
  public void testArrayWithNullElement() {

    // GIVEN
    Integer[] numbers = new Integer[] { 1, null, 3 };

    // WHEN
    ArraySum arraySum = new ArraySum();

    Throwable thrown = catchThrowable(() -> {//
      arraySum.sum(numbers);
    });

    // THEN
    assertThat(thrown)//
    .isNotNull()//
    .isInstanceOf(IllegalArgumentException.class)//
    .hasMessage("Array is not valid, it contains null element at index=1");
  }
}
