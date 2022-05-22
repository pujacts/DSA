package com.recursion.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Maze3 {

	public static void main(String[] args) {

		boolean[][] maze = { { true, true, true }, { true, true, true }, { true, true, true } };

		path(maze, "", 0, 0);

		int[][] paths = new int[maze.length][maze[0].length];
		path1(maze, "", 0, 0, paths, 1);

	}

	private static void path1(boolean[][] maze, String p, int r, int c, int[][] paths, int step) {
		if (r == maze.length - 1 && c == maze[0].length - 1) {
			paths[r][c] = step;
			for (int[] arr : paths) {
				System.out.println(Arrays.toString(arr));
			}
			return;
		}

		if (!maze[r][c]) {
			return;
		}
		maze[r][c] = false;
		paths[r][c] = step;
		List<List<Integer>> pathList = new ArrayList<>();
		if (r < maze.length - 1) {
			path1(maze, p + 'D', r + 1, c, paths, step + 1);

		}
		
		if (c < maze[0].length - 1) {
			path1(maze, p + 'R', r, c + 1, paths, step + 1);

		}

		if (r > 0) {
			path1(maze, p + 'U', r - 1, c, paths, step + 1);

		}

		if (c > 0) {
			path1(maze, p + 'L', r, c - 1, paths, step + 1);

		}

		maze[r][c] = true;
		paths[r][c] = 0;
	}

	private static void path(boolean[][] maze, String p, int r, int c) {

		if (r == maze.length - 1 && c == maze[0].length - 1) {
			System.out.println(p);
			return;
		}

		if (!maze[r][c]) {
			return;
		}
		maze[r][c] = false;
		List<List<Integer>> pathList = new ArrayList<>();
		if (r < maze.length - 1) {
			path(maze, p + 'D', r + 1, c);

		}

		if (c < maze[0].length - 1) {
			path(maze, p + 'R', r, c + 1);

		}

		if (r > 0) {
			path(maze, p + 'U', r - 1, c);

		}

		if (c > 0) {
			path(maze, p + 'L', r, c - 1);

		}

		maze[r][c] = true;
	}

}
