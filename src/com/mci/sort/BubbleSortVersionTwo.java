package com.mci.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BubbleSortVersionTwo {
	public static void main(String[] args) {
//		int array[] = { 3, 9, -1, 10, -2 };
//
//		System.out.println("Before bubble sort");
//		System.out.println(Arrays.toString(array));
//		bubbleSort(array);
//		
//		System.out.println("After bubble sort");
//		System.out.println(Arrays.toString(array));

		// test with a 80000 element array
		int[] newArray = new int[80000];
		for (int i = 0; i < 80000; i++) {
			newArray[i] = (int) (Math.random() * 800000); // generate a random number
		}

		Date startDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String startString = sdf.format(startDate);
		System.out.println("Before sort: " + startString);

		bubbleSort(newArray);

		Date finishDate = new Date();
		String finishString = sdf.format(finishDate);
		System.out.println("After sort: " + finishString);
	}

	public static void bubbleSort(int[] array) {
		int temp = 0;
		boolean flag = false; // no number switch, for optimization

		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - 1 - i; j++) {
				if (array[j] > array[j + 1]) { // if the number is bigger than the next one, then switch
					flag = true; // at least 2 numbers switched
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}

//			System.out.println("Sort round " + (i + 1));
//			System.out.println(Arrays.toString(array));

			if (!flag) { // no switch happened
				break;
			} else {
				flag = false; // reset the flag for next loop
			}
		}
	}
}
