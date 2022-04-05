package com.sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BucketSort {

	public static void main(String args[]) {

		int[] arr = { 80, 50, 30, 10, 90, 60, 0, 70, 40, 20, 50 };

		BucketSort b = new BucketSort();
		b.sort(arr);
		System.out.println("bucket sorting");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ",");
		}
	}

	private void sort(int[] arr) {

		int max = Arrays.stream(arr).max().getAsInt();
		int min = Arrays.stream(arr).min().getAsInt();
		int range = max - min;
		int noOfBucket = 5;
		int bucketRange = (int) Math.ceil((double) range / noOfBucket);
		// Create a bucket Array
		List<Integer>[] buckets = new List[noOfBucket];

		// Associate a list with each index in the bucket array
		for (int i = 0; i < noOfBucket; i++) {
			buckets[i] = new LinkedList<>();
		}

		// assgin number from array to the proper bucket
		for (int num : arr) {
			buckets[hash(num, bucketRange, noOfBucket)].add(num);
		}

		// sort buckets
		for (List<Integer> bucket : buckets) {
			Collections.sort(bucket);
		}

		// Merge bucket to get sorted arrays
		int idx = 0;
		for (List<Integer> bucket : buckets) {
			for (int num : bucket) {
				arr[idx++] = num;
			}
		}

	}

	private int hash(int num, int bucketRange, int noOfBucket) {

		int bucketIdx = num / bucketRange;
		// Maximum value will be assgined to the last bucket
		if (bucketIdx >= noOfBucket) {
			bucketIdx = noOfBucket - 1;
		}
		return bucketIdx;
	}
}
