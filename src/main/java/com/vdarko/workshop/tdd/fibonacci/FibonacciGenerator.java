package com.vdarko.workshop.tdd.fibonacci;

public class FibonacciGenerator {

  public Integer[] generate(Integer numbersCount) {

    if (numbersCount == null) {
      throw new IllegalArgumentException("Numbers count cannot be null");
    }

    if (numbersCount < 0) {
      throw new IllegalArgumentException("Numbers count cannot be negative");
    }

    if (numbersCount > 48) {
      throw new IllegalArgumentException(
              "Numbers count too high, fibonacci numbers will be higher than integer max value=" + Integer.MAX_VALUE);
    }

    Integer[] result = new Integer[numbersCount];

    for (int i = 0; i < numbersCount; i++) {
      Integer numberLast = i >= 1 ? result[i - 1] : 1;
      Integer numberSecondLast = i >= 2 ? result[i - 2] : 0;

      result[i] = numberLast + numberSecondLast;
    }

    return result;
  }
}
