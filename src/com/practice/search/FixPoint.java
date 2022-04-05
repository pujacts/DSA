package com.practice.search;

public class FixPoint {

	public static void main(String[] args) {
		int[] arr = { -10, -2, 0, 3, 11, 12, 35, 51, 200 };

		System.out.println(fixPoint(arr));;
		System.out.println(fixPoint2(arr));;
	}

	private static int fixPoint2(int[] arr) {
		int size = arr.length-1;
		if(size == 1) {
			if(arr[0] == 0) {
				return 0;
			} else 
				return Integer.MIN_VALUE;
		}
		int low = 0;
		int high = size;
		while(low<=high) {
			int mid = (low+high)/2;
			if(arr[mid] == mid) {
				return mid;
			}
			if(arr[mid]>mid) {
				high = mid-1;
			} else {
				low = mid+1;
			}
		}
		return Integer.MIN_VALUE;
	}

	private static int fixPoint(int[] arr) {
		
		int size = arr.length-1;
		for(int i = 0 ; i< size ; i++) {
			if(arr[i]==i) {
				return i;
			}
		}
		return Integer.MIN_VALUE;
		
	}

}
