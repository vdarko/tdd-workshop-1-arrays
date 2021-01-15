package com.vdarko.workshop.tdd.async;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingDeque;

import org.junit.jupiter.api.Test;

import com.vdarko.workshop.tdd.async.thread.ThreadAsyncConsumer;
import com.vdarko.workshop.tdd.async.thread.ThreadAsyncProducer;

public class ThreadAsyncConsumerIntegrationTest extends Thread {

  /**
   * <b>GIVEN</b> async producer</br>
   * <b>AND</b> async consumer</br>
   * <b>WHEN</b> both are started</br>
   * <b>THEN</b> consumer will consume produced messages</br>
   * <b>AND</b> process them</br>
   * <b>AND</b> store results in another queue</br>
   */
  @Test
  public void testConsume() throws InterruptedException {

    // GIVEN
    int messageCount = 10;

    Long producerSleepTime = 100L;
    AsyncProducer producer = new ThreadAsyncProducer(producerSleepTime, messageCount);

    Long consumerSleepTime = 100L;
    AsyncConsumer consumer = new ThreadAsyncConsumer(consumerSleepTime);

    // WHEN
    BlockingQueue<String> inputQueue = new LinkedBlockingDeque<>();
    Queue<String> outputQueue = new ConcurrentLinkedQueue<>();

    producer.startProducing(inputQueue);
    consumer.startConsuming(inputQueue, outputQueue);

    // THEN
    Thread.sleep(1_000);

    assertThat(outputQueue)//
    .isNotEmpty()//
    .contains("Processed: Message 1");
  }
}
