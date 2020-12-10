package com.vdarko.workshop.tdd.arrays;

public class ArraySum {

  /**
   * Calculates sum of array
   *
   * @param numbers array of integer numbers
   *
   * @return sum of array or <code>null</code> if array is <code>null</code>
   */
  public Integer sum(Integer[] numbers) {
    if (numbers == null) {
      return null;
    }

    Integer sum = 0;
    for (int i = 0; i < numbers.length; i++) {
      Integer number = numbers[i];
      if (number == null) {
        throw new IllegalArgumentException("Array is not valid, it contains null element at index=" + i);
      }
      try {
        sum = Math.addExact(sum, number);
      } catch (ArithmeticException e) {
        // wrap the exception with more meaningful message and set the root cause
        throw new IllegalArgumentException("Array is not valid, it contains too high or low values and value cannot be calculated",e);
      }
    }

    return sum;
  }
}
