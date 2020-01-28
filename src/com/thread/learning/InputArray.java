package com.thread.learning;

public class InputArray {
	private static int[] intArray;

	public InputArray(int size) {
		intArray = new int[size];

		writeValueInArray();
	}

	public static int[] writeValueInArray() {
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = i + 1;
		}
		return intArray;
	}
	
	public int[] getInputArray() {
		return intArray;
	}

}
