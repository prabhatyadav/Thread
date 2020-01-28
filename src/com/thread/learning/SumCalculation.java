package com.thread.learning;

import java.util.concurrent.atomic.AtomicInteger;

public class SumCalculation implements Runnable {

	int[] inputArray;
	final AtomicInteger sum = new AtomicInteger(0);

	SumCalculation(int[] a) {
		this.inputArray = a;
	}

	public void run() {
		System.out.println(Thread.currentThread().getName() + ": Start");
		
		for (int val : inputArray) {
			int priviousValue = sum.get();
			int newValue = priviousValue + val;
			sum.compareAndSet(priviousValue, newValue);
		}
		
		System.out.println("Sum of Thread by End " + Thread.currentThread().getName() +" : "+ sum);
	}
}
