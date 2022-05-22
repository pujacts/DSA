package com.recursion.backtracking;

public class Maze1 {

	public static void main(String[] args) {

		boolean[][] maze = { { true, true, true }, { true, false, true }, { true, true, true } };

		path(maze, "", 0, 0);

	}

	private static void path(boolean[][] maze, String p, int r, int c) {

		if (r == maze.length - 1 && c == maze[0].length - 1) {
			System.out.println(p);
			return;
		}

		if (!maze[r][c]) {
			return;
		}
		if (r < maze.length - 1) {
			path(maze, p + 'D', r + 1, c);

		}

		if (c < maze[0].length - 1) {
			path(maze, p + 'R', r, c + 1);

		}
	}

}
