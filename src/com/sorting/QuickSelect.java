package com.sorting;

public class QuickSelect {

	public static void main(String[] args) {
		int[] arr = { 5, 6, 2, 9, 7, 3, 1 };
		// 0 1 2 3 4 5 6 7 8 9 10
		// 1 2 3 4 6 7 8 9 10 20
		System.out.println(KthSmallest(arr, 3));
//		System.out.println(get(arr, 8));
//		System.out.println(get(arr, 4));
	}

	private static int KthSmallest(int[] arr, int k) {

		quickSort(arr, 0, arr.length-1, k);

		return arr[k];
	}

	private static void quickSort(int[] arr, int low, int high, int k) {
			int pi = partition(arr,low, high);
			if(pi==k){
				return;
			}
			if(k<pi){
				quickSort(arr, low, pi-1, k);
			}
			if (k > pi) {
				quickSort(arr, pi + 1, high, k);
			}
	}

	private static int partition(int[] arr, int low, int high) {

		int pivot = arr[high];
		int i = low-1;

		for(int j =low; j< high; j++){
			if(arr[j]<pivot){
				i++;
				swap(arr, i, j);
			}
		}

		swap(arr, i+1,high);
		return i+1;
	}

	private static void swap(int[] arr, int i, int j) {

		int temp = arr[i];
		arr[i] = arr[j];
		arr[j]= temp;
	}


}
