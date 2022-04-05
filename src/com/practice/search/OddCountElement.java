package com.practice.search;

public class OddCountElement {

	public static void main(String[] args) {

		OddCountElement a = new OddCountElement();
		int arr[] = new int[] { 1, 2, 3, 4, 3, 2, 1 };
		System.out.println("get odd occurance  using xor:" + a.getOddOccurance(arr));

		int arr1[] = new int[] { 10, 25, 30, 10, 15, 25, 15, 40 };
		System.out.println("get odd occurance  for two number using xor:");
		a.getOddOccuranceForTwo(arr1);

	}

	private void getOddOccuranceForTwo(int[] arr) {
		int i;
		int res = 0;
		for (i = 0; i < arr.length; i++) {
			res = res ^ arr[i];
		}

		// find right most set bit ;
		int diff = res - 1;
		int neg = ~diff;
		int setbit = res & neg;

		// divide elements in two groups : Elements having setbit as 1 and element
		// having setbit as 0. Even
		// elements cancelled themselves if group and we get out numbers
		int x = 0;
		int y = 0;
		for (i = 0; i < arr.length; i++) {

			if ((arr[i] & setbit) != 0) {
				x = x ^ arr[i];
			} else {
				y = y ^ arr[i];
			}
		}
		System.out.println(x + "," + y);
	}

	private int getOddOccurance(int[] arr) {
		int i;
		int res = 0;
		for (i = 0; i < arr.length; i++) {
			res = res ^ arr[i];
		}
		return res;
	}

}
