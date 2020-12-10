package com.vdarko.workshop.tdd.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

public class MatrixSum {

  private static final int EXECUTOR_SERVICE_THREAD_COUNT = 8;

  private final ArraySum arraySum;

  private final ExecutorService executorService;

  public MatrixSum() {
    arraySum = new ArraySum();
    executorService = Executors.newFixedThreadPool(EXECUTOR_SERVICE_THREAD_COUNT);
  }

  /**
   * Calculates sum of matrix (2 dimensional array )
   *
   * @param numbers matrix of integer numbers
   *
   * @return sum of matrix or <code>null</code> if matrix is <code>null</code>
   */
  public Integer sum(Integer[][] numbers) {
    if (numbers == null) {
      return null;
    }

    Integer[] arraySums = new Integer[numbers.length];
    for (int i = 0; i < numbers.length; i++) {
      Integer sumOfArray = arraySum.sum(numbers[i]);
      arraySums[i] = sumOfArray;
    }

    return arraySum.sum(arraySums);
  }

  /**
   * Calculates sum of matrix using {@link CompletableFuture} and
   * {@link ExecutorService}
   *
   * @param numbers matrix of integer numbers
   *
   * @return sum of matrix or <code>null</code> if matrix is <code>null</code>
   *
   * @see sum
   */
  public Integer parallelSum(Integer[][] numbers) {
    if (numbers == null) {
      return null;
    }

    List<CompletableFuture<Integer>> sumOfRowsCompletableFutures = new ArrayList<>(numbers.length);
    for (int i = 0; i < numbers.length; i++) {
      final int finalIndex = i;
      CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(//
              () -> arraySum.sum(numbers[finalIndex]), //
              executorService);
      sumOfRowsCompletableFutures.add(completableFuture);
    }

    Integer[] sumOfRows = sumOfRowsCompletableFutures.stream()//
            .map(CompletableFuture::join)//
            .toArray(Integer[]::new);

    return arraySum.sum(sumOfRows);
  }

  /**
   * Calculates sum of matrix (2 dimensional array ) using {@link Stream}
   *
   * @param numbers matrix of integer numbers
   *
   * @return sum of matrix or <code>null</code> if matrix is <code>null</code>
   */
  public Integer parallelSumUsingStreams(Integer[][] numbers) {
    if (numbers == null) {
      return null;
    }

    Integer[] sumOfRows = Stream.of(numbers)//
            .parallel()//
            .map(arraySum::sum)//
            .toArray(Integer[]::new);

    return arraySum.sum(sumOfRows);
  }
}
