package com.practice.recursion;

public class SkipString {

	public static void main(String[] args) {

		skip("dheerajpuja", new String());

		System.out.println(skip1("dheerajpuja"));
		System.out.println(skipApple("dheerajapplepuja"));

	}

	private static String skipApple(String up) {

		if (up.isEmpty()) {
			return "";
		}
		char ch = up.charAt(0);
		if (up.startsWith("apple")) {
			return skipApple(up.substring(5));
		} else {
			return ch + skipApple(up.substring(1));
		}
		
	}

	private static String skip1(String up) {
		if (up.isEmpty()) {
			return "";
		}
		char ch = up.charAt(0);
		if (ch == 'a') {
			return skip1(up.substring(1));
		} else {
			return ch + skip1(up.substring(1));
		}
	}

	private static void skip(String up, String p) {

		if (up.isEmpty()) {
			System.out.println(p);
			return;
		}

		char ch = up.charAt(0);
		if (ch == 'a') {
			skip(up.substring(1), p);
		} else {
			skip(up.substring(1), p + ch);
		}

	}

}
