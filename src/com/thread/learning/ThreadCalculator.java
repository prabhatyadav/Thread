package com.thread.learning;

import java.util.ArrayList;
import java.util.Scanner;

public class ThreadCalculator {

	public static void main(String[] args) {

		
		System.out.println("Enter the number ");
		Scanner in = new Scanner(System.in);
		int a[] = new InputArray(in.nextInt()).getInputArray();

		ArrayList<Thread> arrayThread = new ArrayList<>();
		for (int i = 0; i < a.length; i = i + 10) {
			arrayThread.add(new Thread(new SumCalculation(splitArray(i, i + 9, a))));
		}

		/*
		 * Thread thread1 = new Thread(new SumCalculation(splitArray(0, 9, a))); Thread
		 * thread2 = new Thread(new SumCalculation(splitArray(10, 19, a))); Thread
		 * thread3 = new Thread(new SumCalculation(splitArray(20, 29, a)));
		 * 
		 * thread1.currentThread().setName("Thread-Doing-Sum-0-9");
		 * thread2.currentThread().setName("Thread-Doing-Sum-10-19");
		 * thread3.currentThread().setName("Thread-Doing-Sum-20-29");
		 */
		for (Thread thread : arrayThread) {
			thread.start();
		}
		/*
		 * thread1.start(); thread2.start(); thread3.start();
		 */

	}

	public static int[] splitArray(int initial, int end, int input[]) {

		int array[] = new int[end - initial + 1];
		for (int i = 0; i < array.length; i++) {
			array[i] = input[initial];
			initial++;
		}
		return array;
	}

}
