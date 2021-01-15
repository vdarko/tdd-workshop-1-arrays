package com.vdarko.workshop.tdd.async.thread;

import java.util.concurrent.BlockingQueue;

import com.vdarko.workshop.tdd.async.AsyncProducer;

public class ThreadAsyncProducer implements AsyncProducer {

  private final Long sleepTime;

  private final int count;

  public ThreadAsyncProducer(Long sleepTime, int count) {
    this.sleepTime = sleepTime;
    this.count = count;
  }

  @Override
  public void startProducing(BlockingQueue<String> queue) {

    Runnable runnable = () -> {
      for (int i = 0; i < count; i++) {
        String message = "Message " + i;
        queue.add(message);
        try {
          Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
          System.err.println("Producer is interrupted");
        }
      }
    };

    Thread thread = new Thread(runnable);
    thread.start();
  }
}
