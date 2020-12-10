package com.vdarko.workshop.tdd.arrays;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class MatrixSumHappyPathTest {

  /**
   * <b>GIVEN</b> matrix of integer values</br>
   * <b>WHEN</b> sum is calculated</br>
   * <b>THEN</b> sum value is as expected</br>
   */
  @Test
  public void testSum() {

    // GIVEN
    Integer[][] numbers = new Integer[][] { //
      { 1, 2, 3, 4, 5 }, //
      { 1, 2, 3, 4, 5 }, //
    };

    // WHEN
    MatrixSum matrixSum = new MatrixSum();
    Integer sum = matrixSum.sum(numbers);

    // THEN
    assertThat(sum).isEqualTo(30);
  }
}
