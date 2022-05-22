package com.recursion;

import java.util.ArrayList;

public class Subset {

	public static void main(String[] args) {

		String str = "abc";
		findSubset(str, new String());

		ArrayList<String> list = findSubsetWithReturnType(str, new String());
		System.out.println(list);

	}

	private static void findSubset(String str, String result) {

		if (str.isEmpty()) {
			System.out.println(result);
			return;
		}

		char ch = str.charAt(0);
		findSubset(str.substring(1), result + ch);
		findSubset(str.substring(1), result);

	}

	private static ArrayList<String> findSubsetWithReturnType(String str, String result) {

		if (str.isEmpty()) {
			ArrayList<String> list = new ArrayList<>();
			list.add(result);
			return list;
		}

		char ch = str.charAt(0);
		ArrayList<String> leftList = findSubsetWithReturnType(str.substring(1), result + ch);
		ArrayList<String> rightList = findSubsetWithReturnType(str.substring(1), result);
		leftList.addAll(rightList);
		return leftList;

	}
	

}
