package com.vdarko.workshop.tdd.async.thread;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;

import com.vdarko.workshop.tdd.async.AsyncConsumer;

public class ThreadAsyncConsumer implements AsyncConsumer {

  private final Long sleepTime;

  public ThreadAsyncConsumer(Long sleepTime) {
    this.sleepTime = sleepTime;
  }

  @Override
  public void startConsuming(BlockingQueue<String> input, Queue<String> output) {

    Runnable runnable = () -> {
      while (true) {
        try {
          String message = input.take();
          String processedMessage = process(message);
          output.add(processedMessage);
          Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
          System.err.println("Consumer is interrupted");
        }
      }
    };

    Thread thread = new Thread(runnable);
    thread.start();
  }

  private String process(String message) {
    return "Processed: " + message;
  }
}
