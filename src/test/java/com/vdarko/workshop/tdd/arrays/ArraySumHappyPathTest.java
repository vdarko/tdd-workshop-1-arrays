package com.vdarko.workshop.tdd.arrays;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class ArraySumHappyPathTest {

  /**
   * <b>GIVEN</b> array of integer values</br>
   * <b>WHEN</b> sum is calculated</br>
   * <b>THEN</b> sum value is as expected</br>
   */
  @Test
  public void testSum() {

    // GIVEN
    Integer[] numbers = new Integer[] { 1, 2, 3, 4, 5 };

    // WHEN
    ArraySum arraySum = new ArraySum();
    Integer sum = arraySum.sum(numbers);

    // THEN
    assertThat(sum).isEqualTo(15);
  }
}
