package com.sorting.practice;

import java.util.Arrays;

public class MergeArray {

	public static void main(String[] args) {
		
		int[] a1 = {1,5,9,10,15,20};
		int[] a2 = {2,3,8,13};
		
		merge(a1, a2);
		printarray(a1);
		System.out.println("-----------------------------------");
		printarray(a2);

	}

	private static void merge(int[] a1, int[] a2) {
		
		int arrsize1 = a1.length;
		int index = 0;
		
		while(index < arrsize1) {
			if(a1[index] <= a2[0]) {
				index ++;
			} else {
				swap(a1, a2 , index);
			}
			
			Arrays.sort(a2);
		}
		
	}

	private static void swap(int[] a1, int[] a2, int index) {
		int temp = a1[index];
		a1[index] = a2[0];
		a2[0] = temp;
		
	}

	private static void printarray(int[] arr) {
		
		for (int a : arr) {
			System.out.print(a + " ");
		}
		System.out.println();
	}

}
