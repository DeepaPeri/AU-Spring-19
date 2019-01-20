package com.evenOdd;

public class EvenOdd extends Thread {
	static int i = 1;
	Object lock;

	EvenOdd(Object lock) {
	    this.lock = lock;
	}
	
	@Override
	public void run() {
	    while (i <= 100) {
	        if (i % 2 == 0 && Thread.currentThread().getName().equals("EvenNumber")) {
	            synchronized (lock) {
	                System.out.println(Thread.currentThread().getName() + ": "
	                        + i);
	                i++;
	                try {
	                    lock.wait();
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	        if (i % 2 == 1 && Thread.currentThread().getName().equals("OddNumber")) {
	            synchronized (lock) {
	                System.out.println(Thread.currentThread().getName() + " : "
	                        + i);
	                i++;
	                lock.notify();
	              }
	         }
	   }
	}
	public static void main(String ar[]) {
	    Object obj = new Object();
	    // This constructor is required for the identification of wait/notify
	    // communication
	    EvenOdd odd = new EvenOdd(obj);
	    EvenOdd even = new EvenOdd(obj);
	    odd.setName("OddNumber");
	    even.setName("EvenNumber");
	    odd.start();
	    even.start();
	}

	
}
