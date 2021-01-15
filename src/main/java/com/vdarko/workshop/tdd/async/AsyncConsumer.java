package com.vdarko.workshop.tdd.async;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;

public interface AsyncConsumer {

  public void startConsuming(BlockingQueue<String> input, Queue<String> output);
}
