package com.vdarko.workshop.tdd.async;

import java.util.concurrent.BlockingQueue;

public interface AsyncProducer {

  public void startProducing(BlockingQueue<String> queue);
}
