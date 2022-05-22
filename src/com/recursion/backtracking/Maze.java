package com.recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Maze {

	public static void main(String[] args) {
		System.out.println(count(3, 2));

		// print path
		count1("", 3, 3);

		// path diagonal
		List<String> paths = pathDiagonal("", 3, 3);
		System.out.println(paths);

	}

	private static List<String> pathDiagonal(String p, int r, int c) {
		if (r == 1 || c == 1) {
			List<String> pathList = new ArrayList<>();
			pathList.add(p);
			return pathList;
		}
		
		List<String> paths = new ArrayList<>();
		if(r>1 && c>1) {
			paths.addAll(pathDiagonal(p+ 'd', r-1, c-1));
		}
		if(r>1) {
			paths.addAll(pathDiagonal(p+ 'v', r-1, c));
		}
		if(c>1) {
			paths.addAll(pathDiagonal(p+ 'l', r, c-1));
		}
		return paths;

	}

	private static void count1(String p, int r, int c) {

		if (r == 1 || c == 1) {
			System.out.println(p);
			return;
		}

		count1(p + "R", r, c - 1);
		count1(p + "D", r - 1, c);
	}

	private static int count(int r, int c) {

		if (r == 1 || c == 1) {
			return 1;
		}

		int left = count(r, c - 1);
		int right = count(r - 1, c);

		return left + right;
	}

}
