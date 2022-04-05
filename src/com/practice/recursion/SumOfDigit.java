package com.practice.recursion;

public class SumOfDigit {

	public static void main(String[] args) {

		int digit = 0;

		System.out.println(sum(digit));

	}

	private static int sum(int digit) {

		if (digit / 10 == 0) {
			return digit;
		}

		int rem = digit % 10;
		return rem + sum(digit / 10);

	}

}
