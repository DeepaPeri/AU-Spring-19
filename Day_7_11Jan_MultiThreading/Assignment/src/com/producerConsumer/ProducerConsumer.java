package com.producerConsumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumer {
	static int max = 5;
	  static BlockingQueue<Integer> q = new LinkedBlockingQueue<Integer>(max);

	  public static void main(String[] args) {

	    Producer producer = new Producer();
	    Consumer consumer = new Consumer();
	    producer.start();
	    consumer.start();
	  }

	  static class Producer extends Thread {
	    Random random = new Random();

	    public void run() {
	      while (true) {
	        Integer x = random.nextInt(max);
	        try {
	        	
	        	q.put(x);
	        	System.out.println("Produced: "+ x);
	        	System.out.print("");
	        	
	        	Thread.sleep(200);	
	         
	        } catch (InterruptedException e) {
	        }
	      }
	    }
	  }

	  static class Consumer extends Thread {
	    public void run() {
	      while (true) {
	        try {
	          System.out.println("Consumed: " + q.take());
	          System.out.print("");
	          Thread.sleep(200);
	        } catch (InterruptedException e) {
	          e.printStackTrace();
	        }
	      }
	    }
	  }

}

