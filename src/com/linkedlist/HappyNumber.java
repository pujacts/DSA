package com.linkedlist;

class HappyNumber {

	public static void main(String args[]) {
		HappyNumber hn = new HappyNumber();

		System.out.println(hn.isHappy(19));
	}

	public boolean isHappy(int n) {

		int slow = n;
		int fast = n;

		do {
			slow = squareSum(slow);
			fast = squareSum(squareSum(fast));
		} while (fast != slow);

		if (slow == 1)
			return true;
		else
			return false;
	}

	public int squareSum(int n) {
		int ans = 0;

		while (n > 0) {
			int rem = n % 10;
			ans = ans + (rem * rem);
			n = n / 10;
		}

		return ans;
	}
}