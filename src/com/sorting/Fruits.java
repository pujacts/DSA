package com.sorting;

import java.util.*;

public class Fruits {

	public static int foo(List<String> codeList, List<String> shoppingCart) {
		Stack<String> orderStack = new Stack<>();
		Stack<Stack<String>> codeStack = new Stack<>();
		boolean isFound = false;
		String orderFruit = "";
		String prevCodeFruit = "";

		if (codeList.isEmpty()) {
			return 1;
		}

		pushCodeStack(codeList, codeStack);
		pushOrderStack(shoppingCart, orderStack);

		while (!codeStack.isEmpty()) {
			Stack<String> codeFruitStack = codeStack.pop();
			isFound = false;
			while (!codeFruitStack.isEmpty()) {
				String codeFruit = codeFruitStack.pop();
				if (orderStack.isEmpty()) {
					return 0;
				}

				if (isFound) {
					orderFruit = orderStack.pop();

					if (!checkFruit(codeFruit, orderFruit)) {
						isFound = false;
						codeFruitStack.push(prevCodeFruit);
					}
				}

				while (!isFound && !orderStack.isEmpty()) {
					orderFruit = orderStack.pop();
					if (checkFruit(codeFruit, orderFruit)) {
						isFound = true;
					}
				}

				prevCodeFruit = codeFruit;
			}
		}

		if (!isFound && orderStack.isEmpty()) {
			return 0;
		}

		return 1;
	}

	private static void pushOrderStack(List<String> shoppingCart, Stack<String> orderStack) {
		for (int j = shoppingCart.size() - 1; j >= 0; j--) {
			orderStack.push(shoppingCart.get(j));
		}	}

	private static void pushCodeStack(List<String> codeList, Stack<Stack<String>> codeStack) {
		for (int j = codeList.size() - 1; j >= 0; j--) {
			Stack<String> stringStack = new Stack<>();
			String code = codeList.get(j);
			String[] codeFruits = code.split(" ");

			for (int i = codeFruits.length - 1; i >= 0; i--) {
				stringStack.push(codeFruits[i]);
			}
			codeStack.push(stringStack);
		}
	}

	private static boolean checkFruit(String codeFruit, String orderFruit) {
		if (codeFruit.equalsIgnoreCase("anything")) {
			return true;
		} else if (codeFruit.equalsIgnoreCase(orderFruit)) {
			return true;
		} else {
			return false;
		}
	}

}
