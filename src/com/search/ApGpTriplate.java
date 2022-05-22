package com.search;

public class ApGpTriplate {

	public static void main(String[] args) {

		ApGpTriplate ap = new ApGpTriplate();
		int[] arr = { 2, 4, 10, 12, 14, 18, 36 };
		System.out.println("----------AP-----------");
		ap.findAp(arr);
		System.out.println("----------GP-----------");
		int[] arr1 = { 1, 2, 4, 8, 16 };
		ap.findGp(arr1);

	}

	private void findGp(int[] arr) {
		int size = arr.length;
		for (int i = 1; i < size-1; i++) {
			int j = i - 1;
			int k = i + 1;
			while (j >= 0 && k < size) {
				if (arr[j] * arr[k] == arr[i] * arr[i]) {
					System.out.println(arr[j] + "," + arr[i] + "," + arr[k]);
					k++;
					j--;
				} else if (arr[j] + arr[k] < 2 * arr[i]) {
					k++;
				} else {
					j--;
				}
			}
		}

	}

	private void findAp(int[] arr) {
		int size = arr.length;
		for (int i = 1; i < size - 2; i++) {
			int j = i - 1;
			int k = i + 1;
			while (j >= 0 && k < size) {
				if (arr[j] + arr[k] == 2 * arr[i]) {
					System.out.println(arr[j] + "," + arr[i] + "," + arr[k]);
					k++;
					j--;
				} else if (arr[j] + arr[k] < 2 * arr[i]) {
					k++;
				} else {
					j--;
				}
			}
		}

	}

}
