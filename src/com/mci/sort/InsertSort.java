package com.mci.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class InsertSort {

	public static void main(String[] args) {
//		int[] array = { 101, 34, 119, 1, -1, 90, 123 };
//		System.out.println("Before sort:");
//		System.out.println(Arrays.toString(array));

		// test with a 8000000 element array
		int[] newArray = new int[8000000];
		for (int i = 0; i < 8000000; i++) {
			newArray[i] = (int) (Math.random() * 8000000); // generate a random number from 0 to 800000
		}

		Date startDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String startString = sdf.format(startDate);
		System.out.println("Before sort: " + startString);
		
		insertSort(newArray);

		Date finishDate = new Date();
		String finishString = sdf.format(finishDate);
		System.out.println("After sort: " + finishString);
//		System.out.println(Arrays.toString(array));

	}

	public static void insertSort(int[] array) {

		for (int i = 1; i < array.length; i++) {
			int insertValue = array[i];
			int insertIndex = i - 1;

			// find the insert position for insertValue
			// 1. insertIndex >= 0 insure insertValue is not out of bound
			// 2. insertValue < array[insertIndex]
			while (insertIndex >= 0 && insertValue < array[insertIndex]) {
				array[insertIndex + 1] = array[insertIndex];
				insertIndex--;
			}

			array[insertIndex + 1] = insertValue;

//			System.out.println("Round:" + i);
//			System.out.println(Arrays.toString(array));
		}

	}
}
