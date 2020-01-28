package com.thread.learning;

import java.util.concurrent.atomic.AtomicInteger;

public class Locker {
	private int password = 176;
	private static int[] intArray = new int[30];
	private AtomicInteger atomicInterger = new AtomicInteger(0);
	
	public Locker() {
		writeValueInArray();
	}
	
	public static void writeValueInArray() {
		for (int i = 0; i < intArray.length; i++) {
			intArray[i]=i+1;
		}
	}

	public boolean isPasswordValid(int inputPassword) {
		if (inputPassword == password) {
			return true;
		}
		return false;
	}
	
	public void sumOfNumber(int intArray[]) {
		 for(int i=0; i < intArray.length ; i++) {
			int priviousValue = atomicInterger.get();
			int newValue = priviousValue + 1;
			atomicInterger.compareAndSet(priviousValue, newValue);
		 }
	}

}
