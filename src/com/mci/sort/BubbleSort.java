package com.mci.sort;

import java.util.Arrays;

/**
 * Bubble sort
 * 
 * @author Gzmar
 *
 */
public class BubbleSort {

	public static void main(String[] args) {
		int array[] = { 3, 9, -1, 10, -2 };

		int temp = 0;
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - 1 - i; j++) {
				if (array[j] > array[j + 1]) { // if the number is bigger than the next one, then switch
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}

			System.out.println("Sort round " + (i + 1));
			System.out.println(Arrays.toString(array));
		}
	}

}
