package com.practice.recursion;

public class Recursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		System.out.println(fib(40));
	}

	private static int fib(int n) {
		if(n==1 || n==2) {
			return 1;
		}
		return fib(n-1) + fib(n-2);
	}

}
