package com.dynamic.programing;

public class GoldMinesProblem {

    static int maxGold(int n, int m, int M[][]) {
        int total = 0;
        for (int i = 0; i < M.length; i++) {
            total = Math.max(total, solve(M, i, 0));
        }
        return total;
    }

    static int solve(int M[][], int row, int col) {
        if (row < 0 || row >= M.length || col >= M[row].length) return 0;

        int up = M[row][col] + solve(M, row - 1, col + 1);
        int right = M[row][col] + solve(M, row, col + 1);
        int down = M[row][col] + solve(M, row + 1, col + 1);

        return Math.max(up, Math.max(right, down));
    }

    public static void main(String[] args) {
        int n = 3;
        int m = 3;
        int gold [][] = {{1, 3, 3},
                {2, 1, 4},
                {0, 6, 4}};
        System.out.println(maxGold(n, m, gold));
    }

    static int solve(int M[][], int row, int col, int dp[][]) {
        if (row < 0 || row >= M.length || col >= M[row].length) return 0;

        if(dp[row][col]!=0) return dp[row][col];
        int up = M[row][col] + solve(M, row - 1, col + 1, dp);
        int right = M[row][col] + solve(M, row, col + 1, dp);
        int down = M[row][col] + solve(M, row + 1, col + 1, dp);

        return dp[row][col] = Math.max(up, Math.max(right, down));
    }
}
