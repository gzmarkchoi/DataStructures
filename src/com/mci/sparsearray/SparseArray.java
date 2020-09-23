package com.mci.sparsearray;

public class SparseArray {

	public static void main(String[] args) {
		/*
		 *  a 11 * 11 array
		 *  0 - no chess
		 *  1 - black chess
		 *  2 - blue chess
		 */
		int chessArray1[][] = new int[11][11];
		chessArray1[1][2] = 1;
		chessArray1[2][3] = 2;
		chessArray1[4][5] = 2;
		
		// total column number
		// System.out.println(chessArray1.length);
		// total row number
		// System.out.println(chessArray1[0].length);
		
		System.out.println("-------------- array --------------");
		for (int [] row : chessArray1) {
			for (int data : row) {
				System.out.printf("%d\t", data);
			}
			System.out.println();
		}
		
		/*
		 * array to sparse array
		 */
		int sum = 0;
		for (int i = 0; i < chessArray1.length; i++) {
			for (int j = 0; j < chessArray1[0].length; j++) {
				if (chessArray1[i][j] != 0) {
					sum++;
				}
			}
		}
		
		int sparseArray[][] = new int[sum + 1][3];
		// first line
		sparseArray[0][0] = 11;
		sparseArray[0][1] = 11;
		sparseArray[0][2] = sum;
		
		// put data in sparse array
		int count = 0; // number of data
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				if (chessArray1[i][j] != 0) {
					count++;
					sparseArray[count][0] = i;
					sparseArray[count][1] = j;
					sparseArray[count][2] = chessArray1[i][j];
				}
			}
		}
		
		System.out.println("------- Sparse Array from array -------");
		for (int i = 0; i < sparseArray.length; i++) {
			System.out.printf("%d\t%d\t%d\t\n", sparseArray[i][0], sparseArray[i][1], sparseArray[i][2]);
		}
		
		/*
		 * Sparse Array to array
		 */
		System.out.println("------- array from Sparse Array -------");
		
		int chessArray2[][] = new int[sparseArray[0][0]][sparseArray[0][1]];
		
		for (int i = 1; i < sparseArray.length; i++) {
			chessArray2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
		}
		
		for (int [] row : chessArray2) {
			for (int data : row) {
				System.out.printf("%d\t", data);
			}
			System.out.println();
		}
		
	}

}
