package com.vdarko.workshop.tdd.arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import org.junit.jupiter.api.Test;

public class MatrixSumEdgeCasesTest {

  /**
   * <b>GIVEN</b> empty matrix</br>
   * <b>WHEN</b> sum is calculated</br>
   * <b>THEN</b> sum is equal to 0</br>
   */
  @Test
  public void testEmptyMatrix() {

    // GIVEN
    Integer[][] numbers = new Integer[][] {};

    // WHEN
    MatrixSum matrixSum = new MatrixSum();
    Integer sum = matrixSum.sum(numbers);

    // THEN
    assertThat(sum).isZero();
  }

  /**
   * <b>GIVEN</b> null matrix</br>
   * <b>WHEN</b> sum is calculated</br>
   * <b>THEN</b> null is returned</br>
   */
  @Test
  public void testNullInput() {

    // GIVEN
    Integer[][] numbers = null;

    // WHEN
    MatrixSum matrixSum = new MatrixSum();
    Integer sum = matrixSum.sum(numbers);

    // THEN
    assertThat(sum).isNull();
  }

  /**
   * <b>GIVEN</b> matrix contains <code>null</code> on element with index=2</br>
   * <b>WHEN</b> sum is calculated</br>
   * <b>THEN</b> exception is thrown with appropriate message</br>
   */
  @Test
  public void testMatrixWithNullElement() {

    // GIVEN
    Integer[][] numbers = new Integer[][] { //
      { 1, 2, 3, 4, 5 }, //
      { 1, 2, 3, 4, 5 }, //
      null, //
      { 1, 2, 3, 4, 5 }, //
    };

    // WHEN
    MatrixSum matrixSum = new MatrixSum();

    Throwable thrown = catchThrowable(() -> {//
      matrixSum.sum(numbers);
    });

    // THEN
    assertThat(thrown)//
    .isNotNull()//
    .isInstanceOf(IllegalArgumentException.class)//
    .hasMessage("Array is not valid, it contains null element at index=2");
  }

  /**
   * <b>GIVEN</b> invalid matrix contains 2 arrays of 5 elements </br>
   * <b>AND</b> contains 1 array of 3 elements between them</br>
   * <b>WHEN</b> sum is calculated</br>
   * <b>THEN</b> sum is still calculated</br>
   * <b>AND</b> warning message is logged in console (no need to assert this
   * yet)</br>
   */
  @Test
  public void testMatrixWithShortenArray() {

    // GIVEN
    Integer[][] numbers = new Integer[][] { //
      { 1, 2, 3, 4, 5 }, //
      { 1, 2, 3 }, // shorten array
      { 1, 2, 3, 4, 5 }, //
    };

    // WHEN
    MatrixSum matrixSum = new MatrixSum();

    Integer sum = matrixSum.sum(numbers);


    // THEN
    assertThat(sum).isEqualTo(36);
  }
}
