package com.mci.sort;

import java.util.Arrays;

public class SelectSort {

	public static void main(String[] args) {
		int[] array = { 101, 34, 119, 1, -1, 90, 123 };
		System.out.println("Before sort:");
		System.out.println(Arrays.toString(array));

		selectSort(array);
		
		System.out.println("After sort:");
		System.out.println(Arrays.toString(array));
	}

	public static void selectSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			int minIndex = i;
			int min = array[i];
			for (int j = i + 1; j < array.length; j++) {
				// find the real min value
				if (min > array[j]) {
					min = array[j]; // reset de min value
					minIndex = j; // reset min index value
				}
			}

			if (minIndex != i) { // put the min value in array[i]
				array[minIndex] = array[i];
				array[i] = min;
			}

//			System.out.printf("After sort round %d", i);
//			System.out.println(Arrays.toString(array));

		}
	}
}
