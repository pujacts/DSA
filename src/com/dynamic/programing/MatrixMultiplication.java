package com.dynamic.programing;

public class MatrixMultiplication {

    public static void main(String[] args) {
        int[] arr = {40, 20, 30, 10, 30};
        int N = 5;
        //System.out.println(matrixMultiplication(N, arr));
        System.out.println(matrixMultiplication2(N, arr));
    }

    private static int matrixMultiplication1(int n, int[] p) {
        int m[][] = new int[n][n];

        int i, j, k, L, q;
        for (i = 1; i < n; i++)
            m[i][i] = 0;

        // L is chain length.
        for (L = 2; L < n; L++)
        {
            for (i = 1; i < n - L + 1; i++)
            {
                j = i + L - 1;
                if (j == n)
                    continue;
                m[i][j] = Integer.MAX_VALUE;
                for (k = i; k <= j - 1; k++)
                {
                    // q = cost/scalar multiplications
                    int l = m[i][k];
                    int r = m[k+1][j];

                    int m1 = p[i - 1] * p[k] * p[j];
                     q = l+r+m1;
                    if (q < m[i][j])
                        m[i][j] = q;
                }
            }
        }

        return m[1][n - 1];
    }

    private static int matrixMultiplication(int N, int[] arr) {
        int [][] dp = new int[100][100];
        return matrixMultiplication(arr, 1,N-1,dp);
    }

    private static int matrixMultiplication(int[] arr, int i, int j, int[][] dp) {
        if(i==j) return 0;

        if(dp[i][j]!=0) return dp[i][j];
        dp[i][j] = Integer.MAX_VALUE;

        for(int k = i; k < j; k++){
            dp[i][j] = Math.min(dp[i][j],matrixMultiplication(arr, i, k, dp) +
                    matrixMultiplication(arr, k+1, j, dp) + arr[i-1] * arr[k] * arr[j]);

        }

        return dp[i][j];
    }

    static int matrixMultiplication2(int N, int arr[])
    {
        int [][] dp = new int[N][N];
        for(int i=1; i<N ; i++){
            dp[i][i] = 0;
        }
        for(int i = N-1; i>=1; i--){
            for(int j = i+1; j<N; j++){
                dp[i][j] = Integer.MAX_VALUE;
                for(int k = i; k<j; k++){
                    dp[i][j] = Math.min(dp[i][j],dp[i][k] +
                            dp[k+1][j] + arr[i-1]* arr[k] * arr[j]);

                }
            }
        }

        return dp[1][N-1];

    }
}
