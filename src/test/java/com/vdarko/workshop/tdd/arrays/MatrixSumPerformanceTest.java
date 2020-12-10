package com.vdarko.workshop.tdd.arrays;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class MatrixSumPerformanceTest {

  private static final int HUGE_MATRIX_HEIGHT = 32_768;// 2^15
  private static final int HUGE_MATRIX_WIDTH = 32_768;// 2^15
  private static final int HUGE_MATRIX_NUMBER = 1;
  private static final int HUGE_MATRIX_SUM = HUGE_MATRIX_HEIGHT * HUGE_MATRIX_WIDTH * HUGE_MATRIX_NUMBER; // ~ 1 billion

  private static Integer[][] HUGE_MATRIX;

  @BeforeAll
  public static void beforeAll() throws Exception {
    generateHugeMatrix(HUGE_MATRIX_HEIGHT, HUGE_MATRIX_WIDTH, HUGE_MATRIX_NUMBER);
  }

  /**
   * <b>GIVEN</b> a huge matrix with ~ 1 billion elements</br>
   * <b>WHEN</b> sum is calculated using multiple threads</br>
   * <b>THEN</b> sum is calculated in 5 seconds</br>
   */
  @Test
  public void testHugeMatrix() throws Exception {

    // GIVEN
    Integer[][] numbers = HUGE_MATRIX;
    int expectedSum = HUGE_MATRIX_SUM;
    Long timeoutInSeconds = 5L;

    // WHEN
    MatrixSum matrixSum = new MatrixSum();

    Long startTime = System.currentTimeMillis();

    CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(//
            () -> matrixSum.parallelSum(numbers));
    Integer sum = completableFuture.get(timeoutInSeconds, TimeUnit.SECONDS);

    Long endTime = System.currentTimeMillis();
    System.out.println("Sum of the matrix successfully calculated in " + (endTime - startTime) + " milliseconds.");

    // THEN
    assertThat(sum).isEqualTo(expectedSum);
  }

  private static void generateHugeMatrix(int x, int y, int number) {
    Long startTime = System.currentTimeMillis();

    HUGE_MATRIX = new Integer[x][y];
    for (int i = 0; i < x; i++) {
      Arrays.fill(HUGE_MATRIX[i], number);
    }

    Long endTime = System.currentTimeMillis();
    System.out.println("Huge matrix successfully generated in " + (endTime - startTime) + " milliseconds.");
  }
}
