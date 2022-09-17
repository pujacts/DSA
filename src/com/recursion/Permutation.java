package com.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {

	public static void main(String[] args) {

		String str = "ABB";
		char[] strSort = str.toCharArray();
		Arrays.sort(strSort);
		perm(str, new String());

		List<String> list = perm1(new String(strSort), "");
		System.out.println(list);
	}

	private static List<String> perm1(String up, String p) {

		if (up.isEmpty()) {
			List<String> permList = new ArrayList<>();
			permList.add(p);
			return permList;
		}

		List<String> prmList2 = new ArrayList<>();
		char ch = up.charAt(0);
		for (int i = 0; i <= p.length(); i++) {
			String first = p.substring(0, i) + ch + p.substring(i, p.length());
			List<String> prmList1 = perm1(up.substring(1), first);
			prmList2.addAll(prmList1);
		}
		return prmList2;
	}

	private static void perm(String up, String p) {

		if (up.isEmpty()) {
			System.out.println(p);
			return;
		}

		for (int i = 0; i <= p.length(); i++) {
			String first = p.substring(0, i) + up.charAt(0) + p.substring(i, p.length());
			perm(up.substring(1), first);
		}

	}

}
