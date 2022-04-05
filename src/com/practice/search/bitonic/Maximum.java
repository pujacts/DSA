package com.practice.search.bitonic;

public class Maximum {

	public static void main(String[] args) {

		Maximum max = new Maximum();
		int[] arr = { 8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1 };
		max.find(arr);
		int maximum = max.findUsingBinarySearch(arr, 0, arr.length-1);

		int arr1[] = { 1, 3, 50, 10, 9, 7, 6 };
		max.find(arr1);
		int maximum1 = max.findUsingBinarySearch(arr1, 0, arr1.length-1);
		int arr2[] = { 120, 100 };
		max.find(arr2);
		int maximum2 = max.findUsingBinarySearch(arr2, 0, arr2.length-1);
		System.out.println("-------------------------------------------------");
		System.out.println("maximum element using binary search :" + maximum);
		System.out.println("maximum element using binary search :" + maximum1);
		System.out.println("maximum element using binary search :" + maximum2);
	}

	private int findUsingBinarySearch(int[] arr, int low, int high) {

		if (low == high) {
			return arr[low];
		}
		int mid = (low + high) / 2;
		if (mid == 0 && arr[low] > arr[high]) {
			return arr[low];
		} else if (mid == 0 && arr[high] > arr[low]) {
			return arr[high];
		}

		if (arr[mid + 1] < arr[mid] && arr[mid - 1] < arr[mid]) {
			return arr[mid];
		}

		if (arr[mid] < arr[mid - 1] && arr[mid] > arr[mid + 1]) {
			return findUsingBinarySearch(arr, low, mid - 1);
		} else {
			return findUsingBinarySearch(arr, mid + 1, high);
		}

	}

	private void find(int[] arr) {
		int size = arr.length;
		int max = arr[0];
		for (int i = 1; i < size; i++) {
			if (arr[i] > max) {
				max = arr[i];
			} else {
				break;
			}
		}

		System.out.println("maximum element is:" + max);

	}

}
