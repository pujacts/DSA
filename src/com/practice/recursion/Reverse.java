package com.practice.recursion;

public class Reverse {

	public static void main(String[] args) {
		
		System.out.println(reverse(12345));

	}

	private static int reverse(int n) {
		
		int sum = 0;
		 return rev(n, sum);
		
	}

	private static int rev(int n, int sum) {
		
		if(n == 0) {
			return sum;
		}
		
		sum = (sum*10)+n%10;
		return rev(n/10, sum);
		 
		
	}

}
