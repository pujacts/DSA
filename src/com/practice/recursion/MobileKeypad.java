package com.practice.recursion;

import java.util.ArrayList;
import java.util.List;

public class MobileKeypad {

	public static void main(String[] args) {

		pad("", "");
		
		List<String> pads = pad1("", "23");
		
		System.out.println(pads);

	}

	private static void pad(String p, String up) {

		if (up.isEmpty()) {
			System.out.println(p);
			return;
		}

		int digit = up.charAt(0) - '1';

		int start = (digit - 1) * 3;
		int end = (digit * 3) - 1;

		for (int i = start; i <= end; i++) {
			char ch = (char) ('a' + i);
			pad(p + ch, up.substring(1));
		}

	}
	
	 public static List<String> pad1(String p , String up ){
		 List<String> str = new ArrayList<>();
	        if(up.isEmpty()){
	            
	            str.add(p);
	            return str;
	        }
	        
	    List<String> arrList = new ArrayList<>();
	        
	       int digit = up.charAt(0) - '1';

			int start = (digit - 1) * 3;
			int end = (digit * 3) - 1;

			for (int i = start; i <= end; i++) {
				char ch = (char) ('a' + (i));
				arrList.addAll(pad1(p + ch, up.substring(1)));
			}
	         return arrList;
	    }
	    

}
